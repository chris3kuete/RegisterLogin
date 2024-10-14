package com.strive2code.registerlogin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.strive2code.registerlogin.Entity.Employee;


@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee findByEmail(String email);

	java.util.Optional<Employee> findOneByEmailAndPassword(String email, String password);

	

}
