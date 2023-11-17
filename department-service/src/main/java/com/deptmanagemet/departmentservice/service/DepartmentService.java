package com.deptmanagemet.departmentservice.service;

import com.deptmanagemet.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
	
	DepartmentDTO addDepartment(DepartmentDTO departmentDto);
	
	DepartmentDTO getDepartment(long deptId);
	
	DepartmentDTO getDepartmentByCode(String departmentCode);

}
