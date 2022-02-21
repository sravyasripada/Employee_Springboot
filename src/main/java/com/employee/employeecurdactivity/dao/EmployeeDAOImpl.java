package com.employee.employeecurdactivity.dao;

import com.employee.employeecurdactivity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<Employee> findAll(){
        Session currentSession=entityManager.unwrap(Session.class);

        Query<Employee> theQuery=currentSession.createQuery("from Employee",Employee.class);

        List<Employee> employees=theQuery.getResultList();


        return  employees;

    }
    public Employee findById(int id){

        Session currentSession=entityManager.unwrap(Session.class);

        Employee theEmployee=currentSession.get(Employee.class,id);

        return theEmployee;
    }

    public void save(Employee employee){
        Session currentSession=entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);

    }

    public void deleteById(int theid){
        Session currentSession=entityManager.unwrap(Session.class);
        Query theQuery=currentSession.createQuery("delete from Employee where id=:EmployeeId");
        theQuery.setParameter("EmployeeId", theid);
        theQuery.executeUpdate();
    }
    }

