package com.example.organizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.mapper.OrganizationMapper;
import com.example.organizationservice.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		
		Organization savedOrganization = organizationRepository.save(organization);
		
		OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);

		return savedOrganizationDto;
	}

	@Override
	public OrganizationDto getOrganizationByOrgCode(String organizationCode) {
		Organization organizationByCOde = organizationRepository.findByOrganizationCode(organizationCode);
		
		OrganizationDto organizationDtoByCode = OrganizationMapper.mapToOrganizationDto(organizationByCOde);
		
		return organizationDtoByCode;
	}

}
