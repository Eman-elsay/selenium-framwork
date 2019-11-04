package testsusinfDDT;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisterusisgDDT extends TestBase {

	@DataProvider(name="testdata")
	public static Object[][] userdata()
	{
		return new Object[][] {
			{"eman","khalid","eman255882@3214.com","12345678"},
			{"ayman","ibrahim","ayman2552@gmail.com","12345678"}
		};
		
	}
	
	  
		HomePage homeobject;
		UserRegersteraionPage registerobject;
		LoginPage loginobject;
		MyAccountPage myaccountobject;
		@Test (priority=1 , alwaysRun = true , dataProvider = "testdata")
		public void usercanregistersuccessfully(String Fname, String lname,String email ,String password)		{
			homeobject= new HomePage(driver);
			homeobject.openregistrationpage();
			registerobject= new UserRegersteraionPage(driver);
			registerobject.userregisteration(Fname,lname,email,password);
			Assert.assertTrue(registerobject.suceessmessage.getText().contains("Your registration completed"));
			registerobject.userlogout();
			homeobject.openloginpage();
			loginobject= new LoginPage(driver);
			loginobject.userlogin(email, password);
			Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
		}
	}


