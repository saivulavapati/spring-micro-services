package com.empmanagement.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmanagement.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
