package com.eazybytes.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity{

	@Id
	@SequenceGenerator(allocationSize = 1, name = "customer_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "customer_seq")
	private Long customerId;
	
	private String Name;
	
	private String email;
	
	private String mobileNumber;
}
