package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;

@Listeners(utility.Listeners.class)
public class SwagLabs3ProductpageTest extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports = ExtentReport.createExtentReports();
		reports.setSystemInfo("Test Suite", "Regression Test");
		reports.setSystemInfo("Test Performed By", "Krushna Patare");
	}
	
	@BeforeMethod()
	
	public void openInventorypage() throws InterruptedException {
		
		driver = Browser.openBrowser("chrome");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUsername("standard_user");
	    swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
	    Thread.sleep(1000);
	}
	
	@Test()
	public void clickProduct_ProductImg_Checked() {
		
		
		
	}
	
	
	@Test()
	public void clickProduct_ProductBanner$Description$Price_Checked() {}
	
	
	@Test()
	public void clickProduct_AddProductButton_AddedToCart() {}
	
	
	@Test()
	public void clickProduct_RemoveProductButton_RemovedFromCart() {}
	
	@Test()
	public void clickProduct_ProductAddOrRemoveButton_AddedToCart() {}
	
	@Test()
	public void clickProduct_Productpage_Opened() {
		
		
	}
	
	@Test()
	public void clickProduct_BackToProductsButton_GoneToHomepage() {
		
		
		
	}
	
/*
  		@Test()
		public void verifyProduct_TitleAndDescriptionAndPrice_Checked() {}
		
		
		@Test()
		public void verifyProducts_Same$ActualAndGiven_ShownOnScreen() {}
		
		
		@Test()
		public void verifyProducts_AddAction_AddedToCart() {}
		
		
		@Test()
		public void verifyProducts_RemoveAction_RemovedFromCart() {}
		
	
		
		
		*/
		
	
	
	@AfterMethod
	public void publishResult (ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			
        	test.log(Status.PASS,result.getName());
		   }
        
		else if(result.getStatus()==ITestResult.FAILURE) {
			
			test.log(Status.FAIL, result.getName());
			}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
			test.log(Status.SKIP, result.getName());
			}
		
		driver.close();		
	}

	
	@AfterTest
	public void createReport() {
		reports.flush();
	}

}
