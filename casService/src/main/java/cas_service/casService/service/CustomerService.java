package cas_service.casService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;

import cas_service.casService.dto.CustomerDto;
import cas_service.casService.entity.Customer;
import cas_service.casService.mapper.CustomerMapper;
import cas_service.casService.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CustomerRepo customerRepo;

	public CustomerDto register(CustomerDto customerDto) {
		Customer customer= customerMapper.toEntity(customerDto);
		Customer saved=customerRepo.save(customer);
		return customerMapper.toDto(saved);
		}
	
	
}
