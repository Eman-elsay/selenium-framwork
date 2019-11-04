package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCardPage extends PageBase {

	public AddToCardPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "removefromcart")
	WebElement removecheck;

	@FindBy( name = "updatecart")
	WebElement updatecard;

	@FindBy(id = "itemquantity11594" )
	WebElement quantitytxt;

	@FindBy(css = "td.subtotal")
	public WebElement totallb1;

	@FindBy( xpath = "//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/input[1]")
	WebElement updatecardbtn;
	

	@FindBy(id = "checkout")
	public WebElement checkoutbtn;
	
	@FindBy(id = "termsofservice")
	public WebElement checkagreement;

	public void removeproductfromcard()
	{
		clickbtn(removecheck);
	}

	public void updateproductquantityincard( String quantity)
	{
		//clear current quantity
		clickbtn(quantitytxt);
		settxtelmenttxt(quantitytxt, quantity);
		clickbtn(updatecard);
	}
	public void clickcheckout()
	{
		clickbtn(checkoutbtn);
	}
	
	public void checkterms()
	{
		clickbtn(checkagreement);
	}




}
