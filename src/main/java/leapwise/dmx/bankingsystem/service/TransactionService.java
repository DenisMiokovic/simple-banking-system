package leapwise.dmx.bankingsystem.service;

import leapwise.dmx.bankingsystem.dto.TransactionRequestDTO;
import leapwise.dmx.bankingsystem.mapper.TransactionRequestMapper;
import leapwise.dmx.bankingsystem.model.Account;
import leapwise.dmx.bankingsystem.model.Transaction;
import leapwise.dmx.bankingsystem.repository.AccountRepository;
import leapwise.dmx.bankingsystem.repository.TransactionRepository;
import leapwise.dmx.bankingsystem.util.TransactionSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static leapwise.dmx.bankingsystem.enums.AccountRoleEnum.RECEIVER;
import static leapwise.dmx.bankingsystem.enums.AccountRoleEnum.SENDER;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;
	private final MailService mailService;
	private final TransactionRequestMapper transactionRequestMapper;

	public Long processTransaction(TransactionRequestDTO requestDTO) {
		Account senderAccount = accountRepository.findById(requestDTO.getSenderAccountId())
				.orElseThrow(() -> new RuntimeException("Sender account not found"));

		Account receiverAccount = accountRepository.findById(requestDTO.getReceiverAccountId())
				.orElseThrow(() -> new RuntimeException("Receiver account not found"));

		BigDecimal oldBalanceSender = senderAccount.getBalance();
		BigDecimal newBalanceSender = oldBalanceSender.subtract(requestDTO.getAmount());
		BigDecimal oldBalanceReceiver = receiverAccount.getBalance();
		BigDecimal newBalanceReceiver = oldBalanceReceiver.add(requestDTO.getAmount());
		log.debug("Saving transaction: {}", requestDTO);

		Transaction transaction = transactionRequestMapper.toEntity(requestDTO);
		transaction.setTimestamp(LocalDateTime.now());
		Transaction savedTransaction = transactionRepository.save(transaction);

		// updating account balances
		senderAccount.setBalance(newBalanceSender);
		receiverAccount.setBalance(newBalanceReceiver);
		accountRepository.save(senderAccount);
		accountRepository.save(receiverAccount);

		log.debug("Transaction with transactionId {} saved. Returning transactionId.", savedTransaction.getTransactionId());

		// Sending confirmation email to the SENDER
		mailService.sendTransactionEmail(
				senderAccount.getCustomer().getEmail(),
				savedTransaction.getTransactionId(),
				SENDER,
				requestDTO.getAmount(),
				requestDTO.getCurrencyId(),
				oldBalanceSender,
				newBalanceSender
		);

		// Sending confirmation email to the RECEIVER
		mailService.sendTransactionEmail(
				receiverAccount.getCustomer().getEmail(),
				savedTransaction.getTransactionId(),
				RECEIVER,
				requestDTO.getAmount(),
				requestDTO.getCurrencyId(),
				oldBalanceReceiver,
				newBalanceReceiver
		);

		return savedTransaction.getTransactionId();
	}

	public List<Transaction> getCustomerTransactionsByTimestamp(Long customerId, LocalDateTime timestamp) {
		return transactionRepository.findByCustomerIdAndTimestamp(customerId, timestamp);
	}

	public List<Transaction> getCustomerTransactions(Long customerId, String fieldName, Object value) {
		log.debug("Retrieving transactions for customer with ID: {}", customerId);
		return transactionRepository.findAll(TransactionSpecifications.customerTransactionsWithDynamicFilter(customerId, fieldName, value));
	}
}
