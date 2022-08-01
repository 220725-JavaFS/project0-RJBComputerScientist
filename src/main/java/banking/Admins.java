package banking;

public class Admins extends Human {
	
	private String AdminName;
	
	private Customers[] Accounts;
	
	public Admins(int AccountNumber, int balance, String name) {
		super(AccountNumber, balance, name);
	}
	
	public Admins(String Name) {
		this.AdminName = Name;
	}
	
	public Admins() {
		
	}
	
	public Customers[] getAccounts() {
		return Accounts;
	}
	
	public Customers getCustomerName(String Name) {
		for(int x = 0; x < Accounts.length; x++) {
			String Q = Accounts[x].getName();
			if(Q == Name) {
				System.out.println(Accounts[x].getName());
				return Accounts[x];
			}
		}
		return null;
	}
}
