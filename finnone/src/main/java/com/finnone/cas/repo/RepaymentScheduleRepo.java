package com.finnone.cas.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finnone.cas.entity.Customer;
import com.finnone.cas.entity.RepaymentSchedule;

/*
 * public interface RepaymentScheduleRepo extends
 * JpaRepository<List<RepaymentSchedule>, Long>{
 * 
 * Optional<Customer> findByApplicationNumber(String applicationNumber);
 * 
 * }
 */
public interface RepaymentScheduleRepo extends JpaRepository<RepaymentSchedule, Long> {

    List<Customer> findByApplicationNumber(String applicationNumber);
}
