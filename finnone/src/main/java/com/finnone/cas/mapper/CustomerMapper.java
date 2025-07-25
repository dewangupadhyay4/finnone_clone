package com.finnone.cas.mapper;

import org.springframework.stereotype.Component;

//import org.mapstruct.Mapper;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Mapper(componentModel = "spring")
@Data
//@NoArgsConstructor
@Component
public class CustomerMapper {
	
	/*
	 * Customer toEntity(CustomerDto customerDto); CustomerDto toDto(Customer
	 * customer);
	 */
	
	public Customer toEntity(CustomerDto customerDto) {
		Customer customer=new Customer();
		customer.setId(customerDto.getId());
		customer.setName(customerDto.getName());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setPanCard(customerDto.getPanCard());
		customer.setApplicationNumber(customerDto.getApplicationNumber());
		return customer;
	}
	
	public CustomerDto toDto(Customer customer) {
		CustomerDto customerDto=new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setAge(customer.getAge());
		customerDto.setEmail(customer.getEmail());
		customerDto.setPhone(customer.getPhone());
		customerDto.setPanCard(customer.getPanCard());
		customerDto.setApplicationNumber(customer.getApplicationNumber());
		return customerDto;
	}

}
