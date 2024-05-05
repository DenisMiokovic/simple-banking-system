package leapwise.dmx.bankingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	private String name;
	private String address;
	private String email;
	private String phoneNumber;

	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;
}
