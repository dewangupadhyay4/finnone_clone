package com.finnone.cas.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepaymentSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
