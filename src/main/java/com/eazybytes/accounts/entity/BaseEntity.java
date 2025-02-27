package com.eazybytes.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass // This annotaion will tell the spring data jpa that this class is going to be the super class for all the entities
public class BaseEntity {

	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@Column(updatable = false)
	private String  createdBy;
	
	@Column( insertable = false)
	private LocalDateTime updatedAt;
	
	@Column( insertable = false)
	private String  updatedBy;
}
