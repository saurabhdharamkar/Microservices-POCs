package com.example.demo.payload;

public class TransferAccountDetails {
	
	private int accountNo1;
	
	private int AccountBalanceBeforeTransaction;
	
	private int transferedAmmount;
	
	private int AccountBalanceAfterTransaction;
	
	private String msg;

	public int getAccountNo1() {
		return accountNo1;
	}

	public void setAccountNo1(int accountNo1) {
		this.accountNo1 = accountNo1;
	}

	public int getAccountBalanceBeforeTransaction() {
		return AccountBalanceBeforeTransaction;
	}

	public void setAccountBalanceBeforeTransaction(int accountBalanceBeforeTransaction) {
		AccountBalanceBeforeTransaction = accountBalanceBeforeTransaction;
	}

	public int getTransferedAmmount() {
		return transferedAmmount;
	}

	public void setTransferedAmmount(int transferedAmmount) {
		this.transferedAmmount = transferedAmmount;
	}

	public int getAccountBalanceAfterTransaction() {
		return AccountBalanceAfterTransaction;
	}

	public void setAccountBalanceAfterTransaction(int accountBalanceAfterTransaction) {
		AccountBalanceAfterTransaction = accountBalanceAfterTransaction;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	


}
