package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;

public class MyAccountTest extends TestBase {
	HomePage homeobject;
	UserRegersteraionPage registerobject;
	LoginPage loginobject;
	MyAccountPage myaccountobject;
	Faker fakerData = new Faker();
	
	String firstname = fakerData.name().firstName();
	    String lastname = fakerData.name().lastName();
	    String emailfake= fakerData.internet().emailAddress();
	    String password = fakerData.number().digits(8).toString();
	    String newpassword = fakerData.number().digits(8).toString();
	@Test (priority=1 )
	public void usercanregistersuccessfully()
	{
		homeobject= new HomePage(driver);
		homeobject.openregistrationpage();
		registerobject= new UserRegersteraionPage(driver);
		registerobject.userregisteration(firstname, lastname, emailfake, password);
		Assert.assertTrue(registerobject.suceessmessage.getText().contains("Your registration completed"));

}
	@Test (priority=2)
	public void registerdusercanchangepassword()
	{
		myaccountobject=new MyAccountPage(driver);
		myaccountobject.openmyaccount();
		myaccountobject.openchangepasswordpage();
		myaccountobject.changepassword(password, newpassword); 
		
		Assert.assertTrue(myaccountobject.sucesschangepassmessage.getText().contains("Password was changed"));

	
}
	@Test(priority=3  )
	
	public void registerdusercanlogout()
	{
		registerobject.userlogout();
	}
	
	@Test (priority=4  )
	public void registerusercanlogin()
	{
		homeobject.openloginpage();
		loginobject= new LoginPage(driver);
		loginobject.userlogin(emailfake, newpassword);
		Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
		
	}
	
}