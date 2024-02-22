package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.entity.Course;
import com.example.coursemanagementsystem.entity.Instructor;
import com.example.coursemanagementsystem.repository.CourseRepository;
import com.example.coursemanagementsystem.repository.InstructorRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
    private InstructorRepository instructorRepository;
	@Autowired
    private CourseRepository courseRepository;

    public CourseController(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("")
    public String getListPage(Model model){
        var courses = courseRepository.findAll();
        model.addAttribute("courses",courses);
        return "courses/list";
    }

    @GetMapping("/create")
    public String getCreatePage(@ModelAttribute Course course, Model model){
        var instructors =  instructorRepository.findAll();
        model.addAttribute("course",course);
        model.addAttribute("instructors",instructors);
        return "courses/create";
    }

    @PostMapping("/create")
    public String handleCreate(@Valid Course course, BindingResult result, Model model){

        if(result.hasErrors()) {
            var instructors =  instructorRepository.findAll();
            model.addAttribute("instructors",instructors);
            return "courses/create";
        }

        courseRepository.save(course);

        return "redirect:/courses";
    }

    @GetMapping("/{courseId}/delete")
    public String handleDelete(@PathVariable int courseId){

        courseRepository.deleteById(courseId);

        return "redirect:/courses";
    }

    @GetMapping("/{courseId}")
    public String getDetailPage(@PathVariable int courseId, Model model){

        var course = courseRepository.getReferenceById(courseId);

        if(course.getInstructor() == null)
            course.setInstructor(new Instructor());

        model.addAttribute("course",course);

        return "courses/detail";
    }

    @GetMapping("/{courseId}/edit")
    public String getDetailEditPage(@PathVariable int courseId, Model model){

        var course = courseRepository.getReferenceById(courseId);
        var instructors =  instructorRepository.findAll();
        model.addAttribute("course",course);
        model.addAttribute("instructors",instructors);

        return "courses/detailEdit";
    }

    @PostMapping("/{courseId}/edit")
    public String HandleEditDetail(@Valid Course course,
                                   BindingResult result,
                                   Model model,
                                   @PathVariable int courseId
    ){
        if(course.getInstructor() == null)
            result.addError(new FieldError("nullInstructor","instructor","must choose an instructor."));
        if(result.hasErrors()) {
            var instructors =  instructorRepository.findAll();
            model.addAttribute("instructors",instructors);
            return "courses/detailEdit";
        }

        courseRepository.save(course);

        model.addAttribute("course",course);

        return "redirect:/courses/" + courseId;
    }
}
