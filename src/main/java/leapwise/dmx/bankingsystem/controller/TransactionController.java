package leapwise.dmx.bankingsystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import leapwise.dmx.bankingsystem.dto.TransactionDTO;
import leapwise.dmx.bankingsystem.dto.TransactionRequestDTO;
import leapwise.dmx.bankingsystem.mapper.TransactionMapper;
import leapwise.dmx.bankingsystem.model.Transaction;
import leapwise.dmx.bankingsystem.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;
	private final TransactionMapper transactionMapper;

	@PostMapping("/transaction")
	@Operation(summary = "Create a transaction", description = "Processes a new transaction and returns its ID")
	@ApiResponse(responseCode = "200", description = "Transaction created successfully",
			content = @Content(schema = @Schema(implementation = Long.class)))
	public Long createTransaction(@RequestBody TransactionRequestDTO transaction) {
		return transactionService.processTransaction(transaction);
	}

	@GetMapping("/customer/history/{customerId}")
	@Operation(summary = "Get customer transaction history", description = "Returns the transaction history for a customer")
	@ApiResponse(responseCode = "200", description = "Successful operation",
			content = @Content(schema = @Schema(implementation = TransactionDTO[].class)))
	public ResponseEntity<List<TransactionDTO>> getCustomerTransactions(
			@PathVariable("customerId") Long customerId,
			@RequestParam Map<String, String> allParams) {

		String filterName = allParams.keySet().stream().findFirst().orElse(null);
		String filterValue = allParams.get(filterName);

		List<Transaction> transactions;

		// Check if the filter is for 'timestamp' and parse it to LocalDateTime if so
		if ("timestamp".equals(filterName)) {
			LocalDateTime timestamp;
			try {
				timestamp = LocalDateTime.parse(filterValue);
			} catch (DateTimeParseException e) {
				return ResponseEntity.badRequest().build();
			}
			transactions = transactionService.getCustomerTransactionsByTimestamp(customerId, timestamp);
		} else {
			transactions = transactionService.getCustomerTransactions(customerId, filterName, filterValue);
		}

		List<TransactionDTO> transactionDTOs = transactions.stream()
				.map(transactionMapper::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.ok(transactionDTOs);
	}
}
