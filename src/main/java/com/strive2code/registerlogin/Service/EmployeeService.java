package com.strive2code.registerlogin.Service;

import com.strive2code.registerlogin.Dto.EmployeeDto;
import com.strive2code.registerlogin.Dto.LoginDto;
import com.strive2code.registerlogin.response.LoginResponse;

public interface EmployeeService {
	
	String addEmployee(EmployeeDto employeeDto);

	LoginResponse LoginEmployee(LoginDto loginDto);

}
