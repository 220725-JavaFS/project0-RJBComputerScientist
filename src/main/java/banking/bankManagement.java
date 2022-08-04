package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

public class bankManagement {
	private static final int NULL = 0;
	private Customer[] Customers;
	
	static Connection con = (Connection) connection.getConnection();
	static String sql = "";
	
	private static boolean CheckingValidation(String name, int PassCode) {
		if(name == "" || PassCode == NULL) {
			System.out.println("All Fields Required");
			return false;
		} else {
			return true;
		}
	}
	
	public void init() {
//		Admins Admin1 = new Admins(0, 50, "Some Foo'");
//		Owner ME = new Owner(1, 1000000000, "ME");
		
//		Admins Admin1 = new Admins("Some Foo'");
//		Owner ME = new Owner("ME");
		
		Admin Admins = new Admin(0);
//		^^ with parameterized constructors using super
		ArrayList<Human> Administrators = new ArrayList<Human>();
		Administrators.add(new Admin(1));
		Administrators.add(new Admin(11));
		Admins.setAdminAccounts(Administrators);
	}
//	static Customer[] SetOfCustomers;
// Use a Array List for adding and removing for testing START HERE (DONE)
//	Also i will have different array list as well. Customers, Owner, Admins (DONE)
	static Customer Customer = new Customer();
//	^^^ adding the array of customers
	
