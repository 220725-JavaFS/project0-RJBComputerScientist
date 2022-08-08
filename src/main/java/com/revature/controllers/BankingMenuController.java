package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.BankingService;

import banking.Customer;
// to display the information
public class BankingMenuController {
	private BankingService bankingService = new BankingService();
	private Scanner scan = new Scanner(System.in);
	
	public void AdminMenu() {
		String choice = "";
		menuLoop: while(!choice.equals("0")) {
		System.out.println("How Would You Proceed At Customer View?"
				+ "\n 0. Exit"
				+ "\n 1. View Account"
				+ "\n 2. Deposit Account"
				+ "\n 3. Withdraw Account"
				+ "\n 4. Transfer Account"
				+ "\n 5. Delete Account"
				);
		
		choice = scan.nextLine();
		switchChoice: switch(choice) {
		case "0":
			break switchChoice;
			case "1":
				System.out.println("You Picked View Account");
				seeCustomers();
				break switchChoice;
			case "2":
				System.out.println("You Picked Deposit Account");
				break switchChoice;
			case "3":
				System.out.println("You Picked Withdraw Account");
				break switchChoice;
			case "4":
				System.out.println("You Picked Transfer Account");
				break switchChoice;
			case "5":
				System.out.println("You Picked Delete Account");
				break switchChoice;
		}
		}
	}

	public void seeCustomers() {
		String Answer = "";
		while(!Answer.equalsIgnoreCase("exit")) {
		System.out.println("Which Customer Would You Like To See? Give A AccountNumber\n "
				+ "Or Type 'All' Type 'EXIT' To exit");
		Answer =  scan.nextLine();
		
		if(Answer.equalsIgnoreCase("all")) {
//			Get All Customers
		} else if(Answer.equalsIgnoreCase("exit")){
			return;
		} else {
			int id = 0;
			try {
				id = Integer.parseInt(Answer);
			} catch (NumberFormatException e) {
				System.out.println("That Is Not A Valid Id, TRY AGAIN!");
				continue;
			}
			Customer customer = bankingService.getSingleCustomer(id);
			
			System.out.println("Here Is Your Customer: \n"+customer);
		}
		}
	}
	
}
