package leapwise.dmx.bankingsystem;

import leapwise.dmx.bankingsystem.controller.CustomerController;
import leapwise.dmx.bankingsystem.dto.CustomerDTO;
import leapwise.dmx.bankingsystem.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void getCustomerReturnsCustomerDetails() throws Exception {
		CustomerDTO customer = new CustomerDTO();
		customer.setName("John Doe");
		customer.setAddress("1234 Street");
		customer.setEmail("john@example.com");
		customer.setPhoneNumber("1234567890");

		Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);

		mockMvc.perform(get("/customer/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("John Doe"));
	}
}
