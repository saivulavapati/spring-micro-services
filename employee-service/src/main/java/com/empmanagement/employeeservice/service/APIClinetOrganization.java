package com.empmanagement.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.empmanagement.employeeservice.dto.OrganizationDto;


@FeignClient(url = "http://localhost:8083/", value = "ORGANIZATION-SERVICE")
public interface APIClinetOrganization {
	
	@GetMapping("api/organizations/{organizationCode}")
	OrganizationDto getorganizationByCode(@PathVariable String organizationCode);

}
