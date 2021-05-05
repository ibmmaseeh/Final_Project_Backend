package com.ibm.AccountManagementSystem.entity;

public class Bank {
	private String branchName;
	private String codeIFSC;
	private Address address;
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getCodeIFSC() {
		return codeIFSC;
	}
	public void setCodeIFSC(String codeIFSC) {
		this.codeIFSC = codeIFSC;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
