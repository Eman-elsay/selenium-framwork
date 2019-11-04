package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	HomePage homeobject;
	@Test
	public void usercanselectsubcategoryfrommainmenu()
	{
		homeobject= new HomePage (driver);
		homeobject.selectnotebookmenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));	
		}

}
