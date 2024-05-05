package leapwise.dmx.bankingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BankingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingsystemApplication.class, args);
	}

}
