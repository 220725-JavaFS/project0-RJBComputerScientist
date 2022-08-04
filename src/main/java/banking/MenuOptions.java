package banking;

import java.util.ArrayList;

public class MenuOptions {
//	public static void PrintOutCustomers(Customer[] customers) {
		public static void PrintOutCustomers(ArrayList<Human> customers) {
		System.out.println("Here are the customers");
//		Customer[] AllCustomers = customer.getCustomers();
		try {
		if(customers != null & customers.size() > 0) {
			System.out.println("Here are the names: ");
			for(Human x : customers) {
				System.out.println("Name: "+x.getName()+"\tBalance: "+x.getBalance()+"\tAccount Number: "+x.getAccount());
			}
		} else {
			System.out.println("Your Customers Are Empty");
		}
		} catch(Exception e) {
			System.out.println("There are no accounts");
			e.printStackTrace();
		}
	}
	
	public static void PrintOutAdmins(Admin admin) {
//		NOT USING THIS RIGHT NOW. i need to add hardcoded logic for admin name, balance and account number
//		^^^ might take that away and just have admins have customer accounts. 
		System.out.println("Here are the customers");
		ArrayList<Human> AllAdmin = admin.getAdminAccounts();
		if(AllAdmin != null & AllAdmin.size() > 0) {
			System.out.println("Here are the Admin IDs: ");
			for(Human x : AllAdmin) {
				System.out.println("Name: "+x.getName()+"Balance: "+x.getBalance()+"Account Number: "+x.getAccount());
			}
		} else {
			System.out.println("Your Customers Are Empty");
		}
	}
	
//	public static void RemoveCustomer(int AccountNumber, Customer[] Accounts) {
	public static void RemoveCustomer(int AccountNumber, ArrayList<Human> Accounts) {
		for(int x = 0; x < Accounts.size(); x++) {
			int CustomerNumber = Accounts.get(x).getAccount();
			if(CustomerNumber == AccountNumber && CustomerNumber != 0) {
				System.out.println(Accounts.get(x).getName()+" Has Been Deleted");
//				Accounts[x] = null;
				Accounts.set(x, null);
			}
		}
	}
}
