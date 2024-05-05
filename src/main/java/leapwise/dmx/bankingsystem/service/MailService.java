package leapwise.dmx.bankingsystem.service;

import leapwise.dmx.bankingsystem.enums.AccountRoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static leapwise.dmx.bankingsystem.enums.AccountRoleEnum.RECEIVER;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

	private final JavaMailSender javaMailSender;

	public void sendTransactionEmail(String to, Long transactionId, AccountRoleEnum role, BigDecimal amount, String currency, BigDecimal oldBalance, BigDecimal newBalance) {
		log.debug("Sending mail to {} ", to);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("no-reply@example.com");
		message.setTo(to);
		message.setSubject("Transaction Confirmation");
		message.setText(String.format(
				"""
						Hello!

						The transaction with ID: %d has been processed
						and the amount of %s%s has been %s your account.

						Old balance: %s%s
						New balance: %s%s

						Regards,
						Your Evil Inc. Bank""",
				transactionId, amount, currency, role.equals(RECEIVER) ? "added to" : "taken from", oldBalance, currency, newBalance, currency
		));

		javaMailSender.send(message);
		log.debug("Mail sent successfully.");
	}
}
