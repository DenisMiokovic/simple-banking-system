package leapwise.dmx.bankingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(UnauthorizedAccessException.class)
	public ResponseEntity<String> handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
	}

	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<String> handleInsufficientFundsException(InsufficientFundsException ex) {
		return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(ex.getMessage());
	}

	@ExceptionHandler(TransactionFailureException.class)
	public ResponseEntity<String> handleTransactionFailureException(TransactionFailureException ex) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Transaction failed: " + ex.getMessage());
	}

	@ExceptionHandler(ResourceConflictException.class)
	public ResponseEntity<String> handleResourceConflictException(ResourceConflictException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
	}
}
