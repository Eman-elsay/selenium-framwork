package testsusinfDDT;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.Loadproperties;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisterusisgDDTandPropertiesFiles extends TestBase {

	public class UserRegerationTest extends TestBase  {
		HomePage homeobject;
		UserRegersteraionPage registerobject;
		LoginPage loginobject;
		MyAccountPage myaccountobject;
		String firstname= Loadproperties.userData.getProperty("firstname");
		String lastname= Loadproperties.userData.getProperty("lastname");
		String email= Loadproperties.userData.getProperty("email");
		String password = Loadproperties.userData.getProperty("password");
		@Test (priority=1 , alwaysRun = true)
		public void usercanregistersuccessfully()
		{
			homeobject= new HomePage(driver);
			homeobject.openregistrationpage();
			registerobject= new UserRegersteraionPage(driver);
			registerobject.userregisteration(firstname,lastname,email,password);
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
			loginobject.userlogin(email,password);
			Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
			
		}
		
		
		
		
	}}
