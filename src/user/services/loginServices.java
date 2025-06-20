package user.services;

import user.Exception.poorPasswordException;
import user.Exception.poorRegisterException;

public interface loginServices {
	
	public void signUp(String username,String password,String Sqn,String Sqa)throws poorRegisterException;
	public void signIn(String username,String password) throws poorPasswordException;
	public void forgetPassword(String username,String Sqn,String Sqa);
    public void updatePassword(String username,String password,String newpassword);
    public void deleteId(String username,String password);
}
