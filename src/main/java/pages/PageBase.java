package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Actions action;
	//create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	protected  static void clickbtn(WebElement button) {
		button.click();
		
	}
	protected  static void settxtelmenttxt(WebElement txtelement ,String value) {
		txtelement.sendKeys(value);
		
	}
	
	public  void Scrolltobottom()
	{
		jse.executeScript("scrollBy(0,2500)");
		
	}
	
	public  void cleartext( WebElement element)
	{
		
		element.clear();
	}

}
