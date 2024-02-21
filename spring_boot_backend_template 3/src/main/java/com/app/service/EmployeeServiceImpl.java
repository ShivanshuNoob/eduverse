package com.app.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customException.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> getAllEmps() {
		
		return empDao.findAll();
	}

	@Override
	public Employee addEmpDeatails(Employee newEmp) {
		return empDao.save(newEmp); //persistance
	}//rets detached entity to the caller

	@Override
	public String deleteEmpDetails(Long empId) {
		if(empDao.existsById(empId)) {
			empDao.deleteById(empId);
			return "employee Deleted successfully";
		}
		return "Invalid Employee id";
	}

	@Override
	public Employee getEmployeeDetails(Long empId) {
		
		return empDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee id not found"));
	}

	@Override
	public Employee deleteEmpDetails(Employee emp) {
		
		return empDao.save(emp);
	}

	@Override
	public Employee updateNameById(Long empId,String name) {
		Employee emp=empDao.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee id not found"));
		emp.setFirstName(name);
		return emp;
	}

}
