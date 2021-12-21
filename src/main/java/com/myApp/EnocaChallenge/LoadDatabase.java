package com.myApp.EnocaChallenge;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myApp.EnocaChallenge.Model.Company;
import com.myApp.EnocaChallenge.Model.Employee;
import com.myApp.EnocaChallenge.Repository.CompanyRepository;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase( CompanyRepository companyRepository) {

        return args -> {
                if(companyRepository.findAll().size() == 0) {
                    Company company = new Company("Enoca","Karabkk","53845724","Software");
                    Employee bilbo = new Employee("Bilbo","Baggins", "100 yil ","45631245","manager");
                    Employee frado = new Employee("Frodo","Baggins", "100 yil", "45631245","manager");
                    company.setEmployees(Arrays.asList(bilbo, frado));
                    log.info("Preloading " + companyRepository.save(company));
                }

        };
    }

}