package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pojo.Browser;
import pom.SwagLabsCartPage;
import pom.SwagLabsLoginPage;
import pom.SwagLabsProductpage;
import utility.BaseClass;
import utility.ExtentReport;

@Listeners(utility.Listeners.class)
public class SwagLabs4CartpageTest extends BaseClass{
	
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
		 SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		 swagLabsLoginPage.enterUsername("standard_user");
		 swagLabsLoginPage.enterPassword("secret_sauce");
		 swagLabsLoginPage.clickOnLogin();
		 SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		 swagLabsProductpage.clickProductImage();
		 swagLabsProductpage.clickOnAddToCartButton();
		 swagLabsProductpage.clickOnCartButton();
	}


	@Test(priority=1)
	public void clickCart_AddedProducts_ShowedDetails() throws InterruptedException {
		
		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		String actualDetails = swagLabsCartPage.showProductDetails();
		String expectedDetails = "Sauce Labs Backpack\n"
				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n"
				+ "$29.99\n"
				+ "Remove";
		System.out.println(expectedDetails);
		System.out.println(actualDetails);
		Assert.assertEquals(expectedDetails, actualDetails);
		test = reports.createTest("clickCart_AddedProducts_ShowedDetails");
		Thread.sleep(100);
	}
	
	
	@Test(priority=2)
	public void clickCart_AddedProducts_Removed() throws InterruptedException {
		
		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOnRemove();
		boolean expectedCheck = true;
		boolean actualCheck = false;
			
		try {
				driver.findElement(By.xpath("span"));
			}
		catch(NoSuchElementException e){
				actualCheck = true;
				System.out.println("NoSuchElementException");
		     }
		
			System.out.println("expectedCheck = "+expectedCheck);
			System.out.println("actualCheck = "+actualCheck);
			Assert.assertEquals(expectedCheck, actualCheck);
			test = reports.createTest("clickCart_AddedProducts_Removed");
			Thread.sleep(100);
	}
	
	
	@Test(priority=3)
	public void clickCart_ContinueShoppingButton_RedirectedToHomepage() throws InterruptedException {
		
		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOncontinueShopping();
		String expectedUrl = driver.getCurrentUrl();
		String actualUrl = "https://www.saucedemo.com/inventory.html";
		System.out.println("expectedUrl = "+expectedUrl);
		System.out.println("actualUrl = "+actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		test = reports.createTest("clickCart_ContinueShoppingButton_RedirectedToHomepage");
		Thread.sleep(100);
	}
	

	@Test(priority=4)
	public void clickCart_CheckoutButton_OpenedCheckoutpage() throws InterruptedException {
		
		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOnCheckoutButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		System.out.println("expectedUrl = "+expectedUrl);
		System.out.println("actualUrl = "+actualUrl);
		test = reports.createTest("clickCart_ContinueShoppingButton_RedirectedToHomepage");
		Thread.sleep(100);
	}
		
	
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
