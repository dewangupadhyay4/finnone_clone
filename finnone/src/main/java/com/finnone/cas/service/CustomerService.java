package com.finnone.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.entity.Customer;
import com.finnone.cas.mapper.CustomerMapper;
import com.finnone.cas.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer=customerMapper.toEntity(customerDto);
		Customer saved=customerRepo.save(customer);
		return customerMapper.toDto(saved);
	}
	
}
