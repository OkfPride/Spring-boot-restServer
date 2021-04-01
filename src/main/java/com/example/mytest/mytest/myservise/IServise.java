/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.myservise;

import com.example.mytest.mytest.entity.Employee;
import java.util.List;

/**
 *
 * @author JavaDev
 */
public interface IServise {

    List<Employee> showAllEmployees();

    void save(Employee employee);

    Employee getEmployee(int id);

    void delete(int id);

    public List<Employee> findAllByName(String name);
}
