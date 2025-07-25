package com.finnone.utility;

import org.springframework.stereotype.Component;

@Component
public class RpsGenerator {
	
	public String generateRPS(double principal, double emi, int tenure) {
	    StringBuilder schedule = new StringBuilder();
	    for (int i = 1; i <= tenure; i++) {
	        schedule.append("Month ").append(i).append(": ").append("EMI = ").append(String.format("%.2f", emi)).append("\n");
	    }
	    return schedule.toString();
	}


}
