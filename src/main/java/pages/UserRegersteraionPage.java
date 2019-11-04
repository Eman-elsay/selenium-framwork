package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegersteraionPage extends PageBase {

	public UserRegersteraionPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "gender-male")
	WebElement genderrdobtn;

	@FindBy(id = "FirstName")
	WebElement firstnametxt;

	@FindBy(id = "LastName")
	WebElement lastnametxt;

	@FindBy(id = "Email")
	WebElement emailtxt;

	@FindBy(id = "Password")
	WebElement passwordtxt;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordtxt;

	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	 public WebElement suceessmessage;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutlink;
	
	
	
	public void userregisteration(String firstname, String lastname, String email, String password) {
		clickbtn(genderrdobtn);
		settxtelmenttxt(firstnametxt, firstname);
		settxtelmenttxt(lastnametxt, lastname);
		settxtelmenttxt(emailtxt, email);
		settxtelmenttxt(passwordtxt, password);
		settxtelmenttxt(confirmpasswordtxt, password);
		clickbtn(registerbtn);

	}
	public void userlogout()
	{
		clickbtn(logoutlink);
	}
}

