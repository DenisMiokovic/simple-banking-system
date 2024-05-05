package leapwise.dmx.bankingsystem.service;

import leapwise.dmx.bankingsystem.dto.AccountDTO;
import leapwise.dmx.bankingsystem.dto.CustomerDTO;
import leapwise.dmx.bankingsystem.exception.CustomerNotFoundException;
import leapwise.dmx.bankingsystem.mapper.AccountMapper;
import leapwise.dmx.bankingsystem.mapper.CustomerMapper;
import leapwise.dmx.bankingsystem.model.Customer;
import leapwise.dmx.bankingsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;

	public CustomerDTO getCustomerById(Long customerId) {
		log.debug("Fetching customer with id: {}", customerId);
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer.map(c -> {
			CustomerDTO customerDTO = customerMapper.toDto(c);
			List<AccountDTO> accountDTOs = c.getAccounts().stream()
					.map(AccountMapper.INSTANCE::toDto)
					.collect(Collectors.toList());
			customerDTO.setAccounts(accountDTOs);
			return customerDTO;
		}).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));
	}
}
