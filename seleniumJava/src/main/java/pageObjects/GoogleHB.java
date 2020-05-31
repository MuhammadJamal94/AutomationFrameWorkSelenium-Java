package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHB {
	
	public WebDriver driver;
	//Search box
	By searchbox=By.className("gLFyf gsfi");
	By searchboxNAME=By.name("q");
	
	public GoogleHB(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getSearchBox() 
	{
		return driver.findElement(searchboxNAME);
	}

}
