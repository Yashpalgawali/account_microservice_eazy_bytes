package com.eazybytes.accounts.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.eazybytes.accounts.DTO.AccountsDto;
import com.eazybytes.accounts.DTO.CustomerDto;
import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exceptions.CustomerAlreadyExistsException;
import com.eazybytes.accounts.exceptions.ResourceNotFoundException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

	private AccountsRepository accountRepository;

	private CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDto customerDto) {

		Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
		
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

		if (optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException(
					"Customer is already registered with the given mobile number " + customerDto.getMobileNumber());
		}
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Anonymous");
		
		Customer savedCustomer = customerRepository.save(customer);
		 
		accountRepository.save(createNewAccounts(savedCustomer));
	}

	
	private Accounts createNewAccounts(Customer customer) {
		
		Accounts newAccount  = new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 10000000L  + new Random().nextInt(9000000);
		
		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		
		newAccount.setCreatedAt(LocalDateTime.now());
		newAccount.setCreatedBy("Anonymous");
		
		return newAccount;
	}


	@Override
	public CustomerDto fetchAccount(String mobNumber) {
		Customer customerObj = customerRepository.findByMobileNumber(mobNumber).orElseThrow(()->  new ResourceNotFoundException("Customer ","Mobile Number ",mobNumber));
		
		Accounts account = accountRepository.findByCustomerId(customerObj.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account" , "CustomerId", customerObj.getCustomerId().toString() ));
		
//		CustomerDto customerDto = new CustomerDto();
//		customerDto.setName(customerObj.getName());
//		customerDto.setEmail(customerObj.getEmail());
//		customerDto.setAccountsDto(account);
		CustomerDto custDto = CustomerMapper.mapToCustomerDto(customerObj, new CustomerDto());
		custDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
		
		return custDto;
	}
}
