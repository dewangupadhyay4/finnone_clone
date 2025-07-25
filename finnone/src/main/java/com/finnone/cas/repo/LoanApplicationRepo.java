package com.finnone.cas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnone.cas.entity.LoanApplication;

public interface LoanApplicationRepo extends JpaRepository<LoanApplication, Long>{

	
	Optional<LoanApplication> findByApplicationNumber(String applicationNumber);
}
