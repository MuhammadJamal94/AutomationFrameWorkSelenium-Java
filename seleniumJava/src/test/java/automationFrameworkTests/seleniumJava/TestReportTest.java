package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestReportTest {
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter spark =new ExtentSparkReporter(path); 
		spark.config().setReportName("Jimmy's Report");
		spark.config().setDocumentTitle("Terkwaz TestReport");
		

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Jimmy");
		
		
	}
	
	@Test
	public void openBrowser() throws IOException
	{
		ExtentTest test= extent.createTest("1st TC");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium CrossOver\\chromedriver_win32\\chromedriver.exe");
		
		//Create WebDriver
		WebDriver driver =  new ChromeDriver();
		driver.get("http://google.com");
		test.addScreenCaptureFromBase64String("MJ");
		String url = driver.getCurrentUrl();
		String s=driver.getTitle();
		System.out.println(s);
		System.out.println(url);
		//driver.get("http://yahoo.com");
		//driver.navigate().back();
		//driver.navigate().forward();
		
		driver.close();//Closes only the current window
		//driver.quit();//Closes all the windows opened by selenium
		extent.flush();//after execution to update status
	}

}
