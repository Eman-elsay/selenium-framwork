package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddtoCompareTest extends TestBase {

	String firstproductname="Apple MacBook Pro 13-inch";
	String secondproductname="Asus N551JK-XO076H Laptop";
	// search for product num 1
	//search for product num 2
	//add to compare 
	//clear list 
	ProductDetailsPage detailsobject;
	HomePage homeobject;
	SearchPage searchobject;
	AddToComparePage compareobject ;

	@Test (priority = 1)
	public void usercancompareproduct() throws InterruptedException
	{
		searchobject=new SearchPage(driver);
		detailsobject= new ProductDetailsPage(driver);
		compareobject= new AddToComparePage(driver);
		
		searchobject.productsearchusingsutosuggest("mac");
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().contains(firstproductname));
		detailsobject.addproducttocompare();
		
		searchobject.productsearchusingsutosuggest("sus");
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().contains(secondproductname));
		detailsobject.addsecondproducttocompare();
		
		
		detailsobject.opencomparepage();
		Assert.assertTrue(compareobject.fproductname.isDisplayed());
		Assert.assertTrue(compareobject.secproductname.getText().contains(secondproductname));
		compareobject.compareproduct();
		
		
	}
	@Test (priority =2)
	public void usercanclearcomparelist()
	{
		compareobject.clearlist();
		Assert.assertTrue(compareobject.nodata.getText().contains("You have no items to compare"));
		
	}
	

}
