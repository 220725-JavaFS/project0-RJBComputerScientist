package com.revature.daos;

import java.util.List;

import banking.Customer;
import banking.Human;

//  by default all methods are abtract in an interface 
public interface BankingDAO {
	
	public Customer getCustomerById(int id);
	
	List<Customer> getAllCustomers();
	
	
}
