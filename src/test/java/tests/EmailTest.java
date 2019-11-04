package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegersteraionPage;


public class EmailTest extends TestBase {
	
	
	//user registeration 
	HomePage homeobject;
	UserRegersteraionPage registerobject;
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	String productname = "Apple MacBook Pro 13-inch";
	String sucessmessage = "Your message has been sent.";
	EmailPage emailfriendobject;
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

		
		//user search using auto suggestion
		@Test (priority=2 )
		public void usercansearchusingautosugeestion() throws InterruptedException
		{
			searchobject=new SearchPage(driver);
			searchobject.productsearchusingsutosuggest("mac");
			detailsobject= new ProductDetailsPage(driver);
			 Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
		}
		
		@Test(priority = 3)
		public void registerduseremailproducttofriend() throws InterruptedException
		{emailfriendobject = new EmailPage(driver);
		detailsobject= new ProductDetailsPage(driver);
		detailsobject.emailtofriendbutton();
		emailfriendobject.sendemailtofriend("emankhalid1100@gmail.comt", "test");
		Thread.sleep(3000);
		 Assert.assertTrue(emailfriendobject.messagenotification.getText().contains(sucessmessage));
		}
			
	

}
