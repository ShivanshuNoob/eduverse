package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponce;
import com.app.pojos.Employee;
import com.app.service.EmployeeService;



@RestController
@RequestMapping("/employees")
//@CrossOrigin(origins ="http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	public EmployeeController() {
		System.out.println("In constructor of "+getClass());
	}
	
	//Rest Api end point 
	//'http://localhost:8080/employees/'
	//Method : GET
	//resp :List<Employee>
	@GetMapping
	public ResponseEntity<?>  listAllEmployee(){
	     try {
	    	 return new ResponseEntity<>(empService.getAllEmps(),HttpStatus.OK);
	     }catch(RuntimeException e) {
	    	 return new ResponseEntity<>(new ApiResponce(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	}
	//http://localhost:8080/employees/
	//METHOD : POST
	//resp : Detached Employee
	@PostMapping
	public ResponseEntity<?> addEmpDetails(@RequestBody Employee newEmp) {
		System.out.println("in Add Employee "+ newEmp);
		
		return new ResponseEntity<>(empService.addEmpDeatails(newEmp),HttpStatus.OK);
		
	}
	
	//URL : http://localhost:8080/employees/empId
	//Method : DELETE
	//resp:  mesg(string)
	@DeleteMapping("/{empId}")
	//@PathVariable is for Data binding from the incomming uri variable
	//-> method args
	public String deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("In delete Employee");	
		return empService.deleteEmpDetails(empId);
	}
	
	
	@GetMapping("/{empId}")
	public Employee getEmpDetails(@PathVariable Long empId) {
		System.out.println("In get Employee Details");
		return empService.getEmployeeDetails(empId);
	}
}
