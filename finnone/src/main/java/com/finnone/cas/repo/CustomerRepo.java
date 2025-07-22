package com.finnone.cas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finnone.cas.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
