package com.app.pojos;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;


import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Review extends BaseEntity {
	private String comment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    
}
