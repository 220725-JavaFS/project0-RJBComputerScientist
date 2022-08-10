package com.revature.services;

import java.util.List;

import com.revature.daos.BankingDAO;
import com.revature.daos.BankingDAOImpl;

import banking.Admin;
import banking.Customer;

// A TYPE OF PASS THROUGH LAYER 
public class BankingService {
	private BankingDAO bankingdao = new BankingDAOImpl();
// ^^ This idea is called covariance, its about of polymorphism 	
	
	public Customer getSingleCustomer(int id) {
		return bankingdao.getCustomerById(id);
	}
	
	public void AddCustomer(Customer customer) {
		 bankingdao.insertCustomer(customer);
	}
	
	public void TransferMonies(int Sender, int Receiver, int amount) {
		bankingdao.transferMoney(Sender, Receiver, amount);
	}
	
	public void getCustomerBalance(int ID) {
		System.out.println("Here Is Your Balance "+bankingdao.getCustomerBalance(ID));
//		bankingdao.getCustomerBalance(ID);
	}
	
	public void customerDeposit(int ID, int balance) {
		bankingdao.Deposit(ID, balance);
	}
	
	public void customerWithdraw(int ID, int balance) {
		bankingdao.Withdraw(ID, balance);
	}
	
	public void RemoveCustomer(int ID) {
		bankingdao.deleteCustomer(ID);
	}
	
	public List<Customer> AllCustomers(){
		return bankingdao.getAllCustomers();
	}
	
	public Admin AdminLogin(Admin admin) {
		return bankingdao.AdminLogin(admin);
	}
}
