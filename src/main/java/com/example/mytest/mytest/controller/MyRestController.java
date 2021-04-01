/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.controller;

import com.example.mytest.mytest.entity.Employee;
import com.example.mytest.mytest.exceptions.MyException;
import com.example.mytest.mytest.myservise.IServise;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JavaDev
 */
@RestController
@RequestMapping(path = "/api")
public class MyRestController {
    
    @Autowired
    private IServise meservise;
    
    @GetMapping(path = "employees")
    public List<Employee> showAll() {
        return meservise.showAllEmployees();
    }
    
    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = meservise.getEmployee(id);
        if (employee == null) {
            throw new MyException("there is not employee with id = "+id);
        }
        return employee;
    }
    
    @DeleteMapping(path = "employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = meservise.getEmployee(id);
        if (employee==null) {
             throw new MyException("there is not employee with id = "+id);
        }
        meservise.delete(id); 
        return "Employee with id "+id+ " was deleted";
    }
    
    @PutMapping(path = "employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        meservise.save(employee);
        return employee;
    }
    
    @PostMapping(path = "employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        meservise.save(employee);
        return employee;
    }
    @GetMapping("/employees/names/{name}")
    public List<Employee>findAllByName(@PathVariable(name = "name") String name){
    return meservise.findAllByName(name);
    };
}
