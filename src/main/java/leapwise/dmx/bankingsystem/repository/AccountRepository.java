package leapwise.dmx.bankingsystem.repository;

import leapwise.dmx.bankingsystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
