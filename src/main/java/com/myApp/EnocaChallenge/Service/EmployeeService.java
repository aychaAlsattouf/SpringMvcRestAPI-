package com.myApp.EnocaChallenge.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.myApp.EnocaChallenge.Exception.*;
import com.myApp.EnocaChallenge.Model.Employee;
import com.myApp.EnocaChallenge.Repository.EmployeeRepository;

import com.myApp.EnocaChallenge.Exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;


    public List < Employee > getEmployees() {
        return employeeRepository.findAll();
    }

    public String saveEmployee(Employee theEmployee) {
    	try {
    		employeeRepository.save(theEmployee);
    		return "Employee has saved";
    	}
    	catch (DataIntegrityViolationException ex) {
    		   return ex.getRootCause().getMessage(); /*get the message and handle it*/
    		}
    }

    public Employee getEmployee(int theId) {
        return employeeRepository.findById(theId).orElseThrow(() -> new EmployeeNotFoundException(theId));
    }

    public void deleteEmployee(int theId) {
    	employeeRepository.deleteById(theId);
    }
    
    public List <Employee> getEmployeesByCompanyId(int company_id){
    	return  employeeRepository.findByCompanyId(company_id);
    }
        
}
