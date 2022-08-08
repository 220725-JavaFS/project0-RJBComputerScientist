package com.revature.controllers;
// The final .java file for the project
public class Driver {
	public static void main(String[] args) {
		System.out.println("Possible final main method here");
		
		BankingMenuController bank = new BankingMenuController();
		
		bank.AdminMenu();
		
		System.out.println("Testing this could be final");
	}
}
