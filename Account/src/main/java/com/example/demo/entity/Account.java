package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="account")
@Setter
@Getter
@ToString
public class Account {
	
	@Id
	@GeneratedValue
	@Column(name="account_no")
	private int accountNo;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="address")
	private String address;
	
	@Column(name="account_balance")
	private int accountBalance;
	
	@Column(name="transaction_status")
	private String transactionStatus;
	
	@Column(name="deposit")
	private int deposit;
	
	@Column(name="withdraw")
	private int withdraw;
	
	//@Size(min = 3, max = 15)
	@Column(name="password")
	private int password;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="account_no")
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
	
	

	

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", bankName=" + bankName + ", branch=" + branch + ", ifscCode="
				+ ifscCode + ", address=" + address + ", accountBalance=" + accountBalance + ", transactionStatus="
				+ transactionStatus + ", deposit=" + deposit + ", withdraw=" + withdraw + ", password=" + password
				+ ", user=" + user + "]";
	}


}
