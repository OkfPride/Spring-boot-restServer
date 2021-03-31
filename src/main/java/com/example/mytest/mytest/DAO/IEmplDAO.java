/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.DAO;

import com.example.mytest.mytest.entity.Employee;
import java.util.List;
import org.springframework.ui.Model;

/**
 *
 * @author JavaDev
 */
public interface IEmplDAO {

    List<Employee> showAllEmployees();

    Employee addEmployee();
    
    void saveEmployee(Employee employee);
    
    Employee getEmployee(int id);

    public void deleteEmployee(int id);

}
