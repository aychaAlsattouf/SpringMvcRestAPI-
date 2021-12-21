package com.myApp.EnocaChallenge.Exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(int id) {
        super("Could not find Company " + id);
    }
}
