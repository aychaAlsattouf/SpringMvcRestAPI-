package com.myApp.EnocaChallenge.Exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Could not find Employee " + id);
    }

}
