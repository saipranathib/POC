package com.ing.bfsi.employeeDB.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bfsi.employeeDB.exception.RecordNotFoundException;
import com.ing.bfsi.employeeDB.model.Employee;
import com.ing.bfsi.employeeDB.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
 EmployeeRepository employeeRepository;
  
  public int save(Employee employee) throws Exception 
  {
	 employeeRepository.save(employee);
	return employee.getEmployeeid();
  }

  public void delete(int id)    throws Exception
  {  
	   employeeRepository.deleteById(id);  
  }  
public List<Employee> getAllEmployees()  throws RecordNotFoundException
 {
	 List<Employee> employees=new ArrayList<Employee>();
	 employeeRepository.findAll().forEach(emp->employees.add(emp));	
	 
	 employees.sort(Comparator.comparing(Employee::getName));
	 if (employees.isEmpty()){
         throw new RecordNotFoundException("No employee record exist");

	 }
	 else{
	 return employees;
	 }
 }
 public Employee getEmployeeById(int id) throws Exception
 {
	 Employee employee = employeeRepository.findById(id);  
	 if(null !=employee) {
         return employee;
     } else {
         throw new RecordNotFoundException("No employee record exist for given id");
     } 

 } 
 public int saveOrUpdate(Employee employee) throws Exception 
 {
	 return employeeRepository.update(employee);
	
 }


  
}
