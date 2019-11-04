package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage  extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]/a")
	WebElement producrcell;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	WebElement wishlistheader;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/input[1]")
	WebElement updatewislistbtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input")
	WebElement remove;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div")
	WebElement emptycart;
	
	public void removeproductfromwishlist()
	{
		clickbtn(remove);
		clickbtn(updatewislistbtn);
	}
	

}
