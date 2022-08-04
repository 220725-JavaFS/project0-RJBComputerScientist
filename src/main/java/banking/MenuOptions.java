package banking;

import java.util.ArrayList;

public class MenuOptions {
//	public static void PrintOutCustomers(Customer[] customers) {
		public static void PrintOutCustomers(ArrayList<Human> customers) {
		System.out.println("Here are the customers");
//		Customer[] AllCustomers = customer.getCustomers();
		try {
		if(customers != null & customers.size() > 0) {
			System.out.println("Here are the names: \n");
			for(Human x : customers) {
				System.out.println("Name: "+x.getName()+"\tBalance: "+x.getBalance()+"\tAccount Number: "+x.getAccount()+"\n");
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
				System.out.println(Accounts.get(x).getName()+"'s"+" Has Been Deleted");
//				Accounts[x] = null;
				Accounts.set(x, null);
			} else {
				System.out.println("No Account Was Deleted");
			}
		}
	}
	
	public static void Deposit(int balance, int AccountNumber, ArrayList<Human> Accounts) {
		for(int x = 0; x < Accounts.size(); x++) {
			int CustomerNumber = Accounts.get(x).getAccount();
			if(CustomerNumber == AccountNumber && CustomerNumber != 0) {
				System.out.println(Accounts.get(x).getName()+"'s"+" Balance Has Increased");
				int NewBalance = Accounts.get(x).getBalance() + balance;
				Accounts.get(x).setBalance(NewBalance);
			} else {
				System.out.println("No Account Was Found");
			}
		}
	}
	
	public static void Withdraw(int balance, int AccountNumber, ArrayList<Human> Accounts) {
		for(int x = 0; x < Accounts.size(); x++) {
			int CustomerNumber = Accounts.get(x).getAccount();
			if(CustomerNumber == AccountNumber && CustomerNumber != 0) {
				int CustomerBalance = Accounts.get(x).getBalance();
				if(balance > CustomerBalance) {
					System.out.println("A negative account will occur. RE TRY YOUR ENTRIES");
					System.out.println("Your Balance: "+balance+" Is Higher Than "+"\n"+Accounts.get(x).getName() + "'s"+"Balance: "+CustomerBalance);
					break;
				}
				System.out.println(Accounts.get(x).getName()+"'s"+" Balance Has Decreased");
				int NewBalance = CustomerBalance - balance;
				Accounts.get(x).setBalance(NewBalance);
			} else {
				System.out.println("No Account Was Found");
			}
		}
	}
	
}
