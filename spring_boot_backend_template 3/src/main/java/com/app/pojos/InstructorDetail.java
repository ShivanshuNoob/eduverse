package com.app.pojos;





import javax.persistence.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InstructorDetail extends BaseEntity {
	private String email;
    private String phone;

}
