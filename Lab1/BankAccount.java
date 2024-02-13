/* CS 282 Intermediate Java  Spring 2023
 * Cuyamaca College
 * Jaime  Sanchez
 * Lab 1 
 * 
 */

import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) 
	{
		
		Account acct = new Account();
		int choice=99;
		double amount; // placeholder for deposit/withdrawal amt
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Town Bank\n");

		while(choice != 6)
		{
			choice = menu();
			switch(choice) 
			{
				case 1: 
					acct.displayBalance();
					break;

				case 2:
					acct.displayRate();
					break;

				case 3:
					System.out.print("How much would you like to deposit? ");
					try {  // catch non-double type deposits
						amount = sc.nextDouble();
						if (!acct.deposit(amount)) {  // catch negative deposits
							amount = sc.nextDouble();
							acct.deposit(amount);
						}
						System.out.println(String.format("$%,.2f has been deposited in your account.\n", amount));  // success
					} catch (java.util.InputMismatchException e) {
						System.out.println("Please input a valid amount.\n");
						sc.next();
						choice=99;
					}
					break;

				case 4:  
					System.out.print("How much would you like to withdraw? ");
					try {  // catch non-double type withdrawals
						amount = sc.nextDouble();
						if (!acct.withdraw(amount)) {  // catch negative/greater than balance withdrawals
							amount = sc.nextDouble();
							acct.withdraw(amount);
						}
						System.out.println(String.format("$%,.2f has been withdrawn in your account.\n", amount));  // success
					} catch (java.util.InputMismatchException e) {
						System.out.println("!!Non Integer entered!!");
						sc.next();
						choice=99;
					}
					break;
				case 5:  
					System.out.print("How many months would you like to project your interest for? ");
					int months;
					try {
						months = sc.nextInt();
						acct.accrueInterest(months);
					} catch (java.util.InputMismatchException e) {
						System.out.println("!!Non Integer entered!!");
						sc.next();
						choice=99;
					}
					break;
				case 6: 
					System.out.println("!!Thank you and Good Bye!!\n");
					sc.close();
					break;
			}
		}
	}
	
	public static int menu()
	{
		int choice = 99;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number for the Operation you wish to perform:");
		System.out.println("1. Check Balance\n"+
						   "2. Check Current Rate\n"+
				           "3. Deposit to Account\n"+
						   "4. Withdraw from Account\n"+
				           "5. Project Interest Accrual\n"+
						   "6. Exit Program\n");
		
		System.out.println("Enter Choice: ");
		try 
		{
			choice = sc.nextInt();
			while(choice < 1 || choice >6)
			{
				System.out.println("Please enter a valid menu choice: ");
				
				choice = sc.nextInt();
			}
		}
		catch(java.util.InputMismatchException e)
		{
			System.out.println("!!Non Integer entered!!");
			sc.next();
			choice=99;
		}
		

		
		System.out.println(); //prints blank line
		return choice;
	}
}
