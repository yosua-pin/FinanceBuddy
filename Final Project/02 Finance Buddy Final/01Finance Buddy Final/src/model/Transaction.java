package model;

public class Transaction {
    private int TransID;
    private int Amount;
    private int id;
    private String Bank;
    private String AccountName;
    private String Category;
    private String Description;
    private String AccountNumber;
    private String TransDate;
    
    public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public int getTransID() {
        return TransID;
    }
    public void setTransID(int transID) {
        TransID = transID;
    }
    public int getAmount() {
        return Amount;
    }
    public void setAmount(int amount) {
        Amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getBank() {
    	return Bank;
    }
    public void setBank(String bank) {
    	Bank = bank;
    }
    public String getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
    public String getTransDate() {
        return TransDate;
    }
    public void setTransDate(String transDate) {
        TransDate = transDate;
    }
    public Transaction(int transID, int amount, int id, String category, String description, String accountNumber,
            String transDate, String bank, String accountName) {
        super();
        TransID = transID;
        Amount = amount;
        this.id = id;
        Category = category;
        Description = description;
        AccountNumber = accountNumber;
        TransDate = transDate;
        Bank = bank;
        AccountName = accountName;
    }

    public Transaction() {
    	}
    }

