package com.ing.bfsi.employeeDB.repository;

import java.util.Optional;

import com.ing.bfsi.employeeDB.exception.RecordNotFoundException;
import com.ing.bfsi.employeeDB.model.Employee;
//repository that extends CrudRepository
public interface EmployeeRepository 
{
	public int save(Employee employee) throws Exception;

	public Employee findById(int id) throws RecordNotFoundException;

	public void deleteById(int id)  throws Exception;

	public Iterable<Employee> findAll() throws RecordNotFoundException;

	public int update(Employee employee) throws Exception;


	
}