package com.revature.daos;

import java.util.List;

import banking.Customer;
import banking.Human;

//  by default all methods are abstract in an interface 
public interface BankingDAO {
	
	public Customer getCustomerById(int id);
	
	List<Customer> getAllCustomers();
	
	public abstract Customer insertCustomer(Customer customer);
	
	boolean transferMoney(int senderAC, int receiverAC, int amount);
	
	void getCustomerBalance(int ID);
	
	void Deposit(int ID, int balance);
	
	void Withdraw(int ID, int balance);
	
	Customer deleteCustomer(int id);
	
}
