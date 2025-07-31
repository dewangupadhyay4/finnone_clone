package com.finnone.cas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finnone.cas.dto.RepaymentScheduleDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.entity.RepaymentSchedule;
import com.finnone.cas.mapper.RepaymentScheduleMapper;
import com.finnone.cas.repo.CustomerRepo;
import com.finnone.cas.repo.RepaymentScheduleRepo;

@Service
public class RepaymentScheduleService {
	
	@Autowired
	private RepaymentScheduleMapper repaymentScheduleMapper;

	@Autowired
	private RepaymentScheduleRepo scheduleRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public List<RepaymentScheduleDto> generateRps(RepaymentScheduleDto scheduleDto){
		Customer customer=customerRepo.findByApplicationNumber(scheduleDto.getApplicationNumber()).orElseThrow(()->new RuntimeException("Application number does not exist"));
		
//		double principal=scheduleDto.getPrincipalComponent();
		double principal=scheduleDto.getEmiAmount();
		double annualRoi=scheduleDto.getInterestComponent();
		double monthlyRate=annualRoi/12/100;
		int tenure =scheduleDto.getTenure();
		
		double emi=(principal*monthlyRate*Math.pow(1+monthlyRate, tenure))/(Math.pow(1+monthlyRate, tenure)-1);
		
		long roundEmi=Math.round(emi);
		double balance=principal;
		
		List<RepaymentSchedule> schedule=new ArrayList<>();
		for(int i=1;i<=tenure;i++) {
			  double interest = balance * monthlyRate;
	            double principalComponent = roundEmi - interest;
	            balance -= principalComponent;

	            if (i == tenure && balance > 0) {
	                principalComponent += balance;
	                balance = 0;
		}
	            RepaymentSchedule schedule2=repaymentScheduleMapper.toEntity(scheduleDto);
	            schedule2.setApplicationNumber(scheduleDto.getApplicationNumber());
	            schedule2.setInstallmentNumber(i);
	            schedule2.setInstallmentDate(scheduleDto.getLocalDate().plusMonths(i - 1));
	            schedule2.setEmiAmount(roundEmi);
	            schedule2.setInterestComponent(Math.round(interest));
	            schedule2.setPrincipalComponent(Math.round(principalComponent));
	            schedule2.setRemainingPrincipal(Math.max(0, Math.round(balance)));
	            schedule2.setTenure(tenure);
	            schedule2.setLocalDate(scheduleDto.getLocalDate());

	            schedule.add(schedule2);
	        }
		List<RepaymentSchedule> saved=scheduleRepo.saveAll(schedule);
		return repaymentScheduleMapper.toList(saved);
	
	}
}
