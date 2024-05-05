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
@Schema(description = "Data transfer object for creating a new transaction")
public class TransactionRequestDTO {

	@Schema(description = "ID of the sender's account", example = "1")
	private Long senderAccountId;

	@Schema(description = "ID of the receiver's account", example = "2")
	private Long receiverAccountId;

	@Schema(description = "The amount to be transferred", example = "200.00")
	private BigDecimal amount;

	@Schema(description = "Currency of the transaction", example = "USD")
	private String currencyId;

	@Schema(description = "Message related to the transaction", example = "Invoice payment")
	private String message;

	@Schema(description = "Timestamp of the transaction", example = "2024-04-07T15:48:22")
	private LocalDateTime timestamp;
}
