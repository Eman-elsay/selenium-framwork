package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToComparePage extends PageBase {

	public AddToComparePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/a")
	WebElement clearlist;
	@FindBy(css = "table.compare-products-table")
	WebElement  comparetable;
	@FindBy(css = "div.no-data")
	 public WebElement  nodata;
	
	@FindBy(tagName = "tr")
	java.util.List<WebElement> allrows;
	@FindBy(tagName = "td")
    java.util.List<WebElement> allcolls;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")
	public WebElement fproductname;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")
	public WebElement secproductname;
	public void clearlist()
	{
		clickbtn(clearlist);
	}
	
	public void compareproduct()
	{
		//Get all rows
		System.out.println(allrows.size());
		//get date  from each row 
		for(WebElement row :allrows)
		{
			System.out.println(row.getText() + "\t");
		}
		
		for(WebElement col :allcolls)
		{
			System.out.println(col.getText() + "\t");
		}
		
	}
	public void opencmarepage()
	{
		
	}
	

}
