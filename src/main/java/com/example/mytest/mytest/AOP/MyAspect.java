/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author JavaDev
 */
@Component
@Aspect
public class MyAspect {

    @Before("com.example.mytest.mytest.AOP.PointCuts.logging()")
    private void getTest() {
        System.out.println("test AOP");
    }
}
