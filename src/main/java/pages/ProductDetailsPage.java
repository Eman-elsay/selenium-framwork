package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div[1]/ul/li[4]/strong")
	public WebElement productnamebreadcrumb;

	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	public WebElement emailtofriendbtn;

	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement addreviewlink;

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addtowislistbtn;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")
	WebElement wishlistlink;

	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[2]/input")
	WebElement addtocomparebtn;

	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/div[2]/input")
	WebElement addtocomparebtn2;
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement copmarepagelink;

	@FindBy(xpath = "//*[@id=\"add-to-cart-button-4\"]")
	WebElement addtocardbtn;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement shopingcardlink;
	public void emailtofriendbutton()
	{
		clickbtn(emailtofriendbtn);
	}

	public void openproductreviewpage()
	{
		clickbtn(addreviewlink);
	}

	public void addproducttowishlist()
	{
		clickbtn(addtowislistbtn);
	}

	public void openwishlistpage()
	{
		clickbtn(wishlistlink);
	}

	public void addproducttocompare()
	{
		clickbtn(addtocomparebtn);
	}
	
	public void addsecondproducttocompare()
	{
		clickbtn(addtocomparebtn2);
	}

	public void  opencomparepage()
	{
		clickbtn(copmarepagelink);
	}
	public void  addproducttocard()
	{
		clickbtn(addtocardbtn);
	}
	
	public void  openashopingcardpage()
	{
		clickbtn(shopingcardlink);
	}
}
