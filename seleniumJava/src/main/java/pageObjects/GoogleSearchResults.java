package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchResults {
	
	public WebDriver driver;	
	
	//Search Results
	By thirdResult=By.xpath("//*[@id=\"rso\"]/div[3]/div/div[1]/a/h3");
	By fourthResult=By.xpath("//*[@id=\"rso\"]/div[4]/div/div[1]/a/h3");
	
	
	
	public GoogleSearchResults(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement Result() 
	{
		return driver.findElement(thirdResult);
	}

}
