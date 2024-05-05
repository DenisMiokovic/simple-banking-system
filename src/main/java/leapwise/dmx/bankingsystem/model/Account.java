package leapwise.dmx.bankingsystem.model;

import jakarta.persistence.*;
import leapwise.dmx.bankingsystem.enums.AccountTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;

	private String accountNumber;

	@Enumerated(EnumType.STRING)
	private AccountTypeEnum accountType;

	private BigDecimal balance;
	private BigDecimal pastMonthTurnover;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
