package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import coreUtils.BaseClass;
import coreUtils.SeleniumHelper;


/*Page class is used to hold the Xpath for the all elements in the page and we will have set of methods which 
are basically user actions on page*/
public class LoginPage extends BaseClass{
	
	//PAGE OBJECTS
	static By header = By.xpath("//div[text()='Swag Labs']");
	static By btn_login = By.xpath("//input[@class='submit-button btn_action']");
	static By input_Username = By.xpath("//input[@id='user-name']");
	static By input_Pwd = By.xpath("//input[@id='password']");
	static By listof_username = By.xpath("//div[@class='login_logo']");
	
	//METHODS
	public static String login()
	{
		StringBuilder error1 = new StringBuilder("");
//		driver.findElement(input_Username).sendKeys("standard_user");
//		driver.findElement(input_Pwd).sendKeys("secret_sauce");
//		driver.findElement(btn_login).click();
		
		SeleniumHelper.sendTextToAnElement(driver, input_Username , "standard_user");
		SeleniumHelper.sendTextToAnElement(driver, input_Pwd , "secret_sauce");
		
		if(!"Swag Lab".equals(SeleniumHelper.getTextFromAnElement(driver, header)))
		{
			
			error1.append("Header Text is mismatch, Expected is : Swag Lab, but found : "
			+SeleniumHelper.getTextFromAnElement(driver, header));
		}
		
		SeleniumHelper.clickOnElement(driver, btn_login);
		
		
		return String.valueOf(error1);
	}
	
	//TO PRINT
	public static void toPrint()
	{
		
		System.out.println("\n"+SeleniumHelper.getTextFromAnElement(driver, listof_username));
		
	}

}