package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase  {

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver;
		action= new Actions(driver);

	}
	@FindBy(linkText = "Register")
	WebElement registerlink;
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	
	@FindBy(linkText = "My account")
	WebElement myaccount;
	
	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")
	WebElement contactuslink;
	
	@FindBy(linkText = "Computers")
	WebElement computermenu;
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebookmenu;
	
	
	public void openregistrationpage() {
		clickbtn(registerlink);

	}

	public void openloginpage() {
		clickbtn(loginlink);

	}
	public void openmyaccountpage() {
		clickbtn(myaccount);

	}
	
	public void opencontactuspage() {
		Scrolltobottom();
		clickbtn(contactuslink);

	}
	
	public void selectnotebookmenu() {
	 action.moveToElement(computermenu)
	 .moveToElement(notebookmenu)
	 .click()
	 .build()
	 .perform();

	}
}
