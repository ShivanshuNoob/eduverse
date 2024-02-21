package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Department;
import com.app.pojos.Employee;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class EmployeeDaoTest {
	
	@Autowired
	private EmployeeDao empDao;
	@Test
	void test() {
		System.out.println("In the Employee dao test");
//		List<Employee> list = List.of(
//				new Employee("a1", "b1", "a1@gmail.com", "1234", LocalDate.parse("2020-10-20"), 34567, "Pune", Department.DEV),
//				new Employee("a2", "b2", "a2@gmail.com", "2234", LocalDate.parse("2020-11-20"), 44567, "Pune", Department.SUPPORT),
//				new Employee("a3", "b3", "a3@gmail.com", "1274", LocalDate.parse("2023-10-20"), 14567, "Pune", Department.TEST),
//				new Employee("a4", "b4", "a4@gmail.com", "2234", LocalDate.parse("2022-10-20"), 40567, "Mumbai",Department.HR));
//		
//		List<Employee> list2=empDao.saveAll(list);
//		assertEquals(4,list2.size());
	}

}
