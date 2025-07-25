package com.finnone.cas.dto;

import lombok.Data;

@Data
public class LoanApplicationDto {
	
	private Long id;
	
	private String applicationNumber;
	private Double loanAmount;
	private Integer tenureInMonths;
	private Double rateOfInterest;
	
	private Double EmiAmount;
	private String loanStatus;
	private String LAN;

}
