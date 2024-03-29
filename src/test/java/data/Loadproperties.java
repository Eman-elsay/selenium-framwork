package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Loadproperties {
	//load the properties file 
	public static Properties userData= loadproperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

	private static Properties loadproperties(String path) {
		Properties pro = new Properties();
		// stream for reading file 
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("error occured :" +e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("error occured :" +e.getMessage());
		}
		return pro;
	}

}
