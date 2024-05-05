package leapwise.dmx.bankingsystem;

import leapwise.dmx.bankingsystem.controller.TransactionController;
import leapwise.dmx.bankingsystem.dto.TransactionDTO;
import leapwise.dmx.bankingsystem.mapper.TransactionMapper;
import leapwise.dmx.bankingsystem.model.Transaction;
import leapwise.dmx.bankingsystem.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;

	@MockBean
	private TransactionMapper transactionMapper;

	@Test
	public void testGetCustomerTransactionsWithoutFilters() throws Exception {
		List<Transaction> transactions = new ArrayList<>();
		TransactionDTO transactionDTO = new TransactionDTO("ACC123", "ACC456", new BigDecimal("100.00"), "USD", "Test transaction", LocalDateTime.now());
		transactions.add(new Transaction());

		when(transactionService.getCustomerTransactions(anyLong(), any(), any())).thenReturn(transactions);
		when(transactionMapper.toDto(any(Transaction.class))).thenReturn(transactionDTO);

		mockMvc.perform(get("/customer/history/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].senderAccountNumber", is("ACC123")));
	}

	@Test
	public void testGetCustomerTransactionsWithInvalidTimestamp() throws Exception {
		mockMvc.perform(get("/customer/history/1?timestamp=invalid-timestamp"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetCustomerTransactionsWithFilters() throws Exception {
		List<Transaction> transactions = new ArrayList<>();
		TransactionDTO transactionDTO = new TransactionDTO("ACC123", "ACC456", new BigDecimal("200.00"), "USD", "Filtered transaction", LocalDateTime.now());
		transactions.add(new Transaction());

		when(transactionService.getCustomerTransactions(anyLong(), eq("amount"), eq("200.00"))).thenReturn(transactions);
		when(transactionMapper.toDto(any(Transaction.class))).thenReturn(transactionDTO);

		mockMvc.perform(get("/customer/history/1?amount=200.00")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].amount", is(200.00)));
	}
}
