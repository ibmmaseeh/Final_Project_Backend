package com.ibm.AccountManagementSystem.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {
	
	@Id
	private String id;
	private Address address;
	private float balance;
	private Date createdDate;
	private STATUS status;
	private TYPE type;
	
	
	
	

}
