package com.ing.bfsi.employeeDB.service;

import com.ing.bfsi.employeeDB.model.Employee;
import com.ing.bfsi.employeeDB.repository.EmployeeRepository;
import com.ing.bfsi.employeeDB.service.EmployeeService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {
	
	
    @InjectMocks
	static
    EmployeeService employeeService;
    
    @Mock
	static
    EmployeeRepository employeeRepository;
    
	  private static  Employee emp1;
	  private static  Employee emp2;
	  
	  @BeforeClass
	  public static void setUp(){
		  employeeService = mock(EmployeeService.class);
         employeeRepository =mock(EmployeeRepository.class);
	        emp1 = new Employee(8131,"CompilersPrinciples",
	                "sai.pranathib@gmail.com", 2008,1009,28);
	           emp2 = new Employee(123,"sai",
	                   "sai.pranathib@gmail.com", 2008,1009,28);
	 try {
		when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(emp1, emp2));
	    when(employeeService.getEmployeeById(8131)).thenReturn(emp1);
	    when(employeeService.save(emp1)).thenReturn(emp1.getEmployeeid());
	    when(employeeService.saveOrUpdate(emp1)).thenReturn(emp1.getEmployeeid());

	 } catch (Exception e) {
		e.printStackTrace();
	}

	  }


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEmployees() throws Exception{
        List<Employee> empList = employeeService.getAllEmployees();
         
        assertEquals(2, empList.size());
        Employee employee = empList.get(0);

        assertEquals(8131, employee.getEmployeeid());
        assertEquals("CompilersPrinciples", employee.getName());
        assertEquals("sai.pranathib@gmail.com", employee.getEmail());
        assertEquals(2008, employee.getSalary());
        assertEquals(1009, employee.getExp());
        assertEquals(28, employee.getAge());
}	  

    @Test
    public void testGetEmployeeById() throws Exception{    
    Employee employee = employeeService.getEmployeeById(8131);
    assertNotNull(employee);
    assertEquals(8131, employee.getEmployeeid());
    assertEquals("CompilersPrinciples", employee.getName());
    assertEquals("sai.pranathib@gmail.com", employee.getEmail());
    assertEquals(2008, employee.getSalary());
    assertEquals(1009, employee.getExp());
    assertEquals(28, employee.getAge());
}

    @Test
    public void testSaveEmployee() throws Exception{
      int empdId = employeeService.save(emp1);
      assertNotNull(empdId);
      assertEquals(emp1.getEmployeeid(), empdId);
    }
    
   @Test
    public void testSaveOrUpdateEmployee() throws Exception{
        int emp = employeeService.saveOrUpdate(emp1);
       assertNotNull(emp);
       assertEquals(emp1.getEmployeeid(),emp);
    }

    
    
    


}
