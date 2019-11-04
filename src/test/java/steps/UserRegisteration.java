package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegersteraionPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{
	HomePage homeobject;
	UserRegersteraionPage registerobj;
	@Given(" ^the user is the home page $")
	public void  the_user_in_te_homppage()
	{
		homeobject= new HomePage(driver);
		homeobject.openregistrationpage();
	}
	@When("^iclicked on registerlink$")
	
	public void icoickedonregisterlink()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("^ienterd the user data$")
	public void i_enterd_the_uder_data()
	{
		registerobj= new UserRegersteraionPage(driver);
		registerobj.userregisteration("eman", "khalid", "ematt@tt.tt", "1234567");
				
	}
	@Then("^the registeration page sucessfully displayed")
	public void theregisteration_page_display_sucessfully()
	{
		registerobj.userlogout();
	}
}
