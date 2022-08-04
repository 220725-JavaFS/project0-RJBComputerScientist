// My Custom Packages
package com.revature;
import banking.Customer;
// My Custom Imports
import banking.bankManagement;
import banking.connection;
//  Other Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bank {
	static bankManagement load = new bankManagement();
//	^^^ for memory testing
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String name = "";
		int pass_code;
		int AccountNumber;
		int Choice;
		
//		TEST CODE
		load.init();
//		Customer MainCustomers = new Customer();
		
		while(true) {
			System.out.println("\n -->||		Welcome To Wanna Be Bank		||<--\n");
			System.out.println("1) Create Customer Account");
			System.out.println("2) Customer Login");
			System.out.println("3) Admin Login");
			System.out.println("4) Leave Bank");
			
			try {
				System.out.print("\n  Enter Input:\t");
				Choice = Integer.parseInt(sc.readLine());
				
				switch(Choice) {
				case 1:
					try {
						System.out.print("Enter Unique Username:\t");
						name = sc.readLine();
						System.out.println("Enter Your New Pass Code:\t");
						pass_code = Integer.parseInt(sc.readLine());
						
						if(bankManagement.customerCreateAccount(name, pass_code)) {
							System.out.println("MSG: Account Created Successfully!\n");
						} else {
							System.out.println("Account Creation Failed.. Boo Hoo");
						}
					} catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 2:
					try {
						System.out.print("  Enter  Username:  ");
						name = sc.readLine();
						System.out.print("  Enter  Password:  ");
						pass_code = Integer.parseInt(sc.readLine());
						
						if(bankManagement.customerLogin(name, pass_code)) {
							System.out.println("Login Sucessful!\n");
						} else {
							System.out.println("\nERR: login Failed!\n");
						}
					} catch(Exception e) {
						System.out.println("Login Failed!! Try Again");
					}
					break;
				case 3:
					try {
						System.out.print(" 	Enter	Admin Code\t");
						pass_code = Integer.parseInt(sc.readLine());
						
						if(bankManagement.adminLogin(pass_code)) {
							System.out.println("Admin Login Successful");
						} else {
							System.out.println("ERROR!! Login Flopped!\n");
						}
					} catch(Exception e) {
						System.out.println("Admin Login Flopped!! TRY AGAIN");
					}
					break;
				default: 
					System.out.println("Invalid Entry Of Operations");
					
				}
				if(Choice == 4) {
					System.out.println("Exited Successfully!\n\nRemember To Give Us More Money MOO HAAA HAAAAA");
					break;
				}
			} catch(Exception e) {
				System.out.println("Enter Valid Entry!!!!!");
			}
		}
		sc.close();
	}

}
