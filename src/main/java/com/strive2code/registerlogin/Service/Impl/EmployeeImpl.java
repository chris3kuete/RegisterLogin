package com.strive2code.registerlogin.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.strive2code.registerlogin.Dto.EmployeeDto;
import com.strive2code.registerlogin.Dto.LoginDto;
import com.strive2code.registerlogin.Entity.Employee;
import com.strive2code.registerlogin.Repo.EmployeeRepo;
import com.strive2code.registerlogin.Service.EmployeeService;
import com.strive2code.registerlogin.response.LoginResponse;

@Service
public class EmployeeImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(
				employeeDto.getEmployeeId(),
				employeeDto.getEmployeeName(),
				employeeDto.getEmail(),
				
				this.passwordEncoder.encode(employeeDto.getPassword())
				);
		
		employeeRepo.save(employee);
		return employee.getEmployeeName();
	}

	@Override
	public LoginResponse LoginEmployee(LoginDto loginDto) {
		String msg = "";
		
		Employee employee1 = employeeRepo.findByEmail(loginDto.getEmail());
		if(employee1 != null) {
			String password = loginDto.getPassword();
			String encodedPassword = employee1.getPassword();
			Boolean ispwdRight = passwordEncoder.matches(password, encodedPassword);
			if(ispwdRight) {
				Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
				if(employee.isPresent()) {
					return new LoginResponse("login successful", true);
				}else {
					return new LoginResponse("login failed", false);
				}
			}else {
				return new LoginResponse("password not match", false);
			}
			
			
		}else {
			return new LoginResponse("Email not exists", false);
		}
		
	}
	

}
