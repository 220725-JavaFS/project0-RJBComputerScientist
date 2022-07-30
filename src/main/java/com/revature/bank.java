// My Custom Packages
package com.revature;
// My Custom Imports
import banking.bankManagement;
import banking.connection;
//  Other Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bank {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String name = "";
		int pass_code;
		int AccountNumber;
		int Choice;
		
		while(true) {
			System.out.println("\n -->||		Welcome To Wanna Be Bank		||<--\n");
			System.out.println("1) Create Account");
			System.out.println("2) Login Account");
			
			try {
				System.out.print("\n 		Enter Input:");
				Choice = Integer.parseInt(sc.readLine());
				
				switch(Choice) {
				case 1:
					try {
						System.out.print("Enter Unique Username:");
						name = sc.readLine();
						System.out.println("Enter Your New Password");
						pass_code = Integer.parseInt(sc.readLine());
						
						if(bankManagement.createAccount(name, pass_code)) {
							System.out.println("MSG: Account Created Successfully!\n");
						} else {
							System.out.println("Account Creation Failed.. Boo Hoo");
						}
					} catch(Exception e) {
						System.out.println("ERR: ERROR!!!! with process\nEnter Valid Data");
					}
					break;
				case 2:
					try {
						System.out.print("  Enter 	Username  ");
						name = sc.readLine();
						System.out.print("  Enter 	Username  ");
						pass_code = Integer.parseInt(sc.readLine());
						
						if(bankManagement.loginAccount(name, pass_code)) {
							System.out.println("Login Sucessful!\n");
						} else {
							System.out.println("ERR: login Failed!\n");
						}
					} catch(Exception e) {
						System.out.println("Login Failed!! Try Again");
					}
					break;
					
				default: 
					System.out.println("Invalid Entry Of Operations");
					
				if(Choice == 5) {
					System.out.println("Exited Successfully!\n\n	Remember To Give Us More Money MOO HAAA HAAAAA");
					break;
					}
				}
			} catch(Exception e) {
				System.out.println("Enter Valid Entry!!!!!");
			}
			sc.close();
		}
	}

}
