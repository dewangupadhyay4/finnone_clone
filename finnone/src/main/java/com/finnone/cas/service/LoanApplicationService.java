package com.finnone.cas.service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finnone.cas.dto.LoanApplicationDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.entity.LoanApplication;
import com.finnone.cas.mapper.LoanApplicationMapper;
import com.finnone.cas.repo.CustomerRepo;
import com.finnone.cas.repo.LoanApplicationRepo;
import com.finnone.utility.EmiCalculator;
import com.finnone.utility.RpsGenerator;

@Service
public class LoanApplicationService {
	
	@Autowired
	private LoanApplicationRepo applicationRepo;
	
	@Autowired
	private LoanApplicationMapper applicationMapper;
	
	@Autowired
	private EmiCalculator calculator;
	
	@Autowired
	private CustomerRepo customerRepo;
		
	public LoanApplicationDto createLoan(LoanApplicationDto dto) {
//		Optional<LoanApplication> exist=applicationRepo.findByApplicationNumber(dto.getApplicationNumber());
//		if(!exist.isPresent()) {
//			throw new RuntimeException("Application Number Does Not Exist");
//		}
		
		Customer customer=customerRepo.findByApplicationNumber(dto.getApplicationNumber()).orElseThrow(()->new RuntimeException("Customer with this Application Number does not exist"));
		
//		LoanApplication application=exist.get();
//		
//		application.setLoanAmount(dto.getLoanAmount());
//		application.setTenureInMonths(dto.getTenureInMonths());
//		application.setRateOfInterest(dto.getRateOfInterest());
		
		double emi=calculator.calculateEMI(dto.getLoanAmount(),dto.getRateOfInterest(),dto.getTenureInMonths());
//		application.setEmiAmount(emi);
		
		LoanApplication application=new LoanApplication();
		application.setApplicationNumber(dto.getApplicationNumber());
		application.setLoanAmount(dto.getLoanAmount());
		application.setRateOfInterest(dto.getRateOfInterest());
		application.setTenureInMonths(dto.getTenureInMonths());
		application.setEmiAmount(emi);
		application.setLoanStatus("Approved");
		application.setCustomer(customer);
		
		
//		application.setLoanStatus("Approved");
		LoanApplication saved=applicationRepo.save(application);

		return applicationMapper.toDto(saved);
	}
	
	public LoanApplicationDto disburseLoan(String applicationNumber) {
		Optional<LoanApplication> exist=applicationRepo.findByApplicationNumber(applicationNumber);
		if(!exist.isPresent()) {
			throw new RuntimeException("Application Number Does Not Exist");
		}
		
		LoanApplication application=exist.get();
		
		String lan="LAN"+System.currentTimeMillis();
		application.setLAN(lan);
		application.setLoanStatus("Disbursed");
		applicationRepo.save(application);
		
		return applicationMapper.toDto(application);
	}
}
