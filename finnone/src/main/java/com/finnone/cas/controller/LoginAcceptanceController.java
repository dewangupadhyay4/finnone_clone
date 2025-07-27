package com.finnone.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finnone.cas.dto.LoginAcceptanceDto;
import com.finnone.cas.service.LoginAcceptanceService;

@RestController
@RequestMapping("api/v1")
public class LoginAcceptanceController {

	@Autowired
	private LoginAcceptanceService acceptanceService;
	
	@PostMapping("/loginAcceptance")
	public ResponseEntity<LoginAcceptanceDto> createLoginAcceptance(@RequestBody LoginAcceptanceDto acceptanceDto){
		LoginAcceptanceDto creating=acceptanceService.saveLoginAcceptance(acceptanceDto);
		return new ResponseEntity<>(creating, HttpStatus.CREATED);
	}
	
}
