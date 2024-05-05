package leapwise.dmx.bankingsystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import leapwise.dmx.bankingsystem.dto.CustomerDTO;
import leapwise.dmx.bankingsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping("/{id}")
	@Operation(summary = "Get a customer by ID", description = "Returns a single customer")
	@ApiResponse(responseCode = "200", description = "Successful operation",
			content = @Content(schema = @Schema(implementation = CustomerDTO.class)))
	public CustomerDTO getCustomer(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
}
