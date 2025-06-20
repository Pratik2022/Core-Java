package com.services;

public interface AccountServices {
	
	public void openAccount(String accType, float amount);
	public void deposit(int accNo,float amount);
	public void withdraw(int accNo,float amount);
	public void balEnquiry(int accNo, String accType);
	public void printAccountDetails(int accNo,String accType);
	public void closeAccount(int accNo);

}