package com.myApp.EnocaChallenge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myApp.EnocaChallenge.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByCompanyId(int companyId);

}
