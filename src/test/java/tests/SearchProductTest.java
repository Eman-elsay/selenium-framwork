package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	@Test
	public void usercansearchforproduct()
	{
		searchobject= new SearchPage(driver);
		detailsobject=new ProductDetailsPage(driver);
		searchobject.productSearch(productname);
		searchobject.openproductdetailspage();
		
		 Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}

}
