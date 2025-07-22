package com.finnone.cas.mapper;

import org.mapstruct.Mapper;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	Customer toEntity(CustomerDto customerDto);
	CustomerDto toDto(Customer customer);

}
