package com.example.mytest.mytest.DAO;

import com.example.mytest.mytest.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author JavaDev
 */
@Repository
public class EmployeeDAO implements IEmplDAO {

    @Autowired
    private EntityManager entityManager;
    

    @Override
    public Employee addEmployee() {
        Employee employee = new Employee();
        return employee;
    }

    @Override
    public List<Employee> showAllEmployees() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query createQuery = currentSession.createQuery("from Employee", Employee.class);
        List resultList = createQuery.getResultList();
        return resultList;

//return null;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteEmployee(Employee employee) {
       entityManager.unwrap(Session.class).delete(employee); 
    }  
 
    public Employee getEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee get = currentSession.get(Employee.class, id);
        return get; 
    }
}
