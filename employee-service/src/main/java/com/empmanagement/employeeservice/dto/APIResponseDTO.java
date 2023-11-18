package com.empmanagement.employeeservice.dto;

public class APIResponseDTO {

	private EmployeeDTO employee;
	private DepartmentDTO department;
	private OrganizationDto organization;

	public APIResponseDTO() {

	}

	public APIResponseDTO(EmployeeDTO employee, DepartmentDTO department, OrganizationDto organization) {
		this.employee = employee;
		this.department = department;
		this.organization = organization;
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

	public OrganizationDto getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDto organization) {
		this.organization = organization;
	}

}
