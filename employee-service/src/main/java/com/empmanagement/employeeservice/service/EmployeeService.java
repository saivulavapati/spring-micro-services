package com.empmanagement.employeeservice.service;

import com.empmanagement.employeeservice.dto.APIResponseDTO;
import com.empmanagement.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO addEmployee(EmployeeDTO employeeDto);
	
	APIResponseDTO getEmployee(Long empId);

}
