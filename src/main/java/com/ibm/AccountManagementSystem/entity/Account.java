package com.ibm.AccountManagementSystem.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {
	
	@Id
	private String id;
	private Address address;
	private float balance;
	private Bank bank;
	private Date createdDate;
	private STATUS status;
	private TYPE type;
	private String accountNumber;
//	private float amount;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
//	public float getAmount() {
//		return amount;
//	}
//	public void setAmount(float amount) {
//		this.amount = amount;
//	}
	
	
	
	
	
	
	

}
