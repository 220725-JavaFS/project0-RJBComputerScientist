package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.services.BankingService;

import banking.Customer;
import banking.bankManagement;
// to display the information
public class BankingMenuController {
	private BankingService bankingService = new BankingService();
	private Scanner scan = new Scanner(System.in);
	
	/*
	 * 1. ADD WELCOME MENU HERE (DONE)
	 * 2. ADD MENUS INSIDE OF WELCOME SCREEN (DONE)
	 * 3. ADD "AddCustomer" INSIDE OF CUSTOMER MENU (DONE)
	 */
	
//	WELCOME MENU
	public void WelcomeMenu() {
		String Choice = "";

		
		menuLoop: while(true) {
//			^^^ going back here ends the loop
			System.out.println("\n -->||		Welcome To Wanna Be Bank		||<--\n");
			System.out.println("0) Leave Bank");
			System.out.println("1) Customer Menu");
			System.out.println("2) Admin Menu");
			
			try {
				System.out.print("\n  What Menu Are You Using?:\t");
				Choice = scan.nextLine();
				
	switchChoice: switch(Choice) {
				case "0":
					System.out.println("Thanks For Coming!\n");
					break menuLoop;
				case "1":
					CustomerMenu();
					break switchChoice;
				case "2":
					AdminMenu();
					break switchChoice;
				default: 
					System.out.println("That Aint A Choice");
				}
			} catch(Exception e) {
				System.out.println("Dont Break The Bank!!!!!");
			}
		}
	}

//	TESTING METHOD
	private Admin Login(Admin admin) {
		return bankingService.adminLogin(admin);
	}
	
	private void AdminMenu() {
		String choice = "";
//		ADMIN LOGIN HERE
//		1. admin
//		2. method(admin)
//		3. admin.Name
		menuLoop: while(!choice.equals("0")) {
//			^^ doubling logic
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
			break menuLoop;
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

//	ADMINS METHODS/FUNCTIONS START
	private void seeCustomers() {
		String Answer = "";
		while(!Answer.equalsIgnoreCase("exit")) {
		System.out.println("Which Customer Would You Like To See? Give A AccountNumber\n "
				+ "Or Type 'All' Type 'EXIT' To exit");
		Answer =  scan.nextLine();
		
		if(Answer.equalsIgnoreCase("all")) {
//			Get All Customers
			List<Customer> ListOfCustomers = bankingService.AllCustomers();
			System.out.println("Here Are All Of The Customers: \n"+ListOfCustomers);
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
	
//	ADMINS METHODS/FUNCTIONS END
	private void CustomerMenu() {
//		System.out.println("Customer Menu");
//		System.out.println("Whats Your Login Information?");
//		String Username = "";
//		int PassCode = 0;
		String Choice = "";
//		System.out.println("Do you have an login?");
//		Choice = scan.nextLine();
//		System.out.println("Username: ");
//		Username = scan.nextLine();
//		System.out.println("Pass Code: ");
//		PassCode = scan.nextInt();
//		System.out.print(Choice+Username+PassCode);
//		^^^^ login
//		Customer LoggedCustomer = new Customer()
		menuLoop: while(true) {
			System.out.println("Hey, How Would You Like To Proceed At Customer View?"
					+ "\n 0. Exit"
					+ "\n 1. View Account"
					+ "\n 2. Deposit Account"
					+ "\n 3. Withdraw Account"
					+ "\n 4. Transfer Account"
					+ "\n 5. Delete Account"
					);
			Choice = scan.nextLine();
			switchChoice: switch (Choice) {
			case "0":
				System.out.println("Back To Welcome Menu");
				break menuLoop;
				case "1":
					System.out.println("You Picked View Account");
					getCustomerBalance();
					break switchChoice;
				case "2":
					System.out.println("You Picked Deposit Account");
					AddMonies();
					break switchChoice;
				case "3":
					System.out.println("You Picked Withdraw Account");
					SubtractMonies();
					break switchChoice;
				case "4":
					System.out.println("You Picked Transfer Account");
					MoneyTransfer();
					break switchChoice;
				case "5":
					System.out.println("You Picked Delete Account");
					DeleteCustomer();
					break switchChoice;
			}
		}
		
	}
//	CUSTOMER METHODS/FUNCTIONS START
	private void CreateCustomer() {
		Customer customer = new Customer();
		System.out.println("Whats Your name?");
		customer.setName(scan.nextLine());
		System.out.println("How Many Monies Do You?");
		customer.setBalance(Integer.parseInt(scan.nextLine()));
		System.out.println("Whats Your Pass Code? (WRITE IT DOWN!!)");
		customer.setPassCode(Integer.parseInt(scan.nextLine()));
		bankingService.AddCustomer(customer);
//		WORKS GREAT SO FAR 8/8/2022
	}
	
	private void MoneyTransfer() {
		int Sender, Receiver, Amount;
		System.out.println("Whats Your Account Number?");
		Sender = Integer.parseInt(scan.nextLine());
		System.out.println("Whats The Account Number Of The Receiver?");
		Receiver = Integer.parseInt(scan.nextLine());
		System.out.println("How Many Monies WIll Be Sent??");
		Amount = Integer.parseInt(scan.nextLine());
		bankingService.TransferMonies(Sender, Receiver, Amount);
	}
//	
	private void getCustomerBalance() {
		int ID;
		System.out.println("Whats Your Account ID?");
		ID = Integer.parseInt(scan.nextLine());
		bankingService.getCustomerBalance(ID);
	}
	
	private void AddMonies() {
		int ID, balance;
		System.out.println("Whats Your Account ID");
		ID = Integer.parseInt(scan.nextLine());
		System.out.println("Whats The Amount You Want To Add?");
		balance = Integer.parseInt(scan.nextLine());
		bankingService.customerDeposit(ID, balance);
	}
	
	private void SubtractMonies() {
//		I would include a verification method for this method
		int ID, balance;
		System.out.println("Whats Your Account ID");
		ID = Integer.parseInt(scan.nextLine());
		System.out.println("Whats The Amount You Want To Subtract?");
		balance = Integer.parseInt(scan.nextLine());
		bankingService.customerWithdraw(ID, balance);
	}
	
	private void DeleteCustomer() {
//		I would include a verification method for this method
		int ID;
		System.out.println("Which Account ID Would You Want To Delete?");
		ID = Integer.parseInt(scan.nextLine());
		bankingService.RemoveCustomer(ID);
	}
	
//	CUSTOMER METHODS/FUNCTIONS END
}
