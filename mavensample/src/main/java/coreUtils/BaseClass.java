package coreUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class BaseClass {

	public static WebDriver driver;
	/*public static ChromeDriver driver;
	public static EdgeDriver driver1;*/



	public static void launchWebsite() throws Throwable  
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Nithya\\Selenium-Automation\\mavensample\\src\\main\\resources\\cofigurations.properties");
		prop.load(fis);

		if(prop.getProperty("app.browser").equals("Chrome"))
		{

			ChromeOptions options = new ChromeOptions();

			// Disable Chrome password manager popups
			options.addArguments("--disable-notifications");
			options.setExperimentalOption("prefs", Map.of(
					"credentials_enable_service", false,
					"profile.password_manager_enabled", false
					));

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		if(prop.getProperty("app.browser").equals("Edge"))
		{

			driver = new EdgeDriver();

		}

		driver.get(prop.getProperty("app.url"));
		driver.manage().window().maximize();


	}

	public void tearDown()
	{
		if (driver != null) {
			driver.quit(); // Closes all windows and ends the session
		}
	}


}
