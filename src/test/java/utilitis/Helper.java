package utilitis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	// method to take screenshot when test case fail 
	public static void capturescreenshoot( WebDriver driver,String screenshotname)
	{
		Path dest= Paths.get("./screenshots", screenshotname +".png");
		try {
			java.nio.file.Files.createDirectories(dest.getParent());
			FileOutputStream out= new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		} catch (IOException e) {

			System.out.println("Exception while taking creenshot" + e.getMessage());
		}

	}

}
