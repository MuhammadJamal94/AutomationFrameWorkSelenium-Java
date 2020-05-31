package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class herokuappUploadPage {
	
	public WebDriver driver;
	//chooseFileBTN
	By chooseFileBTN=By.id("file-upload");
	
	//File Upload tab
	By UploadBTN= By.id("file-submit");
	
	public herokuappUploadPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getChooseFileBTN() 
	{
		return driver.findElement(chooseFileBTN);
	}
	public WebElement getUploadBTN() 
	{
		return driver.findElement(UploadBTN);
	}

}
