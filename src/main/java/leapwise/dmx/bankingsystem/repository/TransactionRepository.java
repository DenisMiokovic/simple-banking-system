package leapwise.dmx.bankingsystem.repository;

import leapwise.dmx.bankingsystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

	@Query("SELECT t FROM Transaction t WHERE (t.senderAccount.customer.customerId = :customerId OR t.receiverAccount.customer.customerId = :customerId) AND t.timestamp = :timestamp")
	List<Transaction> findByCustomerIdAndTimestamp(@Param("customerId") Long customerId, @Param("timestamp") LocalDateTime timestamp);

	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.receiverAccount.accountId = :accountId AND t.timestamp >= :since")
	BigDecimal sumIncomeTransactions(Long accountId, LocalDateTime since);

	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.senderAccount.accountId = :accountId AND t.timestamp >= :since")
	BigDecimal sumExpenditureTransactions(Long accountId, LocalDateTime since);
}
