package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import utility.BaseClass;
import utility.ExtentReport;

public class SwagLabs6CheckoutCompletepage extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports = ExtentReport.createExtentReports();
		reports.setSystemInfo("Test Suite", "Regression Test");
		reports.setSystemInfo("Test Performed By", "Krushna Patare");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		
		 driver = Browser.openBrowser(browser); 
	}

	@Test(priority=1)
	public void openCheckoutComplete_GreetInformation_Displyed() {
		
	}
	
	@Test(priority=2)
	public void openCheckoutComplete_BackToHomeButton_RedirectedToProductpage() {
		
	}

}
