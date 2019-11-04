package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddproductWishlist  extends TestBase{
	
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchobject ;
	ProductDetailsPage detailsobject ;
	WishListPage wishlistobject;
	@Test (priority = 1)
	public void usercansearchusingautosugeestion() throws InterruptedException
	{
		searchobject=new SearchPage(driver);
		searchobject.productsearchusingsutosuggest("mac");
		detailsobject= new ProductDetailsPage(driver);
		 Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
		 detailsobject.addproducttowishlist();
		 detailsobject.openwishlistpage();
	}
	@Test(priority = 2)

	public void userremoveproducttowishlist()
	{
		wishlistobject=new WishListPage(driver);
		wishlistobject.removeproductfromwishlist();
	}
	
}
