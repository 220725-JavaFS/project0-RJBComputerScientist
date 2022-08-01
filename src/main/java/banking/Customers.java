package banking;

public class Customers extends Human {
	
	private Customers[] AllCustomers;

	public Customers(int AccountNumber, int balance, String name) {
		super(AccountNumber, balance, name);
	}
	
	public int LengthOfAccountNumbers() {
		int TotalAccounts = 0;
		for(int x = 0; x <= AllCustomers.length; x++) {
			TotalAccounts = AllCustomers[x].getAccount();
		}
		return TotalAccounts;
	}
	
	public Customers[] getCustomers() {
		return this.AllCustomers;
	}
	
//	public void setCustomers(Customers NewCustomer) {
//		AllCustomers.push(NewCustomer);
	public void setCustomers(Customers NewCustomer, int index) {
		this.AllCustomers[index] = NewCustomer;
	}
	
}
