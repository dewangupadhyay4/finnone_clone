package com.finnone.cas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnone.cas.dto.RepaymentScheduleDto;
import com.finnone.cas.service.RepaymentScheduleService;

@RestController
@RequestMapping("api/v1")
public class RepaymentScheduleController {
	
	@Autowired
	private RepaymentScheduleService repaymentScheduleService;

	@PostMapping("/create-rps")
	public ResponseEntity<List<RepaymentScheduleDto>> createRps(@RequestBody RepaymentScheduleDto dto){
		
		List<RepaymentScheduleDto> dto2=repaymentScheduleService.generateRps(dto);
		
		return new ResponseEntity<List<RepaymentScheduleDto>>(dto2, HttpStatus.CREATED);
	}
	
	
}
