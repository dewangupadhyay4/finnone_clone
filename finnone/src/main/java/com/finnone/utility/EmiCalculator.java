package com.finnone.utility;

import org.springframework.stereotype.Component;

@Component
public class EmiCalculator {
	
	public Double calculateEMI(Double principal, Double annualRate, Integer months) {
		double monthlyRate=annualRate/12/100;
		return (principal*monthlyRate*Math.pow(1+monthlyRate, months))/(Math.pow(1+monthlyRate, months)-1);
	}

}
