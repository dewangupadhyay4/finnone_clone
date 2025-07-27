package com.finnone.cas.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoginAcceptanceDto {
	
	private Long id;
	private String applicationNumber;
	private String sourcingChannel;
	private String agentCode;
	private String productType;
	private String additionalRemarks;
	private LocalDate localDate;

}
