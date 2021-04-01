/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.DAO;

import com.example.mytest.mytest.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

/**
 *
 * @author JavaDev
 */
public interface IEmplDAO extends JpaRepository<Employee, Integer>{




}
