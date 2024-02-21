package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;


import lombok.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Instructor extends BaseEntity{
		@NotBlank
	    private String firstName;

	    @NotBlank
	    private String lastName;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "detail_id")
	    private InstructorDetail instructorDetail;

	    @OneToMany(mappedBy = "instructor")
	    private List<Course> courses;

	   

	   

}