	public static boolean customerCreateAccount(String name, int PassCode) {
		System.out.println("You Reached Me");
		try {
//			Validating if fields are filled
//			if(name == "" || PassCode == NULL) {
//				System.out.println("All Fields Required");
//				return false;
//			}
//			TEST CODE
//			Customers NextCustomer = new Customers();
//			SetOfCustomers.push(Customers())
			
//			With a method
			boolean Check = CheckingValidation(name, PassCode);
			if(Check) {
				System.out.println("\nYou're creating an account, We'll give you money for opening an account");
//				Customer NextCustomer = new Customer(Customer.LengthOfAccountNumbers(), 500, name);
//				for(Customer x : Customer.getCustomers()) {
//					if(PassCode == x.getAccount()) {
//						System.out.println(x.getAccount()+" Has Been Taken Already Try Again");
//					}
//				}
				Customer NextCustomer = new Customer(PassCode, 500, name);
//				Customer.setCustomers(NextCustomer, Customer.LengthOfAccountNumbers()+1);
//				Customer.setCustomers(NextCustomer, 1);
				Customer.AddAccount(NextCustomer);
//				^^^ using the Array List
				System.out.println("Here is Your New Account: "+NextCustomer.getName());
				System.out.println(NextCustomer.toString());
				return true;
			} 
//			querying the information to the database Serialization
//			if(Check) {

//			OFFICIAL CODE
//			Statement st = con.createStatement();
//			sql = "INSERT INTO Customer(Cname, balance, pass_code) values(' " 
//					+ name + " ', 1000, " + PassCode + ")";
////			Execution Happens Here
//			if(st.executeUpdate(sql) == 1) {
//				System.out.println(name + ", Now You're Logged In");
//				return true;
//			}
//		  }
//		} catch(SQLIntegrityConstraintViolationException error) {
////			This indicates that an integrity constraint (foreign key, primary key or unique key) has been violated.
//			System.out.println("This Username is not available");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
//		If the try fails completely 
		
	}
	public static boolean customerLogin(String name, int PassCode) {
/*		NOTES:
 * 	Remember to add in the deposit and withdraw for customer login
*/		
		try {
			boolean Check = CheckingValidation(name, PassCode);
//			I will have a set of functions to use for admins and the owner (DONE)
//			TEST CODE
			if(Check) {
				
			}
//			OFFICIAL CODE HERE
//			if(Check) {
//	//			Query The Info
//				sql = "select * from Customer where Cname=' "
//						+ name + " ' and pass_code=" + PassCode;
//				PreparedStatement st = con.prepareStatement(sql);
//				ResultSet rs = st.executeQuery();
////				Execution to log in
//				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//				
//				if(rs.next()) {
//					int choice = 5;
//					int amt = 0;
//					int senderAC = rs.getInt("AccountNumber");
//					
//					int receiveAC;
//					while(true) {
//						try {
//							System.out.println("HEY!!, "+ rs.getString("Cname"));
//							System.out.println("1) Transfer Money");
//							System.out.println("2) View Balance");
//							System.out.println("5) Log Out");
//							System.out.println("Whats Your Choice??");
//							choice = Integer.parseInt(sc.readLine());
//							
//							if(choice == 1) {
////								transfer money input logic
//								System.out.print("Enter Receiver A/C Number:");
////								I could put down a list of people who have made an account
//								receiveAC = Integer.parseInt(sc.readLine());
//								System.out.println("Enter The Amount");
//								amt = Integer.parseInt(sc.readLine());
//								
//								if(transferMoney(senderAC, receiveAC, amt)) {
//									System.out.println("MSG: Money Sent Successfully!\n");
//								} else {
//									System.out.println("ERR: Issue Sending Money");
//								}
//							} else if (choice == 2) {
//								getBalance(senderAC);
//							} else if (choice == 5) {
//								break;
//							} else {
//								System.out.println("Err: Enter Valid Input!\n");
//							}
//						} catch(Exception e) {
//							e.printStackTrace();
//						}
//					}
//				} else {
//					return false;
//				}
//			} 
//			return true;
//		} catch(SQLIntegrityConstraintViolationException error) {
//			System.out.println("Username Not Available");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	public static boolean adminAccount(int PassCode, Customers Customers) {
	public static boolean adminLogin(int PassCode) {
		try {
			if(PassCode == NULL) {
				System.out.println("All Fields Required");
				return false;
			}
			BufferedReader BF = new BufferedReader(new InputStreamReader(System.in));
			int choice = 5;
			int amt = 0;
			int AccountNumber = 0;
			while(true) {
				try {
					System.out.println(PassCode == 1 ? "Welcome Mr. Owner" : "Welcome Mrs. Admin");
					System.out.println("1) View A Accounts");
					System.out.println(PassCode == 1 ? "2) Change A Account"  :  "No Option");
					System.out.println(PassCode == 1 ? "3) Delete A Account"  :  "No Option");
					System.out.println(PassCode == 1 ? "4) Deposit To Any Account" : "No Option");
					System.out.println(PassCode == 1 ? "5) Withdraw From Any Account" : "No Option");
					System.out.println("6) Go Back To Main Menu");
					choice = Integer.parseInt(BF.readLine());
					ArrayList<Human> ListOfCustomers = Customer.getCustomerAccounts();
					
					if(choice == 1) {
						System.out.println(PassCode == 1 ? 
								"I'll be viewing the accounts as the Owner"
								: "I'll be viewing your accounts as the admin");
//						Customer[] ArrayOfCustomers = Customer.getCustomers();
						MenuOptions.PrintOutCustomers(ListOfCustomers);
					} else if(choice == 2 & PassCode == 1) {
						System.out.println("What Account Number Do you want to change?");
						AccountNumber = Integer.parseInt(BF.readLine());
						System.out.println("Whats The New Balance For The Account?");
						amt = Integer.parseInt(BF.readLine());
						ChangeCustomerAmount(AccountNumber, amt);
					} 
					if(choice == 3 & PassCode == 1) {
						System.out.println("Which Account Would You Like To Delete?");
						AccountNumber = Integer.parseInt(BF.readLine());
//						Customer[] ArrayOfCustomers = Customer.getCustomers();
						MenuOptions.RemoveCustomer(AccountNumber, ListOfCustomers);
					} else if(choice == 4 & PassCode == 1) {
						System.out.println("How Much Would You Like To Deposit");
						amt = Integer.parseInt(BF.readLine());
						System.out.println("Which Account Would You Like To Add Too?\t");
						AccountNumber = Integer.parseInt(BF.readLine());
						MenuOptions.Deposit(amt, AccountNumber, ListOfCustomers);
					} else if (choice == 5 & PassCode == 1) {
						System.out.println("How Much Would You Like To Withdraw");
						amt = Integer.parseInt(BF.readLine());
						System.out.println("Which Account Would You Like To Withdraw From?\t");
						AccountNumber = Integer.parseInt(BF.readLine());
						MenuOptions.Withdraw(amt, AccountNumber, ListOfCustomers);
					}
					if(choice == 6) {
						System.out.println("\nLogOut & Back To Main Menu");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static int ChangeCustomerAmount(int AccountNumber, int balance) {
		int ReturnedBalance = 0;
//		for(int x = 0; x < Customer.getCustomerAccounts().size(); ++x) {
//		if(Customer.getCustomerAccounts().get(x) == AccountNumber) {
//			ReturnedBalance = Customer.setBalance(balance);
//			System.out.println("You have changed: "+Customer.getName()+" Account Balance to this: "
//					+ ReturnedBalance);
//		} else {
////			ReturnedBalance = DaCustomer.getBalance();
//			System.out.println("The system couldn' find that account number, No change has taken place");
//			}
//		}
		for(Human x : Customer.getCustomerAccounts()) {
			if(x.getAccount() == AccountNumber) {
				ReturnedBalance = x.setBalance(balance);
				System.out.println("You have changed: "+x.getName()+" Account Balance to this: "
						+ ReturnedBalance+"\n");
			} else {
//				ReturnedBalance = DaCustomer.getBalance();
				System.out.println("The system couldn' find that account number, \nNo change has taken place");
				}
			}
		return ReturnedBalance;
	}
	
	protected static boolean transferMoney(int senderAC, int receiverAC, int amount) throws SQLException {
		if(receiverAC == NULL || amount == NULL) {
			System.out.println("All Field Required!");
			return false;
		}
		try {
		con.setAutoCommit(false); //Sets this connection's auto-commit mode to the given state
		sql = "select * from Customer where AccountNumber="+senderAC;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			if(rs.getInt("balance") < amount) {
				System.out.println("You Have Insufficient Funds Compared To The Amount");
				return false;
			}
		}
		Statement st = con.createStatement();
		
//		debit .. take away from sender
		con.setSavepoint();
		sql = "update Customer set balance=balance-"+amount+" Where AccountNumber="+senderAC;
		if(st.executeUpdate(sql) == 1) {
			System.out.println(amount+" Debited");
		}
		
//		credit .. give to receiver
		sql = "update Customer set balance=balance+"+amount+"Where AccountNumber="+receiverAC;
		st.executeUpdate(sql);
		con.commit();
		return true;
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}
		return false;
	}
	
	protected static void getBalance(int AccountNumber) {
		try {
			sql = "select * from Customer where AccountNumber=" + AccountNumber;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(
					"----------------------------------------------------------"
					);
			System.out.printf("%12s %10s % 10s\n",
					"Account Number", "Name", "Balance");
//			Execution 
			while(rs.next()) {
//				Factoring the information
				System.out.printf("%12d %10s %10d.00\n", 
						rs.getInt("AccountNumber"),
						rs.getString("Cname"),
						rs.getInt("balance")
						);
			}
			System.out.println(
					"----------------------------------------------------------\n"
					);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
