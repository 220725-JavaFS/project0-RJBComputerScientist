package banking;

import java.util.ArrayList;

public class Admin extends Human {
	
	private String AdminName;
	protected int AdminID;
	protected int PassCode;
	
	private Customer[] Accounts;
	private ArrayList<Human> AdminAccounts = new ArrayList<Human>();
	
	public Admin(int AccountNumber, int balance, String name) {
		super(AccountNumber, balance, name);
	}
//	^^ from memory .. testing
	
	public Admin(int AdminNumber, String Aname, int PassCode) {
		this.AdminID = AdminNumber;
		this.AdminName = Aname;
		this.PassCode = PassCode;
	}
//	^^ for database
	
	public int getAdminID() {
		return AdminID;
	}
	
//	public Admins(String Name) {
//		this.AdminName = Name;
//	}
//	
	public Admin(int AdminID) {
		this.AdminID = AdminID;
	}
	
//	public Admins() {
//		super();
//	}
	
	public Admin() {
		
	}

	public Customer[] getAccounts() {
		return Accounts;
	}
	
	public Customer getCustomerName(String Name) {
		for(int x = 0; x < Accounts.length; x++) {
			String Q = Accounts[x].getName();
			if(Q == Name) {
				System.out.println(Accounts[x].getName());
				return Accounts[x];
			}
		}
		return null;
	}
	
	public void RemoveCustomer(int AccountNumber) {
		for(int x = 0; x < Accounts.length; x++) {
			int CustomerNumber = Accounts[x].getAccount();
			if(CustomerNumber == AccountNumber && CustomerNumber != 0) {
				System.out.println(Accounts[x].getName()+" Has Been Deleted");
				Accounts[x] = null;
			}
		}
	}
//	^^^ Arrays
	
	public void setAdminAccounts(ArrayList<Human> accounts) {
		this.AdminAccounts = accounts;
	}
	
	public ArrayList<Human> getAdminAccounts(){
		return AdminAccounts;
	}
	//^^^ lists
}
