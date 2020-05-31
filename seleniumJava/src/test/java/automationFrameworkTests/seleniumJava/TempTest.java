package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.InitializationB;

public class TempTest extends InitializationB {
	
	@Test
	public void basePageNavigation() throws IOException
	{
		driver = initializeBrowser();
		driver.get("http://www.google.com");
		
	}

}
