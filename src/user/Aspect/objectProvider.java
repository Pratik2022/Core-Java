package user.Aspect;

import java.io.FileInputStream;
import java.util.Properties;

import user.DaoServices.DaoInterface;
import user.serviceImpl.loginServiceImpl;
import user.services.loginServices;

public class objectProvider
{
	
	public static loginServices ProvideBusinessObjects()
	{
		FileInputStream fis = null;
		loginServices ls = null;
		try
		{
			fis = new FileInputStream(".//Resources//component.properties");
			Properties p  = new Properties();
			p.load(fis);
			String Bclassname = p.getProperty("UserBusinessComponent");
			ls = (loginServices) Class.forName(Bclassname).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}
	
	public static DaoInterface ProvideDaoObject()
	{
		DaoInterface DI = null;
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(".//Resources//component.properties");
			Properties p  = new Properties();
			p.load(fis);
			String Bclassname = p.getProperty("userDAOClass");
			DI = (DaoInterface) Class.forName(Bclassname).newInstance();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return DI;
	}
	    

}
