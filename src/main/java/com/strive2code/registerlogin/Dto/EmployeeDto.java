package com.strive2code.registerlogin.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
    private int employeeId;
	
	private String employeeName;
	
	private String email;
	
	private String password;
	

}
