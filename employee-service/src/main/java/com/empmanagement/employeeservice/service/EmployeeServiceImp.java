package com.empmanagement.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.empmanagement.employeeservice.dto.APIResponseDTO;
import com.empmanagement.employeeservice.dto.DepartmentDTO;
import com.empmanagement.employeeservice.dto.EmployeeDTO;
import com.empmanagement.employeeservice.model.Employee;
import com.empmanagement.employeeservice.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;

//	private RestTemplate restTemplate;

//	private WebClient webClient;
	
	private APIClient apiClient;

	public EmployeeServiceImp(EmployeeRepository employeeRepository, ModelMapper modelMapper, APIClient apiClient) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
		this.apiClient = apiClient ;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDto) {
		System.out.println(employeeDto);

		Employee employee = modelMapper.map(employeeDto, Employee.class);

		System.out.println(employee);

		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeDTO savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDTO.class);
		return savedEmployeeDto;
	}

	@CircuitBreaker(name="${spring.application.name}", fallbackMethod="getEmployeeFallBack")
	@Override
	public APIResponseDTO getEmployee(Long empId) {
		Employee employee = employeeRepository.findById(empId).get();
		
		
//		ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/departments/" + employee.departmentCode(), DepartmentDTO.class);
//		DepartmentDTO departmentDTO = responseEntity.getBody();
		
//		DepartmentDTO departmentDTO = webClient.get()
//		.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//		.retrieve()
//		.bodyToMono(DepartmentDTO.class)
//		.block();
		
		DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		APIResponseDTO apiResponse = new APIResponseDTO();
		apiResponse.setEmployee(employeeDTO);
		apiResponse.setDepartment(departmentDTO);

		return apiResponse;
	}
	
	public APIResponseDTO getEmployeeFallBack(Long empId,Exception exception) {
		Employee employee = employeeRepository.findById(empId).get();
		
		
//		ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity(
//				"http://localhost:8080/api/departments/" + employee.departmentCode(), DepartmentDTO.class);
//		DepartmentDTO departmentDTO = responseEntity.getBody();
		
//		DepartmentDTO departmentDTO = webClient.get()
//		.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//		.retrieve()
//		.bodyToMono(DepartmentDTO.class)
//		.block();
		
		DepartmentDTO departmentDTO = new DepartmentDTO(null,"R&D","Research and Development Description","RD1001");
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		APIResponseDTO apiResponse = new APIResponseDTO();
		apiResponse.setEmployee(employeeDTO);
		apiResponse.setDepartment(departmentDTO);

		return apiResponse;
	}

}
