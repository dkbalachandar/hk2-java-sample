package com.service.impl;

import com.dao.EmployeeDao;
import com.model.Employee;
import com.service.EmployeeService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Inject
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee fetch(String id) {
        return employeeDao.fetch(id);
    }

    @Override
    public Employee add(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        return employeeDao.add(employee);

    }

    @Override
    public void delete(String id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }
}