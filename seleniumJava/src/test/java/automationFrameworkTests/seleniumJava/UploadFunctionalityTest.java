package automationFrameworkTests.seleniumJava;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FileUploadedPage;
import pageObjects.GoogleHB;
import pageObjects.GoogleSearchResults;
import pageObjects.herokuappMainPage;
import pageObjects.herokuappUploadPage;
import resources.InitializationB;

public class UploadFunctionalityTest extends InitializationB {
	
	//Local web driver in case of parallel mode
	public WebDriver driver;
	
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
	public void UploadTest() throws IOException
	{
		//Variables
	
		//Make object of the home page
		herokuappMainPage HomePage =new herokuappMainPage(driver);
		
		//Press on the upload tab
		HomePage.getTagUpload().click();
		
		//Make object of the Upload page
		herokuappUploadPage UpPage = new herokuappUploadPage(driver);
		//Choose File to Upload
		UpPage.getChooseFileBTN().sendKeys(System.getProperty("user.dir")+"\\Batman.png");
		
		//Choose File to Upload
		UpPage.getUploadBTN().click();
		
		//Make object of the Check FileUpload page
	    FileUploadedPage fileUpPage =new FileUploadedPage(driver);
	    String value=fileUpPage.getfileUploadedMSG().getText();
	    System.out.println("This is the value "+value);

	    //Check on the returned value
	    Assert.assertEquals(value, "File Uploaded!");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
