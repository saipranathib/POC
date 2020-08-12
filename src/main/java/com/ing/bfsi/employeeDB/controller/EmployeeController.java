package com.ing.bfsi.employeeDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bfsi.employeeDB.model.Employee;
import com.ing.bfsi.employeeDB.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
    EmployeeService employeeService;
	
	@RequestMapping("/save")
	private int saveEmployee(@RequestBody Employee employee) throws Exception
	{
		employeeService.save(employee);
	    return employee.getEmployeeid();
	}

	@RequestMapping("/getAllEmployees")
	private List<Employee> getAllEmloyees() throws Exception
	{
		return employeeService.getAllEmployees();
		
		
	}
	
	@RequestMapping("/getEmployee/{employeeid}")
	private Employee getEmployee(@PathVariable("employeeid") int employeeid) throws Exception
	{
		return employeeService.getEmployeeById(employeeid);
	}

	@PutMapping("/update")  
	private Employee update(@RequestBody Employee employee) throws Exception   
	{  
		employeeService.saveOrUpdate(employee);  
	    return employee;  
	}  

	@RequestMapping("/delete/{employeeid}")  
	private void deleteEmployeeyId(@PathVariable("employeeid") int employeeid) throws Exception   
	{  
		 employeeService.delete(employeeid);  
	}  


}
