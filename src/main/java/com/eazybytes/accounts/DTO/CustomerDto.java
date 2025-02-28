package com.eazybytes.accounts.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

	@NotEmpty(message = "Name cannot be empty or null")
	@Size(min = 5 , max = 30,message = "The name should have minimum 5 and maximum 30 characters")
	private String name;
	
	@NotEmpty(message = "Email address cannot be empty or null")
	@Email(message = "Email address should be valid ")
	private String email;
	
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	private AccountsDto accountsDto;
}
