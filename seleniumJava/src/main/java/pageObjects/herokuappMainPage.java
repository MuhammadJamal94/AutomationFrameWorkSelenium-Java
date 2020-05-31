package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class herokuappMainPage {
	
	public WebDriver driver;
	//Dynamic Loading tab
	By DL=By.xpath("//*[text()='Dynamic Loading']");
	
	//File Upload tab
	By UploadTab = By.linkText("File Upload");
	
	public herokuappMainPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getTagDL() 
	{
		return driver.findElement(DL);
	}
	public WebElement getTagUpload() 
	{
		return driver.findElement(UploadTab);
	}

}
