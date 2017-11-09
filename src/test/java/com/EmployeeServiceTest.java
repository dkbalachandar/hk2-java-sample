package com;

import com.model.Employee;
import com.service.EmployeeService;
import org.junit.Test;
import org.jvnet.hk2.testing.junit.HK2Runner;

import javax.inject.Inject;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

public class EmployeeServiceTest  extends HK2Runner{

    @Inject
    private EmployeeService employeeService;

    @Test
    public void testAdd(){

        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        Employee newEmp = employeeService.add(employee);
        assertNotNull(newEmp);
        assertEquals("First Name", newEmp.getFirstName());
        assertEquals("Last Name", newEmp.getLastName());
        assertNotNull(newEmp.getId());

    }

    @Test
    public void testFetch(){
        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        Employee newEmp = employeeService.add(employee);
        Employee fetchEmp = employeeService.fetch(newEmp.getId());
        assertEquals(newEmp, fetchEmp);
    }

    @Test
    public void testUpdate(){

        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        Employee newEmp = employeeService.add(employee);
        newEmp.setFirstName("Bala");
        employeeService.update(newEmp);
        Employee fetchEmp = employeeService.fetch(newEmp.getId());
        assertEquals("Bala", fetchEmp.getFirstName());

    }

    @Test
    public void testDelete(){

        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");
        Employee newEmp = employeeService.add(employee);
        employeeService.delete(newEmp.getId());
        Employee fetchEmp = employeeService.fetch(newEmp.getId());
        assertNull(fetchEmp);

    }


}