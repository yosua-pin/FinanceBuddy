package model;

public class Bank {
	Transaction transaction;
	private String AccountNumber;
	private String Bank;
	private String AccountName;
	public Bank(String accountNumber, String bank, String accountName) {
		super();
		AccountNumber = accountNumber;
		Bank = bank;
		AccountName = accountName;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getBank() {
		return Bank;
	}
	public void setBank(String bank) {
		Bank = bank;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	
	public Bank() {
	}
}
