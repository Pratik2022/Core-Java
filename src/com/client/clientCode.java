package com.client;

import java.util.Scanner;

import com.Aspects.ObjectProvider;
import com.serviceImpl.AccServiceImpl;
import com.services.AccountServices;

public class clientCode {

	public static void main(String[] args) 
	{
		AccountServices service = ObjectProvider.provideBusinessObjects();	
		Scanner sc = new Scanner(System.in);
		int choice;
		int accNo;
		String accType;
		float accBal,amount;
		
		do
		{
			System.out.println("1.Open account");
			System.out.println("2.Deposit Money");
			System.out.println("3.withdraw Money");
			System.out.println("4.Balance Enquiry");
			System.out.println("5.Close the account");
			System.out.println("6.Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println();
				System.out.println("Enter the type of account");
				accType = sc.next();
				System.out.println("Enter the opening amount");
				amount = sc.nextFloat();
				service.openAccount(accType, amount);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("Enter the accNo");
				accNo = sc.nextInt();
				System.out.println("Enter the amount");
				amount = sc.nextFloat();
				service.deposit(accNo, amount);
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Enter the accNo");
				accNo = sc.nextInt();
				System.out.println("Enter the amount");
				amount = sc.nextFloat();
				service.withdraw(accNo, amount);
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("Enter the accNo");
				accNo = sc.nextInt();
				System.out.println("Enter the Type of account");
				accType = sc.next();
				service.balEnquiry(accNo, accType);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("Enter the accNo");
				accNo = sc.nextInt();
				service.closeAccount(accNo);
				System.out.println();
				break;
			default:
				System.out.println();
				System.out.println("Invalid choice!!");
				System.out.println("Enter the valid choice");
				System.out.println();
				break;
			}
		}while(choice!=5);	
	}
}
			



