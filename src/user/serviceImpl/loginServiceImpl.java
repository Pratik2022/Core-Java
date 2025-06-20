package user.serviceImpl;

import java.sql.Connection;

import com.Aspects.DbConnectionProvider;

import user.Aspect.UserDBConnectionProvider;
import user.Aspect.objectProvider;
import user.DaoServices.DaoInterface;
import user.Exception.poorPasswordException;
import user.Exception.poorRegisterException;
import user.bean.User;
import user.services.loginServices;

public class loginServiceImpl implements loginServices {
	
	User user;
	DaoInterface dao = objectProvider.ProvideDaoObject();
	

	public synchronized void signUp(String username, String password, String Sqn, String Sqa) throws poorRegisterException
	{
	  if((username.length()>=8)&&(password.length()>=8))
      {
    	  user = new User(username,password,Sqn,Sqa);
    	  dao.insertRecord(user);
    	  System.out.println("Registered  successfully");
      }
      else
      {
    	  throw new poorRegisterException("create username and password atleast at 8 in length");
      }
	}
	
	

	public void  signIn(String username, String password) throws poorPasswordException
	{
		if((username.length()>=8) && (password.length()>=8))
		{
		boolean outcome = false;
		user = dao.retrieveRecord(username, password);
		  if((user.getUserName().equals(username))&&(user.getPassWord().equals(password)))
		  {
			System.out.println("SignIn Successfully");
		  }
		  else
		  {
			System.out.println("SignIn Failed");
		  }
		}
		else
		{
			throw new poorPasswordException("username and password length must br greater or equal to 8");
		}
	}
	
	

	public void forgetPassword(String username, String Sqn, String Sqa)
	{
        user = dao.retrieveRecord(username, Sqn, Sqa);
		if((user.getUserName().equals(username))&&(user.getSqn().equals(Sqn))&&(user.getSqa().equals(Sqa)))
		{
			System.out.println("The Forgotted password of username "+username+ " is = "+user.getPassWord())	;		
		}
		else
		{
			System.out.println("invalid username or security question & answer");
		}	
	}
	
	

	public synchronized void updatePassword(String username, String password, String newPassWord)
	{
		user = dao.retrieveRecord(username, password);
		if(user!=null && user.getUserName().equals(username) && user.getPassWord().equals(password))
		{
			dao.updateRecord(newPassWord,username);
			System.out.println("Password updated successfully");
		}
		else
		{
			System.out.println("password changed failed");
		}
	}



	public void deleteId(String username, String password)
	{
		user = dao.retrieveRecord(username, password);
		if(user!=null && user.getUserName().equals(username) && user.getPassWord().equals(password))
		{
			dao.deleteRecord(username, password);
			System.out.println("Identity Deleted successfully");
		}
		else
		{
			System.out.println("Identity Deletion failed");
		}		
	}
}
