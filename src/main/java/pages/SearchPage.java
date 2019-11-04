package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy( id = "small-searchterms")
	WebElement searchtxtbox;
	
	@FindBy( xpath = "//*[@id=\"small-search-box-form\"]/input[2]")
	WebElement searchbtn;
	
	@FindBy(id = "ui-id-1")
	 java.util.List< WebElement> productlist;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/h2/a")
	WebElement producttitle;
	
	public void productSearch(String productname)
	{
		settxtelmenttxt(searchtxtbox, productname);
		clickbtn(searchbtn);
		
	}
	
	public void openproductdetailspage()
	{
	
		clickbtn(producttitle);
		
	}
	
	public void productsearchusingsutosuggest(String Searchtxt) throws InterruptedException
	{
		settxtelmenttxt(searchtxtbox, Searchtxt);
		Thread.sleep(3000);
		productlist.get(0).click();
	}

}
