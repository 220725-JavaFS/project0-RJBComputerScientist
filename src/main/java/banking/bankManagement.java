package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class bankManagement {
	private static final int NULL = 0;
	
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
		
		Admins Admin1 = new Admins("Some Foo'");
		Owner ME = new Owner("ME");
	}
	static Customers[] SetOfCustomers;
	
	public static boolean createAccount(String name, int PassCode) {
		System.out.println("You Reached Me");
		try {
//			Validating if fields are filled
//			if(name == "" || PassCode == NULL) {
//				System.out.println("All Fields Required");
//				return false;
//			}
//			TEST CODE
			Customers NextCustomer = new Customers();
			SetOfCustomers.push(Customers())
			
//			With a method
			boolean Check = CheckingValidation(name, PassCode);
			if(Check) {
				System.out.println(" TRUE I'm In the check");
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
	public static boolean loginAccount(String name, int PassCode) {
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
