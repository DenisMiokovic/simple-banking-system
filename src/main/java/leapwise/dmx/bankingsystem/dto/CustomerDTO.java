package leapwise.dmx.bankingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data transfer object representing a customer")
public class CustomerDTO {

	@Schema(description = "The name of the customer", example = "John Doe")
	private String name;

	@Schema(description = "The address of the customer", example = "1234 Elm Street")
	private String address;

	@Schema(description = "The email of the customer", example = "johndoe@example.com")
	private String email;

	@Schema(description = "The phone number of the customer", example = "+1234567890")
	private String phoneNumber;

	@Schema(description = "List of accounts associated with the customer")
	private List<AccountDTO> accounts;
}
