package com.myApp.EnocaChallenge.Controller;


import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.EnocaChallenge.Model.Employee;
import com.myApp.EnocaChallenge.Service.CompanyService;
import com.myApp.EnocaChallenge.Service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CompanyService companyService;

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/list
    @RequestMapping(value = "/list", //
            method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeService.getEmployees();
        return list;
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/{empId}
    @RequestMapping(value = "/{empId}", //
            method = RequestMethod.GET)
    @ResponseBody
    public  ResponseEntity<Employee> getEmployee(@PathVariable("empId") @Max(1) int empId) {
    	return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
    }

 // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/company/{compId}
    @RequestMapping(value = "/company/{compId}", //
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByCompanyId(@PathVariable("compId") int compId) {
    	
        return new ResponseEntity<>( companyService
                .getCompany(compId).getEmployees() , HttpStatus.OK);
    }
    
    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/add
    @RequestMapping(value = "/add", //
            method = RequestMethod.POST)
    //@Transactional
    @ResponseBody
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
		 return new ResponseEntity<>(" check entered data ",HttpStatus.OK);
		}
    			String m = employeeService.saveEmployee(emp);
        		return new ResponseEntity<>(m,HttpStatus.OK);
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/update
    @RequestMapping(value = "/update", //
            method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {    	
    	try {
    		employeeService.getEmployee(emp.getId());
    		employeeService.saveEmployee(emp);
    		return new ResponseEntity<>(emp.getFirst_name() + " has updated.", HttpStatus.OK);    		
    	}catch(Exception e){
    		return new ResponseEntity<>(String.format("An Error Happened during update employee with %d id", emp.getId()), HttpStatus.OK);
    	}
    	
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/delete/{empId}
    @RequestMapping(value = "/delete/{empId}", //
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") int empId) {
    	try {
    		Employee emp = employeeService.getEmployee(empId);
    		employeeService.deleteEmployee(empId);
    		return new ResponseEntity<>(emp.getFirst_name() + " has deleted.", HttpStatus.OK);
    	}
    	catch(Exception e){ 
    		//String.format("An Error Happened during delete employee with %d id", empId)
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    	}
    	
    }

}