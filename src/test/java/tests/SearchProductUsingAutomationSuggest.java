package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutomationSuggest extends TestBase {
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	@Test
	public void usercansearchusingautosugeestion() throws InterruptedException
	{
		searchobject=new SearchPage(driver);
		searchobject.productsearchusingsutosuggest("mac");
		detailsobject= new ProductDetailsPage(driver);
		 Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}
}
