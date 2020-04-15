package au.master.foundation.mc.master_bank.repositories;

import au.master.foundation.mc.master_bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Account, Integer> {
}
