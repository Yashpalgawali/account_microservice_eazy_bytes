package com.eazybytes.accounts.service;

import com.eazybytes.accounts.DTO.CustomerDto;

public interface IAccountsService {

	public void createAccount(CustomerDto customerDto);
	
	public CustomerDto fetchAccount(String mobNumber);
	
	public boolean updateAccount(CustomerDto customerDto);
	
	public boolean deleteAccount(String mobileNumber);
}
