package com.ibm.AccountManagementSystem.entity;

import java.util.Date;

public class Transaction {
	private String id;
	private Date date;
	private TRANSACTION_TYPE type;
	private float amount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TRANSACTION_TYPE getType() {
		return type;
	}
	public void setType(TRANSACTION_TYPE type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	

}
