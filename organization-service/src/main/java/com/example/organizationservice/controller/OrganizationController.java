package com.example.organizationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationServiceImpl;
	

	@PostMapping
	public ResponseEntity<OrganizationDto> addOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto saveOrganizationDto = organizationServiceImpl.saveOrganization(organizationDto);
		return new ResponseEntity<OrganizationDto>(saveOrganizationDto,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("{organizationCode}")
	public ResponseEntity<OrganizationDto> getorganizationByCode(@PathVariable String organizationCode){
		System.out.println(organizationCode);
		OrganizationDto organizationByOrgCode = organizationServiceImpl.getOrganizationByOrgCode(organizationCode);
		return new ResponseEntity<OrganizationDto>(organizationByOrgCode,HttpStatus.OK);
	}

}
