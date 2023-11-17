package com.empmanagement.employeeservice.dto;

public class APIResponseDTO {

	private EmployeeDTO employee;
	private DepartmentDTO department;

	public APIResponseDTO() {

	}

	public APIResponseDTO(EmployeeDTO employee, DepartmentDTO department) {
		this.employee = employee;
		this.department = department;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

}
