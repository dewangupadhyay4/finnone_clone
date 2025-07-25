package com.finnone.cas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnone.cas.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	Optional<Customer> findByApplicationNumber(String applicationNumber);
}
