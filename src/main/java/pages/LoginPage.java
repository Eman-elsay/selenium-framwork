package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "Email")
	WebElement emailtxboxt;
	
	@FindBy(id = "Password")
	WebElement passwordtxtbox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginbtn;

	public void userlogin( String email, String password)
	{
		settxtelmenttxt(emailtxboxt, email);
		settxtelmenttxt(passwordtxtbox, password);
		clickbtn(loginbtn);
	}
}
