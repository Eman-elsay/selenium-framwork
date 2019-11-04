package testsusinfDDT;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisterationWithCSVFile extends TestBase {


	HomePage homeobject;
	UserRegersteraionPage registerobject;
	LoginPage loginobject;
	CSVReader reader;
	@Test (priority=1 , alwaysRun = true )
	public void usercanregistersuccessfully() throws IOException		{
		//get path of csv file 
		String csvfile = System.getProperty("user.dir")+"/src/test/java/data/userdata.CSV";
		reader= new CSVReader(new FileReader(csvfile));

		String[] csvcell;
		//while loop in csv value 

		while( (csvcell=reader.readNext()) !=  null)
		{
			String fname =csvcell[0];
			String lname =csvcell[1];
			String email1 =csvcell[2];
			String password1 =csvcell[3];
			homeobject= new HomePage(driver);
			homeobject.openregistrationpage();
			registerobject= new UserRegersteraionPage(driver);
			registerobject.userregisteration(fname,lname,email1,password1);
			Assert.assertTrue(registerobject.suceessmessage.getText().contains("Your registration completed"));
			registerobject.userlogout();
			homeobject.openloginpage();
			loginobject= new LoginPage(driver);
			loginobject.userlogin(email1, password1);
			Assert.assertTrue(registerobject.logoutlink.getText().contains("Log out"));
			homeobject.openloginpage();
		}}
}









