package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css = "input.friend-email")
	WebElement emailfriendtxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement friendmessagetxt;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement sendemailbtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	 public WebElement messagenotification;
	
	public void sendemailtofriend(String emailfriend ,String messagecontnt )
	{
		settxtelmenttxt(emailfriendtxt, emailfriend);
		settxtelmenttxt(friendmessagetxt, messagecontnt);
		clickbtn(sendemailbtn);
	}

}
