/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author JavaDev
 */
@Aspect
@Component
public class PointCuts {
    @Pointcut(value = "execution( public * com.example.mytest.mytest.controller.MyRestController.showAll())")
    public void logging(){
        
    }
}
