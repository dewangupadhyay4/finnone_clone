package com.finnone.cas.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RepaymentScheduleDto {

	private Long id;
	private String applicationNumber;
	private LocalDate localDate;
	private double emiAmount;
	private long principalComponent;
	private long interestComponent;
	private long remainingPrincipal;
	private int tenure;
	private int installmentNumber;
	private LocalDate installmentDate;
	
}
