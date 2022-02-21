package com.employee.employeecurdactivity.service;

import com.employee.employeecurdactivity.dao.EmployeeDAO;

import com.employee.employeecurdactivity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public  EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }

    @Transactional
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Transactional
    public Employee findById(int id){
        return employeeDAO.findById(id);
    }

    @Transactional
    public void save(Employee student){
        employeeDAO.save(student);
    }

    @Transactional
    public void deleteById(int id){
        employeeDAO.deleteById(id);
    }
}
