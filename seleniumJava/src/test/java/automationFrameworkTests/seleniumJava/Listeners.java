package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import resources.ExtentReporterNG;
import resources.InitializationB;

public class Listeners extends InitializationB implements ITestListener {

	//Variables
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	//To maintain the results of the tests in case of parallel execution
	ThreadLocal <ExtentTest>extentTest =new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.log(Status.PASS,"Test Passed");
		extentTest.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//Dummy web driver
		WebDriver driver=null;
		
		//Log that test failed with logs
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());
		
		
		//TakeScreenShot
		//To Get TestCase Name
		String testCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e){
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testCaseName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		//After execution to generate the report with results
		extent.flush();
	}
	

}
