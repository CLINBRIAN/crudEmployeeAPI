package com.code.crud.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.crud.Controller.AddResponse;
import com.code.crud.Dao.EmployeeDao;
import com.code.crud.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	
	public Employee saveEmployee(Employee employee) {
		return dao.save(employee);
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		dao.findAll().forEach(e->employees.add(e));
		
		return employees;
	}
	
	public Employee getEmployee(Integer employeeId) {
		return dao.findById(employeeId).orElseThrow();	
	}
	
	public AddResponse deleteEmployee(Integer employeeId) {
		 dao.deleteById(employeeId);
		 AddResponse response = new AddResponse();
		 response.setMessage("delete success");
		 response.setId(employeeId);
		 
		 return response;
				 
	}
	public Employee updateEmployee(Employee employee) {
		 dao.findById(employee.getEmployeeId()).orElseThrow();
		 return dao.save(employee);
	}

}
