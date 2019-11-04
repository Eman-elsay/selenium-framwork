package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegersteraionPage;

public class ProductReviewtest extends TestBase {
	
	//register
	//openproductdetails
	//addreview
	HomePage homeobject;
	UserRegersteraionPage registerobject;
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	ProductReviewPage reviewobject;
	String productname = "Apple MacBook Pro 13-inch";
	Faker fakerData = new Faker();
	String firstname = fakerData.name().firstName();
    String lastname = fakerData.name().lastName();
    String emailfake= fakerData.internet().emailAddress();
    String password = fakerData.number().digits(8).toString();
    String newpassword = fakerData.number().digits(8).toString();
    String reviwtitle = "test";
    String reviewmess ="test eman";
    String assertmessage = "Product review is successfully added"  ;  
    
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
  			 detailsobject.openproductreviewpage();
  		}
  		
  		@Test(priority = 3)
  		public void registerduseraddproductreview()
  		{
  			reviewobject =new ProductReviewPage(driver);
  			reviewobject.addproductreview(reviwtitle, reviewmess);
  			
  			 Assert.assertTrue(reviewobject.sucessreviewnotification.getText().contains(assertmessage));
  		}
    
    

}
