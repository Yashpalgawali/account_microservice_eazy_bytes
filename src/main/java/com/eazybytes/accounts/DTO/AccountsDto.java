package com.eazybytes.accounts.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

	@NotEmpty(message = "Account Number Cannot be empty or null")
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Account number must have 10 digits")
	private Long accountNumber;

	@NotEmpty(message = "Account type cant be empty or null")
	private String accountType;

	@NotEmpty(message = "Branch address cant be empty or null")
	private String branchAddress;
}
