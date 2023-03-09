package test;

import org.openqa.selenium.By;
import org.testng.Assert;
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
import pom.SwagLabsProductpage;
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
	    
	}
	/*
	@Test()
	public void clickProduct_ProductImg_OpenedProductpage() throws InterruptedException {
		
		SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		swagLabsProductpage.clickProductImage();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		
		System.out.println("expectedUrl = "+expectedUrl);
		System.out.println("actualUrl = "+actualUrl);
		
		Assert.assertEquals(expectedUrl, actualUrl);
		
		test = reports.createTest("clickProduct_ProductImg_OpenedProductpage");
		Thread.sleep(100);
	}
	
	
	@Test()
	public void clickProduct_ProductBanner_OpenedProductpage() throws InterruptedException {
		
		SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		swagLabsProductpage.clickProductBanner();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		
		System.out.println("expectedUrl = "+expectedUrl);
		System.out.println("actualUrl = "+actualUrl);
		
		Assert.assertEquals(expectedUrl, actualUrl);
		
		test = reports.createTest("clickProduct_ProductBanner_OpenedProductpage");
		Thread.sleep(100);
		
	}
	
	
	@Test()
	public void clickProduct_ProductBanner$Description$Price_Checked() throws InterruptedException {
		
		SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		swagLabsProductpage.clickProductBanner();
		String actualDescription = swagLabsProductpage.getProductDescription();
		String expectedDescription = "Sauce Labs Backpack\r\n"
				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\r\n"
				+ "$29.99\r\n"
				+ "Add to cart";
		
		System.out.println("expectedDescription = "+expectedDescription);
		System.out.println("actualDescription = "+actualDescription);
		
		Assert.assertEquals(expectedUrl, actualUrl);
		
		test = reports.createTest("public void doLogin_1ValidId2ValidPwd_OpenedHomepage");
		Thread.sleep(100);
	}
	

	@Test()
	public void clickProduct_AddProductButton_AddedToCart() throws InterruptedException {
		
		
		SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		swagLabsProductpage.clickProductImage();
	
		swagLabsProductpage.clickOnAddToCartButton();
		
		String actualText = swagLabsProductpage.getCartNotification();
		String expectedText = "1";
		
		System.out.println("expectedText = "+expectedText);
		System.out.println("actualText = "+actualText);
		
		Assert.assertEquals(expectedText, actualText);
		
		test = reports.createTest("clickProduct_AddProductButton_AddedToCart");
		Thread.sleep(100);
	}
	*/
	
	@Test()
	public void clickProduct_RemoveProductButton_RemovedFromCart() {
		
		SwagLabsProductpage  swagLabsProductpage = new SwagLabsProductpage (driver);
		swagLabsProductpage.
		
		
		
		
	}
	/*
	@Test()
	public void clickProduct_ProductAddOrRemoveButton_Clickable() {}
	

	
	@Test()
	public void clickProduct_BackToProductsButton_GoneToHomepage() {
		
		
		
	}
	
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
