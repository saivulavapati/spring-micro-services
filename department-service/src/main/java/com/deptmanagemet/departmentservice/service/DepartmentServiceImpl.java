package com.deptmanagemet.departmentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deptmanagemet.departmentservice.dto.DepartmentDTO;
import com.deptmanagemet.departmentservice.model.Department;
import com.deptmanagemet.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;
	
	private ModelMapper modelMapper;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
		this.departmentRepository = departmentRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public DepartmentDTO addDepartment(DepartmentDTO departmentDto) {
		System.out.println(departmentDto);
		Department department = modelMapper.map(departmentDto, Department.class);
		Department savedDepartment = departmentRepository.save(department);
		DepartmentDTO savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDTO.class);
		return savedDepartmentDto;
	}


	@Override
	public DepartmentDTO getDepartment(long deptId) {
		Department department = departmentRepository.findById(deptId).get();
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}


	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

}
