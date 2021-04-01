/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.myservise;

import com.example.mytest.mytest.DAO.IEmplDAO;
import com.example.mytest.mytest.entity.Employee;
import com.example.mytest.mytest.exceptions.MyException;
import java.util.List;
import java.util.Optional;
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
        employeeDAO.save(employee);
    }

    @Autowired
    private IEmplDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> showAllEmployees() {
        List<Employee> showAllEmployees = employeeDAO.findAll();
        return showAllEmployees;
    }

   

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Optional<Employee> findById = employeeDAO.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        }else{
            throw new MyException("there is no employee with id = "+id);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.deleteById(id);
    }
    @Override
  public List<Employee> findAllByName(String name){
        List<Employee> findAllByName = employeeDAO.findAllByName(name);
    return findAllByName;
  };
    

}
