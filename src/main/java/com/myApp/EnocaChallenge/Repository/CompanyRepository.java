package com.myApp.EnocaChallenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myApp.EnocaChallenge.Model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer > {

}
