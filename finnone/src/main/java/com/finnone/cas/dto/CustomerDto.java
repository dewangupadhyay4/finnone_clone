package com.finnone.cas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private Long id;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String panCard;
	
}
