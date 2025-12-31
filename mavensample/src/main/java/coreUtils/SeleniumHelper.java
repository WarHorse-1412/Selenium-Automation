package coreUtils;

import java.io.File;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumHelper {

	public static void clickOnElement(WebDriver driver, By by)
	{
		WebElement element=null;
		//to wait for user defined amount of time
		try {
			//Explicit wait example
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(Exception e) {
			System.out.println("\nElement not Visible after certain wait time\n");
		}
		//to scroll until element became visible
		try
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			System.out.println("\nElement not Visible after scrolling\n");
		}
		//to check element is enabled/disabled
		try
		{
		element.isEnabled();
		}
		catch(Exception e) {
			System.out.println("\nElement not enabled\n");
		}
		
		element.click();
	}
	
	public static void sendTextToAnElement(WebDriver driver, By by, String text)
	{
		WebElement element=null;
		//to wait for user defined amount of time
		try {
			//Explicit wait example
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(Exception e) {
			System.out.println("\nElement not Visible after certain wait time\n");
		}
		//to scroll until element became visible
		try
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			System.out.println("\nElement not Visible after scrolling\n");
		}
		//to check element is enabled/disabled
		try
		{
		element.isEnabled();
		}
		catch(Exception e) {
			System.out.println("\nElement not enabled\n");
		}
		
		element.sendKeys(text);
	}
	
	public static String getTextFromAnElement(WebDriver driver, By by)
	{
		WebElement element = null;
		
		//to wait for user defined amount of time
		try {
			//Explicit wait example
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("\nElement not Visible after certain wait time\n");
		}
		//to scroll until element became visible
		try
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			System.out.println("\nElement not Visible after scrolling\n");
		}
		//to check element is enabled/disabled
		try
		{
		element.isEnabled();
		}
		catch(Exception e) {
			System.out.println("\nElement not enabled\n");
		}
		
		return element.getText();
		 
	}
	
	//Extent Report
	public static void cogfigureExtentReport()
	{
		ExtentReports extentReports = new ExtentReports();
		File file = new File("TestReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);

	}
	
    //To print success msg in report
	public static void logPass(String message)
	{
		ExtentCucumberAdapter.addTestStepLog("<b>Status:</b> <span style='color:blue;'>"+message+"</span>");
     
	}
	
	public static void logFail(String message)
	{
		ExtentCucumberAdapter.addTestStepLog("<b>Status:</b> <span style='color:red;'>"+message+"</span>");
     
	}
}
