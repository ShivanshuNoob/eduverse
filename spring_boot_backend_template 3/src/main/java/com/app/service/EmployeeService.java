package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmps();
	Employee addEmpDeatails(Employee newEmp);
	String deleteEmpDetails(Long empId);
	Employee getEmployeeDetails(Long empId);
	Employee deleteEmpDetails(Employee emp);
	Employee updateNameById(Long empId,String name);
}
