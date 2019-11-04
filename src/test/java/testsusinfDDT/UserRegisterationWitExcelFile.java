package testsusinfDDT;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisterationWitExcelFile  extends TestBase{
	
	@DataProvider(name="exceldata")
	public static Object[][] userregisterdata() throws IOException
	{
		//get data from excel file 
		ExcelReader ER= new ExcelReader();
		
			return ER.getExcelData();
		
		
		}
		
	
	
	  
		HomePage homeobject;
		UserRegersteraionPage registerobject;
		LoginPage loginobject;
		MyAccountPage myaccountobject;
		@Test (priority=1 , alwaysRun = true , dataProvider = "exceldata")
		public void usercanregistersuccessfully(String firstname, String lastname,String email ,String password)		{
			homeobject= new HomePage(driver);
			homeobject.openregistrationpage();
			registerobject= new UserRegersteraionPage(driver);
			registerobject.userregisteration(firstname,lastname,email,password);
			Assert.assertTrue(registerobject.suceessmessage.getText().contains("Your registration completed"));
			registerobject.userlogout();
			homeobject.openloginpage();
			loginobject= new LoginPage(driver);
			loginobject.userlogin(email, password);
			Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
		}
	}






