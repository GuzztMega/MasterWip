package au.master.foundation.mc.master_bank.repositories;

import au.master.foundation.mc.master_bank.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
