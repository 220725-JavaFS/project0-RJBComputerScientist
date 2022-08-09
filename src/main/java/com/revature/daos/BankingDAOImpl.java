package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.util.ConnectionUtils;

import banking.Customer;
import banking.Human;
// SQL (PostgreSQL) implementation
public class BankingDAOImpl implements BankingDAO{
	private static final int NULL = 0;
	String sql = "";
	@Override
	public Customer getCustomerById(int id) {
		try (Connection con = ConnectionUtils.getConnection()){
			String sql = "select * from customer where AccountNumber = "+id+";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				Customer customer = new Customer(
						rs.getInt("AccountNumber"),
						rs.getInt("balance"),
						rs.getString("Cname")
						);
				return customer;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		BankingDAO TestDao = new BankingDAOImpl();
		
		Customer a =  TestDao.getCustomerById(1);
		System.out.println(a);
		
		List<Customer> listA = TestDao.getAllCustomers();
		System.out.println(listA);
		
		Customer TestCustomer = new Customer(1, 3000, "Mang 2");
		TestCustomer.setPassCode(5555);
		Customer b = TestDao.insertCustomer(TestCustomer);
		System.out.println(b);
	}

	@Override
	public List<Customer> getAllCustomers() {
		try (Connection con = ConnectionUtils.getConnection()){
			String sql = "select * from customer";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Customer> customerList = new LinkedList<>();
			
			while(rs.next()) { // 'while' for multiple and 'if' for single
				Customer customers = new Customer(
						rs.getInt("AccountNumber"),
						rs.getInt("balance"),
						rs.getString("Cname")
						);
				customerList.add(customers);
			}
			return customerList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer insertCustomer(Customer customer) {
			try(Connection con = ConnectionUtils.getConnection()){
//				im ommiting the account NUmber since i have the serial variable
//				String sql = "INSERT INTO customer --->(AccountNumber)" <---
				String sql = "INSERT INTO customer (Cname, balance, pass_code)" +
			"		VALUES(?, ?, ?);";
				
				PreparedStatement st = con.prepareStatement(sql);

				int count = 0;
				st.setString(++count, customer.getName());
				st.setInt(++count, customer.getBalance());
				st.setInt(++count, customer.getPassCode());
				st.execute();
				return customer;
//				^^getting a account number of 1 when inserting. 
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public boolean transferMoney(int senderAC, int receiverAC, int amount) {
//		if(receiverAC == NULL || amount == NULL) {
//			System.out.println("All Field Required!");
//			return false;
//		}

		try(Connection con = ConnectionUtils.getConnection()) {
		con.setAutoCommit(false); //Sets this connection's auto-commit mode to the given state
//		String sql ="";
		sql = "select * from Customer where AccountNumber="+senderAC;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Customer customer = new Customer(
					rs.getInt("AccountNumber"),
					rs.getInt("balance"),
					rs.getString("Cname")
					);
			if(rs.getInt("balance") < amount) {
				System.out.println(customer.getName()+" You Have Insufficient Funds Compared To The Amount");
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
		} catch(SQLException e) {
			e.printStackTrace();
//			con.rollback();
		}
		return false;
	}
	
	public void getCustomerBalance(int ID) {
		try(Connection con = ConnectionUtils.getConnection()) {
		sql = "select * from customer where AccountNumber=" + ID;
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery(sql);
		System.out.println(
				"----------------------------------------------------------"
				);
		System.out.printf("%12s %10s % 10s\n",
				"Account Number", "Name", "Balance");
//		Execution 
		while(rs.next()) {
//			Factoring the information
			System.out.printf("%12d %10s %10d.00\n", 
					rs.getInt("AccountNumber"),
					rs.getString("Cname"),
					rs.getInt("balance")
					);
		}
		System.out.println(
				"----------------------------------------------------------\n"
				);
	} catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	@Override
	public void Deposit(int ID, int balance) {
		try(Connection con = ConnectionUtils.getConnection()) {
			sql = "select * from customer where AccountNumber=" + ID;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int Database_Balance = rs.getInt("balance");
				Customer customer = new Customer(
						rs.getInt("AccountNumber"),
						Database_Balance,
						rs.getString("Cname")
						);
			
				System.out.println("Here's Your New Money "+customer.getName());
			}
			Statement st = con.createStatement();
			sql = "UPDATE customer set balance=balance+"+balance+"where AccountNumber="+ID;
			if(st.executeUpdate(sql) == 1) {
				System.out.println(balance+" Has Been Added");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void Withdraw(int ID, int balance) {
		// TODO Auto-generated method stub

		try(Connection con = ConnectionUtils.getConnection()) {
			sql = "select * from customer where AccountNumber=" + ID;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int Database_Balance = rs.getInt("balance");
				Customer customer = new Customer(
						rs.getInt("AccountNumber"),
						Database_Balance,
						rs.getString("Cname")
						);
				if(Database_Balance < balance) {
				System.out.println(customer.getName()+" Your Balance Of "+customer.getBalance()+"\n Is Too Low "
						+ "For The Request");
			}
				System.out.println("Here's Your New Money "+customer.getName());
			}
			Statement st = con.createStatement();
			sql = "UPDATE customer set balance=balance-"+balance+"where AccountNumber="+ID;
			if(st.executeUpdate(sql) == 1) {
				System.out.println(balance+" Has Been Subtracted");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer deleteCustomer(int ID) {
		try(Connection con = ConnectionUtils.getConnection()) {
			sql = "delete from customer where AccountNumber="+ID+";";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Customer customer = new Customer();
			if(rs.next()) {
				int Database_Balance = rs.getInt("balance");
				customer.setAccount(rs.getInt("AccountNumber"));
				customer.setBalance(Database_Balance);
				customer.setName(rs.getString("Cname"));
				System.out.println(customer.getName()+" Was Deleted");
				return customer;
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*
 * PRIVATE METHODS
 */
	private static boolean CheckingValidation(String name, int PassCode) {
		if(name == "" || PassCode == NULL) {
			System.out.println("All Fields Required");
			return false;
		} else {
			return true;
		}
	}



}
