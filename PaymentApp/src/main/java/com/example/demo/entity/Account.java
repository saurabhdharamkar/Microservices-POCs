package com.example.demo.entity;

import java.util.List;


public class Account {
	

	private int accountNo;
	
	private String bankName;
	
	private String branch;
	
	private String ifscCode;
	
	private String address;
	
	private int accountBalance;
	
	private String transactionStatus;
	
	private int deposit;
	
	private int withdraw;
	
	private List<User> user;

	

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", bankName=" + bankName + ", branch=" + branch + ", ifscCode="
				+ ifscCode + ", address=" + address + ", accountBalance=" + accountBalance + ", transactionStatus="
				+ transactionStatus + ", deposit=" + deposit + ", withdraw=" + withdraw + ", user=" + user + "]";
	}

	
	
	
	
	
	

}
