package leapwise.dmx.bankingsystem.exception;

public class TransactionFailureException extends RuntimeException {
	public TransactionFailureException(String message) {
		super(message);
	}
}
