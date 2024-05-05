package leapwise.dmx.bankingsystem.service;

import leapwise.dmx.bankingsystem.model.Account;
import leapwise.dmx.bankingsystem.repository.AccountRepository;
import leapwise.dmx.bankingsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	@Scheduled(cron = "0 0 1 * * ?")
	public void updatePastMonthTurnover() {
		List<Account> accounts = accountRepository.findAll();
		LocalDateTime startOfLastMonth = LocalDate.now().minusMonths(1).atStartOfDay();

		accounts.forEach(account -> {
			BigDecimal income = transactionRepository.sumIncomeTransactions(
					account.getAccountId(), startOfLastMonth);
			BigDecimal expenditure = transactionRepository.sumExpenditureTransactions(
					account.getAccountId(), startOfLastMonth);

			BigDecimal turnover = (income != null ? income : BigDecimal.ZERO)
					.subtract(expenditure != null ? expenditure : BigDecimal.ZERO);
			account.setPastMonthTurnover(turnover);
			accountRepository.save(account);
		});
	}
}
