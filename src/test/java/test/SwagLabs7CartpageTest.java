package test;

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
import pom.SwagLabsHomepage;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;

@Listeners(utility.Listeners.class)
public class SwagLabs7CartpageTest extends BaseClass{
	
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
	public void launchBrowser(String browser) throws InterruptedException {
		
		 driver = Browser.openBrowser(browser); 
		 SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		 swagLabsLoginPage.enterUsername("standard_user");
		 swagLabsLoginPage.enterPassword("secret_sauce");
		 swagLabsLoginPage.clickOnLogin();
		 SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
		 SwagLabsHomepage.clickOnCartButton();
		 Thread.sleep(1000);
	}

	
	
	@Test(priority=1)
	public void clickCart_Clickable_OpenedCart() {
		
		SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
		SwagLabsHomepage.clickOnCartButton();
		
		String expectedTitle = "https://www.saucedemo.com/cart.html";
		String actualTitle = driver.getCurrentUrl();
		
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		test = reports.createTest("clickCart_Clickable_OpenedCart");
	}
	
	@Test(priority=2)
	public void clickCart_AddedProducts_ShowedDetails() {
			
		
		}
	
	@Test(priority=3)
	public void clickCart_AddedProducts_Removed() {
		
	}
	
	@Test(priority=4)
	public void clickCart_ContinueShoppingButton_RedirectedToHomepage() {
		
	}
	
	@Test(priority=5)
	public void clickCart_CheckoutButton_OpenedCheckoutpage() {
			
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
