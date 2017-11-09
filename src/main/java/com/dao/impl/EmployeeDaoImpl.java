package com.dao.impl;

import com.dao.EmployeeDao;
import com.model.Employee;
import org.jvnet.hk2.annotations.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    private static Map<String, Employee> empLocalCache = new HashMap<>();

    public Employee fetch(String id) {
        return empLocalCache.get(id);
    }

    public Employee add(Employee employee) {
        empLocalCache.put(employee.getId(), employee);
        return empLocalCache.get(employee.getId());
    }

    public void delete(String id) {
        empLocalCache.remove(id);
    }

    public Employee update(Employee employee) {
        empLocalCache.put(employee.getId(), employee);
        return empLocalCache.get(employee.getId());
    }
}