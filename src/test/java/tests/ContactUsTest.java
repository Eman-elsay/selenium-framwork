package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage home;
	ContactUsPage contactuspage;
	String name= "eman";
	String email = "eman@rr.rr";
	String inquery= "eman";
	
	@Test
	public void usercontactus()
	{
		home= new HomePage(driver);
		home.opencontactuspage();
		contactuspage=new ContactUsPage(driver);
		contactuspage.contactus(name, email, inquery);
		Assert.assertTrue(contactuspage.successmessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}
