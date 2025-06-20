package user.client;

import java.util.Scanner;

import user.Aspect.objectProvider;
import user.Exception.poorPasswordException;
import user.Exception.poorRegisterException;
import user.services.loginServices;

public class clientCode {

	public static void main(String[] args) throws poorRegisterException, poorPasswordException
	{
        try
        {
        loginServices service = objectProvider.ProvideBusinessObjects();
        int choice;
        String username = null;
        String password = null;
        String sqn = null;
        String sqa = null;
        String newPassword = null;
        Scanner sc = new Scanner(System.in);
        
        do
        {
        	System.out.println("===============Login Validation Project===============");
        	System.out.println("1.SignUp");
        	System.out.println("2.SignIn");
        	System.out.println("3.forgot password");
        	System.out.println("4.Reset password");
        	System.out.println("5.Delete Id");
        	System.out.println("6.Exit");
        	System.out.print("Enter your choice: ");
        	choice = sc.nextInt();
        	
        	switch(choice)
        	{
        	case 1:
        		System.out.println();
        		System.out.println("Enter your username:");
        		username = sc.next();
        		System.out.println("Enter your password:");
        		password = sc.next();
        		System.out.println("Enter your security question:");
        		sqn = sc.next();
        		System.out.println("Enter your security answer:");
        		sqa = sc.next();
        		service.signUp(username, password, sqn, sqa);
        		System.out.println();
        		break;
        	case 2:
        		System.out.println();
        		System.out.println("Enter your username:");
        		username = sc.next();
        		System.out.println("Enter your password:");
        		password = sc.next();
        		service.signIn(username, password);
        		System.out.println();
        		break;
        	case 3:
        		System.out.println();
        		System.out.println("Enter your username:");
        		username = sc.next();
        		System.out.println("Enter your security question:");
        		sqn = sc.next();
        		System.out.println("Enter your security answer:");
        		sqa = sc.next();
        		service.forgetPassword(username, sqn, sqa);
        		System.out.println();
        		break;
        	case 4:
        		System.out.println();
        		System.out.println("Enter your username:");
        		username = sc.next();
        		System.out.println("Enter your password:");
        		password = sc.next();
        		System.out.println("Enter your new password:");
        		newPassword = sc.next();
        		service.updatePassword(username, password, newPassword);
        		System.out.println();
        		break;
        	case 5:
        		System.out.println();
        		System.out.println("Enter your username:");
        		username = sc.next();
        		System.out.println("Enter your password:");
        		password = sc.next();
        		service.deleteId(username, password);
        		System.out.println();
        		break;
        	case 6:
        		System.out.println("THANK YOU VISIT AGAIN");
        		break;
        	default:
        		System.out.println("Invalid choice");
        		System.out.println();
        		break;
        	}
          }while(choice!=6);
	    }
        catch(Exception e)
        {
			e.printStackTrace();
        }
	}
}
		
