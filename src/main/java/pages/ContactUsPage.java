package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage  extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement fullnametxt;
	@FindBy(id = "Email")
	WebElement emailtxt;
	@FindBy(id = "Enquiry")
	WebElement enqurytxt;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement submitbtn;
	@FindBy(css = "div.result")
	 public WebElement successmessage;
	
	public void contactus(String fullname ,String email ,String enqury ) {
		settxtelmenttxt(fullnametxt, fullname);
		settxtelmenttxt(emailtxt, email);
		settxtelmenttxt(enqurytxt, enqury);
		clickbtn(submitbtn);
		
	}

}
