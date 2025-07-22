package cas_service.casService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cas_service.casService.dto.CustomerDto;
import cas_service.casService.service.CustomerService;

@RequestMapping("v1/api")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> register(@RequestBody CustomerDto customerDto){
		CustomerDto registering=customerService.register(customerDto);
		return new ResponseEntity<>(registering, HttpStatus.CREATED);
	}

}
