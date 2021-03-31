package com.example.mytest.mytest.DAO;

import com.example.mytest.mytest.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
//        Session currentSession = entityManager.unwrap(Session.class);
//        Query createQuery = currentSession.createQuery("from Employee", Employee.class);
//        List resultList = createQuery.getResultList();
//        return resultList;
        Query createQuery = entityManager.createQuery("from Employee");
        List resultList = createQuery.getResultList();
        return resultList;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session currentSession = entityManager.unwrap(Session.class);
//        currentSession.saveOrUpdate(employee);
        Employee merge = entityManager.merge(employee);
        employee.setId(merge.getId());

    }

    @Override
    public void deleteEmployee(int id) {
//        entityManager.unwrap(Session.class).delete(employee);
        Query createQuery = entityManager.createQuery("DELETE FROM Employee where id=:setparam");
        createQuery.setParameter("setparam", id);
        createQuery.executeUpdate();
    }

    public Employee getEmployee(int id) {
//        Session currentSession = entityManager.unwrap(Session.class);
//        Employee get = currentSession.get(Employee.class, id);
//        return get;
        return entityManager.find(Employee.class, id);
    }
}
