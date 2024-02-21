package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import lombok.RequiredArgsConstructor;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Course extends BaseEntity {
	 @NotBlank
	    private String courseId;
	    @NotBlank
	    private String title;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "instructor_id")
	    private Instructor instructor;


	    @ManyToMany
	    @JoinTable(
	            name = "course_student",
	            joinColumns = @JoinColumn(name = "course_id"),
	            inverseJoinColumns = @JoinColumn(name = "student_id"))
	    private List<Student> students;

	    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
	    private List<Review> reviews;
	    
	    

}
