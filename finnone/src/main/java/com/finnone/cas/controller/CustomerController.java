package com.finnone.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.service.CustomerService;

@RequestMapping("api/v1")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
		CustomerDto dto=customerService.createCustomer(customerDto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
}
