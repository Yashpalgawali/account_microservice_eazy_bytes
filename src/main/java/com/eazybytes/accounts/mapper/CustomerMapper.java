package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.DTO.CustomerDto;
import com.eazybytes.accounts.entity.Customer;

public class CustomerMapper {

public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
		
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		
		return customerDto;
	}

public static Customer mapToCustomer(Customer customer, CustomerDto customerDto) {
	System.err.println("Inside mapToCustomer mapper \n Customer DTO = "+customerDto);
	customer.setName(customerDto.getName());
	customer.setEmail(customerDto.getEmail());
	customer.setMobileNumber(customerDto.getMobileNumber());
	System.err.println("Customer Object = "+customer.toString());
	return customer;
}
}
