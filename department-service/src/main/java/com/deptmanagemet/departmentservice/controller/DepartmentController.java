package com.deptmanagemet.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deptmanagemet.departmentservice.dto.DepartmentDTO;
import com.deptmanagemet.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO addDepartment = departmentService.addDepartment(departmentDTO);
		return new ResponseEntity<>(addDepartment,HttpStatus.CREATED);
	}
	
//	@GetMapping("{deptId}")
//	public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable long deptId){
//		DepartmentDTO departmentDto = departmentService.getDepartment(deptId);
//		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
//	}
	
	
	@GetMapping("{deptCode}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String deptCode){
		DepartmentDTO departmentDto = departmentService.getDepartmentByCode(deptCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
	
	

}
