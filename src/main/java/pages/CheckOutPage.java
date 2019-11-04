package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fntxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lntxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailtxt;

	@FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
	WebElement countrylist;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonetxt;

	@FindBy(id = "BillingNewAddress_City")
	WebElement citytxt;

	@FindBy(id = "BillingNewAddress_Address1")
	public WebElement addresstxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	public WebElement postolcodetxt;

	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	public WebElement continuebtn;

	@FindBy(id = "shippingoption_1")
	WebElement shipingmethodrdo;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueshipingbtn;

	@FindBy(xpath = "///*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuepaymentbtn;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueinfobtn;

	@FindBy(css = "a.product-name")
	public WebElement productname;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	private WebElement confirmbtn;

	@FindBy(css = "h1")
	public WebElement thankyoulb1;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement sucessmessage;

	@FindBy(linkText = "Click here for order details.")
	private WebElement orderdetailslink;


	public void registerdusercheckoutproduct(  String address , String postcode , String phone , String city , String productname ) throws InterruptedException
	{
		/*Select Selectcou = new Select(countrylist);
		Selectcou.selectByIndex(1);*/

		settxtelmenttxt(citytxt, city);
		settxtelmenttxt(addresstxt, address);
		settxtelmenttxt(postolcodetxt, postcode);
		settxtelmenttxt(postolcodetxt, postcode);
		settxtelmenttxt(phonetxt, phone);
		clickbtn(continuebtn);
		clickbtn(shipingmethodrdo);
		clickbtn(continueshipingbtn);
		Thread.sleep(1000);
		clickbtn(continuepaymentbtn);
		Thread.sleep(1000);
		clickbtn(continueinfobtn);
		Thread.sleep(1000);

	}
	public void confirmorder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickbtn(confirmbtn);

	}

}
