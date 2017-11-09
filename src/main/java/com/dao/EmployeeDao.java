package com.dao;

import com.model.Employee;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface EmployeeDao {

    public Employee fetch(String id);

    public Employee add(Employee employee);

    public void delete(String id);

    public Employee update(Employee employee);
}