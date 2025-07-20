package cas_service.casService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cas_service.casService.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
