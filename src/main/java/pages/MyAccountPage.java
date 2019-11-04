package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(linkText = "Change password")
	WebElement changepasswordlink;
	
	@FindBy(id = "OldPassword")
	WebElement oldpasswordtxt;
	
	@FindBy(id = "NewPassword")
	WebElement newpasswordtxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmpasswordtxt;
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changepassbtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div" )
	 public WebElement sucesschangepassmessage;
	
    @FindBy(linkText = "My account")
	public WebElement myaccountlink;
	
	public void openchangepasswordpage()
	{
		clickbtn(changepasswordlink);

	}
	public void changepassword(String oldpassword , String newpassword )
	{
		settxtelmenttxt(oldpasswordtxt,oldpassword);
		settxtelmenttxt(newpasswordtxt, newpassword);
		settxtelmenttxt(confirmpasswordtxt, newpassword);
		clickbtn(changepassbtn); 
	}
	public void openmyaccount() {

		clickbtn(myaccountlink);
		
	}
	
}
