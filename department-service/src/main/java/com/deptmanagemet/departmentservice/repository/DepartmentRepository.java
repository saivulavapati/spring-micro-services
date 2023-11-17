package com.deptmanagemet.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deptmanagemet.departmentservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}
