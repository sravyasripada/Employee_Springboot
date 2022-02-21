package com.employee.employeecurdactivity.dao;

import com.employee.employeecurdactivity.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee student);

   public void deleteById(int id);
}
