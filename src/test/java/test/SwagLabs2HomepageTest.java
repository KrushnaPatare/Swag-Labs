package test;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsInventoryPage;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;

	public class SwagLabs2HomepageTest extends BaseClass {
		
		
		
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
		

		
		@Test
		public void addToCart() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnAddToCart();
			String actualItems = SwagLabsInventoryPage.countItem();
			String expectedItem = "6";
			Assert.assertEquals(actualItems, expectedItem);
			System.out.println(actualItems);
			System.out.println(expectedItem);
			test = reports.createTest("addToCart");
		}
		
		@Test
		public void selectDropdown() throws InterruptedException {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.sort();
			Thread.sleep(10000);
			String actualHighCost = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
			String expectedHighCost = "$49.99";
			System.out.println(actualHighCost);
			System.out.println(expectedHighCost);
			Assert.assertEquals(actualHighCost, expectedHighCost);
			test = reports.createTest("selectDropdown");

			
		}
		
		@Test
		public void removeFromCart() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			String actualText = SwagLabsInventoryPage.clickOnRemove();
			String expectedText = "ADD TO CART";
			System.out.println(actualText);
			System.out.println(expectedText);
			Assert.assertEquals(actualText, expectedText);
			test = reports.createTest("removeFromCart");

		}
		
		@Test
		public void openCart() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOncartLink();
			String expectedTitle = "https://www.saucedemo.com/cart.html";
			String actualTitle = driver.getCurrentUrl();
			System.out.println(actualTitle);
			System.out.println(expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			test = reports.createTest("openCart");

		}
		
		@Test
		public void openBurgerButtonMenu() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnOpenMenuButton();
//			String actualOption1 = driver.findElement(By.xpath("(//a[@class='bm-item menu-item'])[1]")).getText();
//			String expectedOption1 = "";
//			System.out.println(actualOption1);
//			System.out.println(expectedOption1);
			
			String actualClose = driver.findElement(By.xpath("//button[text()='Close Menu']")).getText();
			String expectedClose = "Close Menu";
			System.out.println(actualClose);
			System.out.println(expectedClose);
			Assert.assertEquals(actualClose, expectedClose);
			test = reports.createTest("openBurgerButtonMenu");

			
		}
		
		@Test
         public void openTwitterPage() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnTwitterButton(driver);
			String expectedUrl = "https://twitter.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openTwitterPage");

		}
		
		@Test()
         public void openFacebookPage() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnFacebookButton(driver);
			String expectedUrl = "https://www.facebook.com/saucelabs";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openFacebookPage");
			driver.close();

		}
		
		@Test(dependsOnMethods= {"openFacebookPage"})
        public void openLinkedinPage() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnLinkedinButton(driver);
			String expectedUrl = "https://www.linkedin.com/authwall?trk=bf&trkInfo=AQFwiqSv2-rs9QAAAYSfJTaYYB0GXzaNySQxgnOtz-Lway-tsnac5KABBOfwtpgTF_0qHjp67PtfUkOtA3uT0w6hSM_rQaQ6_aV5K5vqjUuR7RRsr_i0_EuEZzuJRZ-QvspsHFQ=&original_referer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F";
			String actualUrl = driver.getCurrentUrl();
			System.out.println(actualUrl);
			System.out.println(expectedUrl);
			Assert.assertEquals(actualUrl, expectedUrl);
			test = reports.createTest("openLinkedinPage");
			

		}
		
		@AfterMethod
		public void publishResult (ITestResult result) {
			
			if(result.getStatus()==ITestResult.SUCCESS)
	        {
	        	test.log(Status.PASS,result.getName());
			}
	        
			else if(result.getStatus()==ITestResult.FAILURE) 
			{
				test.log(Status.FAIL, result.getName());
			}
			
			else if(result.getStatus()==ITestResult.SKIP)
			
			{
				test.log(Status.SKIP, result.getName());
			}
			
			driver.close();
				
		}

		
		@AfterTest
		public void createReport() {
			
			reports.flush();
			
		}
		
	
	}
