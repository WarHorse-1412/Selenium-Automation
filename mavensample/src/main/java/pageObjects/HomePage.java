package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import coreUtils.BaseClass;
import coreUtils.SeleniumHelper;

public class HomePage extends BaseClass {
	
    StringBuilder textError = new StringBuilder("");
	
	//Static Xpath
	static By header = By.xpath("//div[text()='Swag Labs']");
	static By secondaryheader = By.xpath("//span[@class='title']");
	
	//Dynamic xpath
	static String productCards = "(//div[@class='inventory_item_name '])[%s]";
	
	//Method to verify text in home page
	public void verifyStaticText()
	{
		
		if(!"Swag Lab".equals(SeleniumHelper.getTextFromAnElement(driver, header)))
		{
			
			textError.append("\n\nHeader Text is mismatch, Expected is : Swag Labs, but found : "
			+SeleniumHelper.getTextFromAnElement(driver, header));
		}
		
		if(!"Products".equals(SeleniumHelper.getTextFromAnElement(driver, secondaryheader)))
		{
			
			textError.append("\n\nSecondary Header Text is mismatch, Expected is : Product, but found : "
			+SeleniumHelper.getTextFromAnElement(driver, secondaryheader));
		}
	}
	
	public void validateProductCards()
	{
		//ITERATE PRODUCT CARD HEADERS
		List<String> expectedProductCardHeaders = List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt"
				, "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
		
		for(int i=1 ; i<=6 ; i++)
		{
			By element = By.xpath(String.format(productCards, i));
			if(!expectedProductCardHeaders.equals(SeleniumHelper.getTextFromAnElement(driver, element)))
			{
				
				textError.append("\n\nSecondary Header Text is mismatch, Expected is : Product, but found : "
				+SeleniumHelper.getTextFromAnElement(driver, secondaryheader));
			}
		}
	}

}
