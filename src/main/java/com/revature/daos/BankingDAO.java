package com.revature.daos;

import java.util.List;

import banking.Customer;
import banking.Human;

//  by default all methods are abstract in an interface 
public interface BankingDAO {
	
	public Customer getCustomerById(int id);
	
	List<Customer> getAllCustomers();
	
	public abstract Customer insertCustomer(Customer customer);
	
}
