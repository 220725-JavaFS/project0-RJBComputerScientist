package com.revature.services;

import com.revature.daos.BankingDAO;
import com.revature.daos.BankingDAOImpl;

import banking.Customer;

public class BankingService {
	
	BankingDAO bankingdao = new BankingDAOImpl();
	
	public Customer getSingleCustomer(int id) {
		return bankingdao.getCustomerById(id);
	}
}
