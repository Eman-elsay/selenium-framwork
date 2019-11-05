package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilitis.Helper;

public class TestBase extends AbstractTestNGCucumberTests  {
	public static WebDriver driver;
	@BeforeSuite
	@org.testng.annotations.Parameters({"browser"})
	public void startdriver( @Optional ("chrome")String browsername)
	{
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");

			driver= new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) {

			System.setProperty("WebDriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");

			driver= new FirefoxDriver();

		}
		 if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");

			driver= new InternetExplorerDriver(); 
		}
		// headless browser testing 
		 if (browsername.equalsIgnoreCase("headless"))
		 {
			 DesiredCapabilities caps =new DesiredCapabilities();
			 caps.setJavascriptEnabled(true);
			 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+ "\\drivers\\phantomjs.exe");
			
			 String[] phantomarg= {"--web-security=no"," --ignore-ssl-errors=yes"};
			 caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomarg);
			 driver= new PhantomJSDriver(caps);
		 }
		
		else if (browsername.equalsIgnoreCase("safari")) {
			driver= new SafariDriver();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/"); 




	}

	@AfterSuite
	public void stopdriver()
	{
		driver.quit();
	}
	
	//take screenshot when tet fail 
	@AfterMethod
	public void screnshotonfailure( ITestResult result)
	{
		if (result.getStatus()== ITestResult.FAILURE) {
			System.out.println("failed");
			System.out.println("taking screenshoot...");
			Helper.capturescreenshoot(driver, result.getName());
		}
		
	}
}
