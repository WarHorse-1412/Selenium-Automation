package coreUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BaseClass {
	
	public static WebDriver driver;
	/*public static ChromeDriver driver;
	public static EdgeDriver driver1;*/

	    
		
		public static void launchWebsite() throws Throwable  
		{
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Nithya\\mavensample\\src\\main\\resources\\cofigurations.properties");
            prop.load(fis);
			
            if(prop.getProperty("app.browser").equals("Chrome"))
			{
				
			driver = new ChromeDriver();
		
			}
			if(prop.getProperty("app.browser").equals("Edge"))
			{
				
			driver = new EdgeDriver();
		
			}
			
			driver.get(prop.getProperty("app.url"));
			driver.manage().window().maximize();
			
			
		}

}
