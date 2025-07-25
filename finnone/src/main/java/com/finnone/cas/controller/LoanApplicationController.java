package com.finnone.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnone.cas.dto.CustomerDto;
import com.finnone.cas.dto.LoanApplicationDto;
import com.finnone.cas.service.LoanApplicationService;

@RequestMapping("api/v1")
@RestController
public class LoanApplicationController {
	
	@Autowired
	private LoanApplicationService applicationService;
	
	@PostMapping("/create/loan")
	public ResponseEntity<LoanApplicationDto> createLoan(@RequestBody LoanApplicationDto loanApplicationDto){
		LoanApplicationDto creating=applicationService.createLoan(loanApplicationDto);
		return new ResponseEntity<>(creating, HttpStatus.CREATED);
	}
	
	@PostMapping("/loan/disburse")
	public ResponseEntity<LoanApplicationDto> disburse(@RequestBody String applicationNumber){
		LoanApplicationDto disbursal=applicationService.disburseLoan(applicationNumber);
		return new ResponseEntity<>(disbursal, HttpStatus.OK);
	}

}
