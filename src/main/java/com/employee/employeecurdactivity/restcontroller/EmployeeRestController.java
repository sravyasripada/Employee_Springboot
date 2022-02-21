package com.employee.employeecurdactivity.restcontroller;

import com.employee.employeecurdactivity.entity.Employee;
import com.employee.employeecurdactivity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null)
        {
            throw new RuntimeException("Employee id not found :"+employeeId);
        }
        return theEmployee;

    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //just in case an id is passed in JSON,
        //force save to '0' instead of update
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    //delete
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);
        if(tempEmployee==null)
        {
            throw new RuntimeException("Employee not found with id:"+employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted Employee record with id :"+employeeId;
    }
}
