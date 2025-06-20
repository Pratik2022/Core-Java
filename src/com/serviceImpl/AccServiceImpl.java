package com.serviceImpl;

import com.Aspects.ObjectProvider;
import com.bean.Account;
import com.dao.AccountDaoInterface;
import com.services.AccountServices;

public class AccServiceImpl implements AccountServices {

	//static int  series=100;
	private int accNo=0;
	private float accBal=0;
	private String accType;
	private Account a;
	AccountDaoInterface dao = ObjectProvider.createDaoObject();

	public synchronized void openAccount(String accType, float amount) 
	{
			int accNo = (int)(Math.random() * 101);
			a = new Account(accNo,accType,(int)amount);
			dao.insertRecord(a);
			assert(amount>=1000):"minimum amount for opening for account is min 1000rs";
			accBal = amount;
			System.out.println("Bank account open sucessfully");
		    System.out.println("Account No are: "+accNo);
		    System.out.println("Account Type are: "+accType);
		    System.out.println("Account Balance are : "+accBal);
			System.out.println(" ");	
	}

	public void balEnquiry(int accNo, String accType)
	{
		a = dao.retriveRecord(accNo);
		if((a.getAccNo()==accNo) && (a.getAccType().equals(a.getAccType())))
        {
			System.out.println("Account No are: "+a.getAccNo());
		    System.out.println("Account Type are: "+a.getAccType());
		    System.out.println("Account Balance are : "+a.getAccBal());	
			System.out.println(" ");
        }
		else
		{
			System.out.println("Invalid Account");
			System.out.println(" ");
		}
		
	}

	public void printAccountDetails(int accNo, String accType)
	{
		a = dao.retriveRecord(accNo);
		System.out.println("the Account No is: "+a.getAccNo());
		System.out.println("the Account Type is: "+a.getAccType());
		System.out.println("the Account Bal is: "+a.getAccBal());
		System.out.println(" ");
	}

	
	public void deposit(int accNo, float amount) {
		
		assert(amount>=1000):"minimum amount for Deposite and account is min 1000rs";
		Account a = dao.retriveRecord(accNo);
		if((a.getAccNo()==(accNo)))
		{
			synchronized(this)
			{
				if(a!=null)
				{
					float newBal = a.getAccBal() + amount;
					a.setAccBal(newBal);
					dao.updateRecord(a);
					System.out.println("Deposited sucessfully");
					System.out.println("the Account No is: "+accNo);
					System.out.println("the Account Bal is: "+newBal);
					System.out.println(" ");
				}
				
			}
		}
		else
		{
			System.out.println("invalid account No");
		}
	}

	@Override
	public void withdraw(int accNo, float amount) {
		assert(amount>=1000):"minimum amount for Deposite and account is min 1000rs";
		Account a = dao.retriveRecord(accNo);
		if((a.getAccNo()==(accNo)))
		{
			synchronized(this)
			{
				if(a!=null)
				{
					if(a.getAccBal()>=amount)
					{
						float newBal = a.getAccBal()-amount;
						a.setAccBal(newBal);
						dao.updateRecord(a);
						System.out.println("Amount withdraw sucessfully");
						System.out.println("the Account No is: "+accNo);
						System.out.println("the Account Bal is: "+newBal);
						System.out.println(" ");
					}
					else
					{
						System.out.println("Insufficient amount");
					}
				}
				
			}
		}
		else
		{
			System.out.println("invalid account No");
		}
		
	}
	
	public void closeAccount(int accNo)
	{
		a = dao.retriveRecord(accNo);
		if(a.getAccNo()==accNo)
		{
			dao.deletedRecord(accNo);
			System.out.println("collect your balance = "+a.getAccBal());
		}
	}

}
