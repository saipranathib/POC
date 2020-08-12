package com.ing.bfsi.employeeDB.DAOImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ing.bfsi.employeeDB.exception.RecordNotFoundException;
import com.ing.bfsi.employeeDB.model.Employee;
import com.ing.bfsi.employeeDB.repository.EmployeeRepository;

@Repository
public class EmployeeDAOImpl implements EmployeeRepository {

	@Autowired
	JdbcTemplate template;    

   

	@Override
	public int save(Employee fromAccount) {
		
        String query = "INSERT INTO employee(id,name,email,salary,exp,age) VALUES(?,?,?,?,?,?)";
        return template.update(query,fromAccount.getEmployeeid(),
        		fromAccount.getName(),fromAccount.getEmail(),
        		fromAccount.getSalary(),fromAccount.getExp(),fromAccount.getAge());


	}


	@Override
	public Employee findById(int id) throws RecordNotFoundException {
	       String query = "SELECT * FROM employee WHERE id=?";
	       Employee account = template.queryForObject(query,new Object[]{id},
	       		new BeanPropertyRowMapper<>(Employee.class));
	   if(null!=account)
	   {
	       return account;

	   }
	   else
	   {
	         throw new RecordNotFoundException("No employee record exist");

	   }
	       

	}


	@Override
	public void deleteById(int id) {
         template.update("delete from employee where id=?", new Object[] {
                id
            });
		
	}


	@Override
	public Iterable<Employee> findAll() {
        return template.query("select * from employee",new BeanPropertyRowMapper<>(Employee.class));
	}


	@Override
	public int update(Employee employee) {
        return template.update("update employee " + " set name = ?, email = ? ,salary=?,exp=?,age=?" + " where id = ?",
                new Object[] {
                    employee.getName(),employee.getEmail(),employee.getSalary(),employee.getExp(),employee.getAge(),
                    employee.getId()
                });
        }

}
