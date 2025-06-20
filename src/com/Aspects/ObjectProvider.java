package com.Aspects;

import java.io.FileInputStream;
import java.util.Properties;

import com.dao.AccountDaoInterface;
import com.serviceImpl.AccServiceImpl;
import com.services.AccountServices;

public class ObjectProvider {

	public static AccountServices provideBusinessObjects()
	{
		FileInputStream fis = null;
		AccountServices acc =null;
		
		try
		{
			fis = new FileInputStream(".//Resources//component.properties");
			Properties p = new Properties();
			p.load(fis);
			String BClassName = p.getProperty("BusinessComponent");
			
			acc = (AccountServices) Class.forName(BClassName).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  return acc;
	}
	
	public static AccountDaoInterface createDaoObject()
	{
		AccountDaoInterface a = null;
		FileInputStream fis = null;
		AccountServices acc=null;
		try
		{
			fis = new FileInputStream(".//Resources//component.properties");
			Properties p = new Properties();
			p.load(fis);
			String DAO = p.getProperty("DAOClass");
			
			a = (AccountDaoInterface) Class.forName(DAO).newInstance();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}

}
