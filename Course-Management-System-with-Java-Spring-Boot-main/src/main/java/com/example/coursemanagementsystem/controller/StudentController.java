package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.entity.Course;
import com.example.coursemanagementsystem.entity.Student;
import com.example.coursemanagementsystem.repository.CourseRepository;
import com.example.coursemanagementsystem.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    public StudentController(StudentRepository studentRepository,CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("")
    public String getListPage(Model model){
        var students = studentRepository.findAll();
        model.addAttribute("students",students);

        return "students/list";
    }

    @GetMapping("/create")
    public String getCreatePage(@ModelAttribute Student student, Model model){
        model.addAttribute("student",student);
        return "students/create";
    }

    @PostMapping("/create")
    public String handleCreate(@Valid Student student, BindingResult result, Model model){
        if(result.hasErrors())
            return "students/create";

        System.out.println(student);
        studentRepository.save(student);

        return "redirect:/students";
    }

    @GetMapping("/{studentId}/delete")
    public String handleDelete(@PathVariable int studentId){

        studentRepository.deleteById(studentId);

        return "redirect:/students";
    }

    @GetMapping("/{studentId}")
    public String getDetailPage(@PathVariable int studentId, Model model){

        var student = studentRepository.getReferenceById(studentId);
        var selectedCourses = student.getCourses();
        var displayCourses = new ArrayList<Course>();
        var courses = courseRepository.findAll();
        for(var course : courses){
            if(!selectedCourses.contains(course))
                displayCourses.add(course);
        }


        model.addAttribute("student",student);
        model.addAttribute("courses",displayCourses);

        return "students/detail";
    }

    @GetMapping("/{studentId}/edit")
    public String getDetailEditPage(@PathVariable int studentId, Model model){
        var student = studentRepository.getReferenceById(studentId);
        model.addAttribute("student",student);

        return "students/detailEdit";
    }

    @PostMapping("/{studentId}/edit")
    public String HandleEditDetail(@Valid Student student,
                                   BindingResult result,
                                   Model model,
                                   @PathVariable int studentId
    ){
        if(result.hasErrors())
            return "students/detailEdit";

        studentRepository.save(student);

        return "redirect:/students/" + studentId;
    }

    @PostMapping("/{studentId}/addCourse")
    public String handleAddCourse(@PathVariable int studentId, HttpServletRequest request){
        var student = studentRepository.getReferenceById(studentId);
        var courseId = Integer.parseInt(request.getParameter("courseId"));
        var course = courseRepository.getReferenceById(courseId);
        var courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);
        studentRepository.save(student);

        return "redirect:/students/" + studentId;
    }

    @GetMapping("/{studentId}/deselect/{courseId}")
    public String handleDeselct(@PathVariable int studentId,@PathVariable int courseId,@RequestParam(required = false) String source){
        System.out.println(studentId);
        System.out.println(courseId);
        var student = studentRepository.getReferenceById(studentId);
        var course = courseRepository.getReferenceById(courseId);
        var courses= student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
        studentRepository.save(student);
        if(source != null && source.equals("course"))
            return "redirect:/courses/" + courseId;
        return "redirect:/students/" + studentId;
    }
}
