package leapwise.dmx.bankingsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {

	CHK("Checking"),
	SAV("Savings"),
	INV("Investment");

	private final String description;
}
