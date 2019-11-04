package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AddToCardPage;
import pages.CheckOutPage;
import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegersteraionPage;

public class RegisterdUserCheckOutProduct extends TestBase {
	//register
	//search
	//add to cart
	//checkout
	//logout

	HomePage homeobject;
	UserRegersteraionPage registerobject;
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	AddToCardPage cardobject;
	CheckOutPage checkoutobject;
	String productname = "Apple MacBook Pro 13-inch";
	String sucessmessage = "Your message has been sent.";
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
	public void usercanadproducttoshoppingcard()
	{ 
		detailsobject=new ProductDetailsPage(driver);
		detailsobject.addproducttocard();
		detailsobject.openashopingcardpage();
		cardobject= new AddToCardPage(driver);
		Assert.assertTrue(cardobject.totallb1.getText().contains("3,600.00"));

	}


	@Test(priority=4  )

	public void registerdusercancheckoutproduct() throws InterruptedException
	{
		checkoutobject=new CheckOutPage(driver);
		cardobject.checkterms();
		cardobject.clickcheckout();
		detailsobject.openashopingcardpage();
		checkoutobject.registerdusercheckoutproduct
		( "testaddress", "325142545654", "1234567890", "tetcity", "Apple MacBook Pro 13-inch");
		Assert.assertTrue(checkoutobject.productname.getText().contains("Apple MacBook Pro 13-inch"));
		checkoutobject.confirmorder();
		Assert.assertTrue(checkoutobject.thankyoulb1.isDisplayed());
	}


	@Test(priority=5  )

	public void registerdusercanlogout()
	{
		registerobject.userlogout();
	}

}
