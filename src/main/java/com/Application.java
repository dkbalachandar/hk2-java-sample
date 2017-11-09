package com;

import com.model.Employee;
import com.service.EmployeeService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class Application {

    public static void main(String[] args) {

        ServiceLocator serviceLocator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
        EmployeeService employeeService = serviceLocator.getService(EmployeeService.class);
        Employee employee = new Employee();
        employee.setFirstName("First Name");
        employee.setLastName("Last Name");

        System.out.println("Add employee details");
        Employee employeeAddResponse = employeeService.add(employee);
        System.out.println("The employee details after it has been added Employee: "+employeeAddResponse);

        System.out.println("Now fetch the employee details with ID");
        Employee employeeFetchResponse = employeeService.fetch(employee.getId());
        System.out.println("Employee :"+employeeFetchResponse);

        System.out.println("Now update the employee details");
        employee.setFirstName("Bala");
        employee.setLastName("Samy");
        Employee employeeUpdateResponse = employeeService.update(employee);
        System.out.println("Employee After Updation:"+employeeUpdateResponse);

        System.out.println("Now delete the employee details");
        employeeService.delete(employee.getId());
        System.out.println("Employee After Deletion:"+ employeeService.fetch(employee.getId()));

    }
}