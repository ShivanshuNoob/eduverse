package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;//all specs Java EE supplied

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
/*
 *   <tr key={employee.id}>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.location}</td>
                <td>{employee.department}</td>
                <td>{employee.joinDate}</td>
                <td>{employee.salary}</td>
                <td>
 */
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "emps") // to specify table name
public class Employee extends BaseEntity {

	@Column(length = 20) // varchar(20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL constraint
	private String password;	
	
	private LocalDate joinDate;
	private double salary;
	@Column(length = 30)
	private String location;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Department department;

//	public Employee() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	

//	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate, double salary,
//			String location, Department department) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.joinDate = joinDate;
//		this.salary = salary;
//		this.location = location;
//		this.department = department;
//	}


	

}
