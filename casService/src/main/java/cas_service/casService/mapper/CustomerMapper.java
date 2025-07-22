package cas_service.casService.mapper;

import org.springframework.stereotype.Component;

import cas_service.casService.dto.CustomerDto;
import cas_service.casService.entity.Customer;

@Component
public class CustomerMapper {
	
	
	public Customer toEntity(CustomerDto customerDto) {
		Customer customer=new Customer();
		customer.setId(customerDto.getId());
		customer.setName(customerDto.getName());
		customer.setAge(customerDto.getAge());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setPanCard(customerDto.getPanCard());
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
		return customerDto;
	}

}
