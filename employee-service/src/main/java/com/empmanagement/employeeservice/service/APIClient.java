package com.empmanagement.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empmanagement.employeeservice.dto.DepartmentDTO;

@FeignClient(url = "http://localhost:8080/", value = "DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/departments/{deptCode}")
	DepartmentDTO getDepartmentByCode(@PathVariable String deptCode);
	

}
