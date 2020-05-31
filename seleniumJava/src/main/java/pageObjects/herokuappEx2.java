package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class herokuappEx2 {
	
	public WebDriver driver;
	//Dynamic Loading tab
	//By btnStart=By.id("start");
	By btnStart=By.xpath("//*[@id=\"start\"]/button");
	
	//Hello World MSG
	By helloWorldMSG=By.xpath("//*[@id='finish']/h4");
	
	public herokuappEx2(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement btnStart() 
	{
		return driver.findElement(btnStart);
	}
	
	public WebElement getHelloWorldMSG() 
	{
		return driver.findElement(helloWorldMSG);
	}

}
