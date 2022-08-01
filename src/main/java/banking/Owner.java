package banking;

public class Owner extends Admins {
	
	private Customers DaCustomer;
	private String OwnerName;

	public Owner(int AccountNumber, int balance, String name) {
		super(AccountNumber, balance, name);
	}
	
	public Owner(String Name) {
		this.OwnerName = Name;
	}
	
	public int ChangeCustomerAmount(int AccountNumber, int balance) {
		int ReturnedBalance = 0;
		if(DaCustomer.getAccount() == AccountNumber) {
			ReturnedBalance = DaCustomer.setBalance(balance);
			System.out.println("You have changed: "+DaCustomer.getName()+" Account Balance");
		} else {
//			ReturnedBalance = DaCustomer.getBalance();
			System.out.println("The system couldn' find that account number, No change has taken place");
		}
		return ReturnedBalance;
	}

}
