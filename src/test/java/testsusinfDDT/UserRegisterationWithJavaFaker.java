package testsusinfDDT;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisterationWithJavaFaker  extends TestBase{

	HomePage homeobject;
	UserRegersteraionPage registerobject;
	LoginPage loginobject;
	Faker fakedata= new Faker();
	String firstname= fakedata.name().firstName();
	String lastname =fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password = fakedata.number().digits(8).toString();
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
		loginobject.userlogin(email, password);
		Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));

	}

}
