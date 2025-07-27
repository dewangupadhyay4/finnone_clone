package com.finnone.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finnone.cas.dto.LoginAcceptanceDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.entity.LoginAcceptance;
import com.finnone.cas.mapper.LoginAcceptanceMapper;
import com.finnone.cas.repo.CustomerRepo;
import com.finnone.cas.repo.LoginAcceptanceRepo;

@Service
public class LoginAcceptanceService {

	@Autowired
	private LoginAcceptanceMapper acceptanceMapper;
	
	@Autowired
	private LoginAcceptanceRepo acceptanceRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public LoginAcceptanceDto saveLoginAcceptance(LoginAcceptanceDto loginAcceptanceDto) {
		
		Customer find=customerRepo.findByApplicationNumber(loginAcceptanceDto.getApplicationNumber()).orElseThrow(()-> new RuntimeException("Application number does not exist"));
		
		LoginAcceptance loginAcceptance=acceptanceMapper.toEntity(loginAcceptanceDto);
		loginAcceptance.setLocalDate(loginAcceptanceDto.getLocalDate());
		LoginAcceptance save=acceptanceRepo.save(loginAcceptance);
		
		return acceptanceMapper.toDto(save);
	}
	
}
