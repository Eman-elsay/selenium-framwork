package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCardPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCardTest extends TestBase {
	
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	AddToCardPage cardobject;
	String productname= "Apple MacBook Pro 13-inch";
	
	@Test (priority = 1)
	public void usercansearchusingautosugeestion() throws InterruptedException
	{
		searchobject=new SearchPage(driver);
		searchobject.productsearchusingsutosuggest("mac");
		detailsobject= new ProductDetailsPage(driver);
		 Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase( productname));
	}
@Test(priority = 2)
public void usercanadproducttoshoppingcard()
{ 
	detailsobject=new ProductDetailsPage(driver);
	detailsobject.addproducttocard();
	detailsobject.openashopingcardpage();
	cardobject= new AddToCardPage(driver);
	Assert.assertTrue(cardobject.totallb1.getText().contains("3,600.00"));

	}
}
