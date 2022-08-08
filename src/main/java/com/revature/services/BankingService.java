package com.revature.services;

import com.revature.daos.BankingDAO;
import com.revature.daos.BankingDAOImpl;

import banking.Customer;

// A TYPE OF PASS THROUGH LAYER 
public class BankingService {
	BankingDAO bankingdao = new BankingDAOImpl();
// ^^ This idea is called covariance, its about of polymorphism 	
	
	public Customer getSingleCustomer(int id) {
		return bankingdao.getCustomerById(id);
	}
}
