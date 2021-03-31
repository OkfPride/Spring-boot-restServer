/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mytest.mytest.exceptions;

/**
 *
 * @author JavaDev
 */
public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }

}
