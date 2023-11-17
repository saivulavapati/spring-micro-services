package com.empmanagement.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.employeeservice.dto.APIResponseDTO;
import com.empmanagement.employeeservice.dto.EmployeeDTO;
import com.empmanagement.employeeservice.service.EmployeeService;

@RequestMapping("api/employees")
@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO addedEmployee = employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<>(addedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{empId}")
	public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable Long empId){
	APIResponseDTO apiResponse = employeeService.getEmployee(empId);
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}

}
