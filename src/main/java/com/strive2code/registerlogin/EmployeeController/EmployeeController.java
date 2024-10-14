package com.strive2code.registerlogin.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strive2code.registerlogin.Dto.EmployeeDto;
import com.strive2code.registerlogin.Dto.LoginDto;
import com.strive2code.registerlogin.Service.EmployeeService;
import com.strive2code.registerlogin.response.LoginResponse;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/save")
	public String saveEmployee(EmployeeDto employeeDto) {
		String id = employeeService.addEmployee(employeeDto);
		return id;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto){
		LoginResponse loginMessage = employeeService.LoginEmployee(loginDto);
		
		return ResponseEntity.ok(loginMessage);
	}

}
