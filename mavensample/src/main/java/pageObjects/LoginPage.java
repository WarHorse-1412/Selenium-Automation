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
	static By listof_username = By.xpath("//div[@class='login_credentials']");
	static By listof_pwd = By.xpath("//div[@class='login_password']");
	
	//METHODS
	public static void  login()
	{
		
//		driver.findElement(input_Username).sendKeys("standard_user");
//		driver.findElement(input_Pwd).sendKeys("secret_sauce");
//		driver.findElement(btn_login).click();
		
		SeleniumHelper.sendTextToAnElement(driver, input_Username , "standard_user");
		SeleniumHelper.sendTextToAnElement(driver, input_Pwd , "secret_sauce");
		SeleniumHelper.clickOnElement(driver, btn_login);
		
	}
	
	//TO PRINT
	public static void toPrint()
	{
		
		System.out.println("\n"+SeleniumHelper.getTextFromAnElement(driver, header));
		
	}
	
	//To validate the fields
	public static String validateStaticTextinUI()
	{
		StringBuilder error1 = new StringBuilder("");
		
		//To validate the header text
		if(!"Swag Lab".equals(SeleniumHelper.getTextFromAnElement(driver, header)))
		{
			
			error1.append("Header Text is mismatch, Expected is : Swag Lab, but found : "
			+SeleniumHelper.getTextFromAnElement(driver, header));
		}
		
		//To validate placeholder
		if(!"Username".equals(SeleniumHelper.getAttributeFromAnElement(driver, input_Username, "placeholder")))
		{
			error1.append("Username placeholder Text is mismatch, Expected is : Username, but found : "
					+SeleniumHelper.getAttributeFromAnElement(driver, input_Username, "placeholder"));
		}
		
		if(!"Password".equals(SeleniumHelper.getAttributeFromAnElement(driver, input_Pwd, "placeholder")))
		{
			error1.append("Password placeholder Text is mismatch, Expected is : Password, but found : "
					+SeleniumHelper.getAttributeFromAnElement(driver, input_Pwd, "placeholder"));
		}
		if(!"Login".equals(SeleniumHelper.getAttributeFromAnElement(driver, btn_login, "value")))
		{
			error1.append("Login button Text is mismatch, Expected is : Login, but found : "
					+SeleniumHelper.getAttributeFromAnElement(driver, btn_login, "placeholder"));
		}
		System.out.println("\nList of Username:\n\n"+SeleniumHelper.getTextFromAnElement(driver, listof_username));
		System.out.println("\nList of Password:\n\n"+SeleniumHelper.getTextFromAnElement(driver, listof_pwd));
		
		return String.valueOf(error1);
		
	}

}