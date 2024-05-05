package leapwise.dmx.bankingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object representing an account")
public class AccountDTO {

	@Schema(description = "The account number", example = "ACC10001")
	private String accountNumber;

	@Schema(description = "The type of the account", example = "SAVINGS")
	private String accountType;

	@Schema(description = "The current balance of the account", example = "1000.00")
	private BigDecimal balance;

	@Schema(description = "The total turnover of the past month", example = "5000.00")
	private BigDecimal pastMonthTurnover;
}
