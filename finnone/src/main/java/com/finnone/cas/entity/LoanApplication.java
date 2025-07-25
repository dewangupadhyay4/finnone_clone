package com.finnone.cas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String applicationNumber;
	private Double loanAmount;
	private Integer tenureInMonths;
	private Double rateOfInterest;
	
	private Double EmiAmount;
	private String loanStatus;
	private String LAN;
	
	@OneToOne
	private Customer customer;

}
