package banking;

import java.util.ArrayList;

public class Customer extends Human {
	
	private Customer[] AllCustomers;
	private ArrayList<Human> DaCustomers = new ArrayList<Human>();

	public Customer(int AccountNumber, int balance, String name) {
		super(AccountNumber, balance, name);
	}
	
	public Customer() {
		
	}
	
	public int LengthOfAccountNumbers() {
		int TotalAccounts = 0;
		for(int x = 0; x <= AllCustomers.length; x++) {
			TotalAccounts = AllCustomers[x].getAccount();
		}
		return TotalAccounts;
	}
	
	public Customer[] getCustomers() {
		return this.AllCustomers;
	}
	
//	public void setCustomers(Customers NewCustomer) {
//		AllCustomers.push(NewCustomer);
	public void setCustomers(Customer NewCustomer, int index) {
		this.AllCustomers[index] = NewCustomer;
	}
//	^^^ arrays
	
	public Human getCustomer() {
		return null;
	}
	
	public Human RemoveAccount(Human account) {
		if(DaCustomers.remove(account)) {
			return account;
		}
		return null;
	}
	
	public void AddAccount(Human account) {
		DaCustomers.add(account);
	}
	
	public ArrayList<Human> getCustomerAccounts(){
		return DaCustomers;
	}
//	^^^ Lists
	
}
