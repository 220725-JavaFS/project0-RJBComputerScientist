package banking;
/*
 * Your Admins and the Owner will have logins already
 * Admins are able to view all account numbers 
 * The Owner Overrides everything and can add and take money
 */
public abstract class Human {
	protected String name;
	protected int balance;
	protected int AccountNumber;
	protected int pass_code;
//	pass_code
	
	public Human(int AccountNumber, int balance, String name) {
		super();
		this.AccountNumber = AccountNumber;
		this.balance = balance;
		this.name = name;
//		pass_code
	}
	
	public Human() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getAccount() {
		return this.AccountNumber;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
	
	public int setBalance(int balance) {
		return this.balance = balance;
	}
	
	public void setAccount(int AccountNumber) {
		 this.AccountNumber = AccountNumber;
	}
	
	public String toString() {
		return("[Your Account Number Is - "+AccountNumber+", Your Human Name Is - "+
				name+", Your Balance Is - "+balance+"]\n");
	}

}
