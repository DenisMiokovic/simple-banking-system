package leapwise.dmx.bankingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object representing a transaction")
public class TransactionDTO {

	@Schema(description = "Account number of the sender", example = "ACC10001")
	private String senderAccountNumber;

	@Schema(description = "Account number of the receiver", example = "ACC10002")
	private String receiverAccountNumber;

	@Schema(description = "The amount of the transaction", example = "150.50")
	private BigDecimal amount;

	@Schema(description = "The currency ID of the transaction", example = "USD")
	private String currencyId;

	@Schema(description = "A message associated with the transaction", example = "Payment for services")
	private String message;

	@Schema(description = "The timestamp when the transaction occurred", example = "2024-04-07T15:48:22")
	private LocalDateTime timestamp;
}
