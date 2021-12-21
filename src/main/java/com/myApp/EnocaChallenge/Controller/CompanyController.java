package com.myApp.EnocaChallenge.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.EnocaChallenge.Model.Company;
import com.myApp.EnocaChallenge.Service.CompanyService;


@RestController
//Enable Hibernate Transaction.
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
    private CompanyService companyService;
    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/company/list
    @RequestMapping(value = "/list", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
            )
    @ResponseBody
    public List<Company> getCompanies() {
        List<Company> list = companyService.getCompanies();
        return list;
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/company/{compId}
    @RequestMapping(value = "/{compId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Company getCompany(@PathVariable("compId") int compId) {
        return companyService.getCompany(compId);
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/company/add
    @RequestMapping(value = "/add", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void addCompany(@Valid @RequestBody Company comp) {
    	
        companyService.saveCompany(comp);
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/company/update
    @RequestMapping(value = "/update", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void updateCompany(@RequestBody Company comp) {

        companyService.saveCompany(comp);
    }

    // URL:
    // http://localhost:8080/EnocaCRUDRestApi/employee/delete/{compId}
    @RequestMapping(value = "/delete/{compId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("compId") int compId) {
    	companyService.deleteCompany(compId);
    }

}

