package com.finnone.cas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnone.cas.entity.LoginAcceptance;

public interface LoginAcceptanceRepo extends JpaRepository<LoginAcceptance, Long>{
	
	Optional<LoginAcceptance> findByApplicationNumber(String applicationNumber);

}
