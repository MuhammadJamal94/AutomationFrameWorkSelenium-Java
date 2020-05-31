package automationFrameworkTests.seleniumJava;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.GoogleHB;
import pageObjects.GoogleSearchResults;
import resources.InitializationB;

public class GoogleTest extends InitializationB {
	
	//Local web driver in case of parallel mode
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
	{
		//Initialize the driver and go to url
		driver = initializeBrowser();
		//driver.get("https://www.google.com/ncr");
		//Get the url from properties file
		driver.get(prop.getProperty("url1"));
	}
	
	@Test
	public void GoogleTestCase() throws IOException
	{
		//Variables
	
		//Make object of the home page
		GoogleHB HomePage =new GoogleHB(driver);
		
		//Enter data in the textbox
		HomePage.getSearchBox().sendKeys("selenium webdriver");
		
		//Press Enter
		HomePage.getSearchBox().sendKeys(Keys.ENTER);
		
		//Make object of the home page
	    GoogleSearchResults res =new GoogleSearchResults(driver);
	    String value=res.Result().getText();
	    System.out.println("This is the value "+value);

	    //Check on the returned value
	    Assert.assertEquals(value, "What is Selenium WebDriver?");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
