package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FileUploadedPage;
import pageObjects.GoogleHB;
import pageObjects.GoogleSearchResults;
import pageObjects.herokuappDLPage;
import pageObjects.herokuappEx2;
import pageObjects.herokuappMainPage;
import pageObjects.herokuappUploadPage;
import resources.InitializationB;

public class HeroKuappTest extends InitializationB {
	
	@BeforeTest
	public void init() throws IOException
	{
		//Initialize the driver and go to url
		driver = initializeBrowser();
		//driver.get("https://www.google.com/ncr");
		//Get the url from properties file
		driver.get(prop.getProperty("url2"));
	}
	
	@Test
	public void GoogleTestCase() throws IOException
	{
		
		//Variables
		
		//Make object of the home page
		herokuappMainPage HomePage =new herokuappMainPage(driver);
		
		//Press on the upload tab
		HomePage.getTagDL().click();
		
		//Make object of the DL page
		herokuappDLPage DLPage = new herokuappDLPage(driver);
		//Choose example2
		DLPage.getExample2().click();
		
		herokuappEx2 ex2Page = new herokuappEx2(driver);
		
		//Click on start BTN
		ex2Page.btnStart().click();
		
		//Explicit Wait to let the item load
		WebDriverWait w = new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOf(ex2Page.getHelloWorldMSG()));
		
		//Check MSG
		String value = ex2Page.getHelloWorldMSG().getText();
		
	    System.out.println("This is the value "+value);

	    //Check on the returned value
	    Assert.assertEquals(value, "Hello World!");
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
	}

}
