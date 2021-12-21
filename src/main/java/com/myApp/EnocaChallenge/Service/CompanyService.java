package com.myApp.EnocaChallenge.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myApp.EnocaChallenge.Exception.CompanyNotFoundException;
import com.myApp.EnocaChallenge.Model.Company;
import com.myApp.EnocaChallenge.Repository.CompanyRepository;


@Service
public class CompanyService {
	
	@Autowired
    private CompanyRepository companyRepository;

    public List < Company > getCompanies() {
        return companyRepository.findAll();
    }

    public void saveCompany(Company thecompany) {
    	companyRepository.save(thecompany);
    }

    public Company getCompany(int theId) {
    	return companyRepository.findById(theId).orElseThrow(() -> new CompanyNotFoundException(theId));
    }

    @Transactional
    public void deleteCompany(int theId) {
    	companyRepository.existsById(theId);
    }
    
}
