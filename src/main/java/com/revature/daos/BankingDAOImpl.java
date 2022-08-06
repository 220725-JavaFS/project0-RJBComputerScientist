package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.util.ConnectionUtils;

import banking.Customer;
import banking.Human;

public class BankingDAOImpl implements BankingDAO{

	@Override
	public Customer getCustomerById(int id) {
		try (Connection con = ConnectionUtils.getConnection()){
			String sql = "select * from customers where AccountNumber = "+id+";";
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
		
		Customer a =  TestDao.getCustomerById(2);
		System.out.println(a);
		
		List<Customer> listA = TestDao.getAllCustomers();
		System.out.println(listA);
	}

	@Override
	public List<Customer> getAllCustomers() {
		try (Connection con = ConnectionUtils.getConnection()){
			String sql = "select * from customers";
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
				return customerList;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
