package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class herokuappDLPage {
	
	public WebDriver driver;
	//Dynamic Loading tab
	By example2=By.xpath("//*[text()='Example 2: Element rendered after the fact']");
	
	public herokuappDLPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getExample2() 
	{
		return driver.findElement(example2);
	}

}
