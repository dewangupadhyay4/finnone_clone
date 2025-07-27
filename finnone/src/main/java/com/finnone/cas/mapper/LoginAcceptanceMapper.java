package com.finnone.cas.mapper;

import org.springframework.stereotype.Component;

import com.finnone.cas.dto.LoginAcceptanceDto;
import com.finnone.cas.entity.LoginAcceptance;

@Component
public class LoginAcceptanceMapper {
	
	public LoginAcceptance toEntity(LoginAcceptanceDto acceptanceDto) {
		LoginAcceptance acceptance=new LoginAcceptance();
		acceptance.setId(acceptanceDto.getId());
		acceptance.setApplicationNumber(acceptanceDto.getApplicationNumber());
		acceptance.setAdditionalRemarks(acceptanceDto.getAdditionalRemarks());
		acceptance.setAgentCode(acceptanceDto.getAgentCode());
		acceptance.setLocalDate(acceptanceDto.getLocalDate());
		acceptance.setProductType(acceptanceDto.getProductType());
		acceptance.setSourcingChannel(acceptanceDto.getSourcingChannel());
		return acceptance;
	}
	
	public LoginAcceptanceDto toDto(LoginAcceptance acceptanceLoginAcceptance) {
		LoginAcceptanceDto acceptanceDto=new LoginAcceptanceDto();
		acceptanceDto.setId(acceptanceLoginAcceptance.getId());
		acceptanceDto.setApplicationNumber(acceptanceLoginAcceptance.getApplicationNumber());
		acceptanceDto.setAdditionalRemarks(acceptanceLoginAcceptance.getAdditionalRemarks());
		acceptanceDto.setAgentCode(acceptanceLoginAcceptance.getAgentCode());
		acceptanceDto.setLocalDate(acceptanceLoginAcceptance.getLocalDate());
		acceptanceDto.setProductType(acceptanceLoginAcceptance.getProductType());
		acceptanceDto.setSourcingChannel(acceptanceLoginAcceptance.getSourcingChannel());
		return acceptanceDto;
	}

}
