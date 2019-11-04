package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase  {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "AddProductReview_Title")
	WebElement reviewtitle;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewtxtboxe;

	@FindBy(id = "addproductrating_5")
	WebElement ratingbtn;

	@FindBy(xpath = "//*[@id=\"review-form\"]/form/div[2]/input")
	WebElement submitreviewbtn;
	
	@FindBy(css = "div.result")
	 public WebElement sucessreviewnotification;
	
	public void addproductreview( String title ,String reviwmess )
	{
		settxtelmenttxt(reviewtitle, title);
		settxtelmenttxt(reviewtxtboxe, reviwmess);
		clickbtn(ratingbtn);
		clickbtn(submitreviewbtn);
	}

}


