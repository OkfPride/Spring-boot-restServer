/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.myservise;

import com.example.mytest.mytest.DAO.IEmplDAO;
import com.example.mytest.mytest.entity.Employee;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JavaDev
 */
@Service
public class MyServise implements IServise {

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Autowired
    private IEmplDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> showAllEmployees() {
        List<Employee> showAllEmployees = employeeDAO.showAllEmployees();
        return showAllEmployees;
    }

    @Override
    @Transactional
    public Employee add() {
        return  employeeDAO.addEmployee();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.deleteEmployee(id);
    }
    

}
