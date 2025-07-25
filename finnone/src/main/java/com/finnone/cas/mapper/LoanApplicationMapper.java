package com.finnone.cas.mapper;

import org.springframework.stereotype.Component;

import com.finnone.cas.dto.LoanApplicationDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.entity.LoanApplication;

@Component
public class LoanApplicationMapper {
	
	public LoanApplication toEntity(LoanApplicationDto applicationDto,Customer customer) {
		LoanApplication application=new LoanApplication();
		application.setId(applicationDto.getId());
		application.setApplicationNumber(applicationDto.getApplicationNumber());
		application.setTenureInMonths(applicationDto.getTenureInMonths());
		application.setEmiAmount(applicationDto.getEmiAmount());
		application.setLAN(applicationDto.getLAN());
		application.setLoanAmount(applicationDto.getLoanAmount());
		application.setLoanStatus(applicationDto.getLoanStatus());
		application.setRateOfInterest(applicationDto.getRateOfInterest());
		return application;
	}
	
	public LoanApplicationDto toDto(LoanApplication application) {
		LoanApplicationDto applicationDto=new LoanApplicationDto();
		applicationDto.setId(application.getId());
		applicationDto.setApplicationNumber(application.getApplicationNumber());
		applicationDto.setTenureInMonths(application.getTenureInMonths());
		applicationDto.setEmiAmount(application.getEmiAmount());
		applicationDto.setLAN(application.getLAN());
		applicationDto.setLoanAmount(application.getLoanAmount());
		applicationDto.setLoanStatus(application.getLoanStatus());
		applicationDto.setRateOfInterest(application.getRateOfInterest());
		return applicationDto;
	}

}
