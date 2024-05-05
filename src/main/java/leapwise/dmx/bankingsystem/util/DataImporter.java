package leapwise.dmx.bankingsystem.util;

import leapwise.dmx.bankingsystem.model.Transaction;
import leapwise.dmx.bankingsystem.repository.AccountRepository;
import leapwise.dmx.bankingsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataImporter implements CommandLineRunner {

	private static final int BATCH_SIZE = 1000;
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;

	@Override
	public void run(String... args) {
		Long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Transaction> batch = new ArrayList<>();

		InputStream inputStream = getClass().getResourceAsStream("/mock_data.csv");
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!");
		} else {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
				reader.lines().forEach(line -> executor.execute(() -> {
					Transaction transaction = parseTransactionFromCSV(line);
					synchronized (batch) {
						batch.add(transaction);
						if (batch.size() >= BATCH_SIZE) {
							transactionRepository.saveAll(new ArrayList<>(batch));
							batch.clear();
						}
					}
				}));
			}
			catch (IOException e) {
				log.error("Error reading file!", e);
			}
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
			// wait for all threads to finish
		}
		if (!batch.isEmpty()) {
			transactionRepository.saveAll(batch); // Save remaining transactions
		}
		Long endTime = System.currentTimeMillis();
		log.debug("All transactions parsed successfully in {} seconds.", (endTime - startTime) / 1000);
	}

	private Transaction parseTransactionFromCSV(String line) {
		String[] data = line.split(",");
		Transaction transaction = new Transaction();
		transaction.setSenderAccount(accountRepository.findById(Long.parseLong(data[0])).orElseThrow());
		transaction.setReceiverAccount(accountRepository.findById(Long.parseLong(data[1])).orElseThrow());
		transaction.setAmount(new BigDecimal(data[2]));
		transaction.setCurrencyId(data[3]);
		transaction.setMessage(data[4]);
		transaction.setTimestamp(LocalDateTime.parse(data[5], FORMATTER));
		return transaction;
	}
}
