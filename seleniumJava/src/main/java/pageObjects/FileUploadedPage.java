package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadedPage {
	
	public WebDriver driver;
	//File Uploaded MSG
	By fileUploadedMSG=By.xpath("//*[@id=\"content\"]/div/h3");
	
	public FileUploadedPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getfileUploadedMSG() 
	{
		return driver.findElement(fileUploadedMSG);
	}

}
