package leapwise.dmx.bankingsystem;

import leapwise.dmx.bankingsystem.dto.CustomerDTO;
import leapwise.dmx.bankingsystem.exception.CustomerNotFoundException;
import leapwise.dmx.bankingsystem.mapper.CustomerMapper;
import leapwise.dmx.bankingsystem.model.Customer;
import leapwise.dmx.bankingsystem.repository.CustomerRepository;
import leapwise.dmx.bankingsystem.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTests {

	@Autowired
	private CustomerMapper customerMapper;

	@MockBean
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void testGetCustomerByIdFound() {
		Long customerId = 1L;
		Customer expectedCustomer = new Customer();
		expectedCustomer.setCustomerId(customerId);
		expectedCustomer.setName("John Doe");

		when(customerService.getCustomerById(customerId)).thenReturn(customerMapper.toDto(expectedCustomer));

		CustomerDTO result = customerService.getCustomerById(customerId);

		assertNotNull(result);
		assertEquals("John Doe", result.getName());
	}

	@Test
	public void testGetCustomerByIdNotFound() {
		Long nonExistingCustomerId = 99L;
		when(customerRepository.findById(nonExistingCustomerId)).thenReturn(Optional.empty());

		CustomerService customerService = new CustomerService(customerRepository, customerMapper);

		assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(nonExistingCustomerId));
	}
}
