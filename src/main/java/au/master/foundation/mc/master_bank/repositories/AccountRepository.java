package au.master.foundation.mc.master_bank.repositories;

import au.master.foundation.mc.master_bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
