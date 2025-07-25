package com.finnone.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.mapper.CustomerMapper;
import com.finnone.cas.repo.CustomerRepo;

import lombok.NoArgsConstructor;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer=customerMapper.toEntity(customerDto);
		Customer saved=customerRepo.save(customer);
		String applicationNumber="APPL"+String.format("%05d", customer.getId());
		saved.setApplicationNumber(applicationNumber);
		
		Customer finalSaved=customerRepo.save(customer);
		return customerMapper.toDto(finalSaved);
	}
	
}
