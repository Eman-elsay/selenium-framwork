package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;

public class UserRegerationTest extends TestBase  {
	HomePage homeobject;
	UserRegersteraionPage registerobject;
	LoginPage loginobject;
	MyAccountPage myaccountobject;
	@Test (priority=1 , alwaysRun = true)
	public void usercanregistersuccessfully()
	{
		homeobject= new HomePage(driver);
		homeobject.openregistrationpage();
		registerobject= new UserRegersteraionPage(driver);
		registerobject.userregisteration("eman", "khalid", "rra8s@rr.com", "12345678");
		Assert.assertTrue(registerobject.suceessmessage.getText().contains("Your registration completed"));

	}
	@Test(dependsOnMethods ="usercanregistersuccessfully" )
	
	public void registerdusercanlogout()
	{
		registerobject.userlogout();
		
		
	}
	
	@Test ( dependsOnMethods = "registerdusercanlogout")
	public void registerusercanlogin()
	{
		homeobject.openloginpage();
		loginobject= new LoginPage(driver);
		loginobject.userlogin("rra8s@rr.com", "12345678");
		Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
		
	}
	
	
	
	
	
}
