package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabCheckoutStepOnePage;
import pom.SwagLabsCartPage;
import pom.SwagLabsCheckoutComplete;
import pom.SwagLabsCheckoutStepTwoPage;
import pom.SwagLabsLoginPage;
import pom.SwagLabsProductpage;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Parameterization;

public class SwagLabs7CheckoutCompletepage extends BaseClass{
	
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
	public void launchBrowser(String browser) throws EncryptedDocumentException, IOException {
		

		 driver = Browser.openBrowser(browser);
		 SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		 swagLabsLoginPage.enterUsername("standard_user");
		 swagLabsLoginPage.enterPassword("secret_sauce");
		 swagLabsLoginPage.clickOnLogin();
		 SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage (driver);
		 swagLabsProductpage.clickProductImage();
		 swagLabsProductpage.clickOnAddToCartButton();
		 swagLabsProductpage.clickOnCartButton();
		 SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		 swagLabsCartPage.clickOnCheckoutButton();
			SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
			String fName = Parameterization.getExelData("checkout",0,0);
			String lName = Parameterization.getExelData("checkout",1,0);
			String pCode = Parameterization.getExelData("checkout",2,0);
			
			swagLabCheckoutStepOnePage.enterFirstname(fName);
			swagLabCheckoutStepOnePage.enterLastname(lName);
			swagLabCheckoutStepOnePage.enterPincode(pCode);
			swagLabCheckoutStepOnePage.clickContinueButton();
			SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
			swagLabsCheckoutStepTwoPage.clickOnfinishButton();
	}

	@Test(priority=1)
	public void openCheckoutComplete_GreetInformation_Displyed() throws InterruptedException {
		
		SwagLabsCheckoutComplete swagLabsCheckoutComplete = new SwagLabsCheckoutComplete(driver);
		String actualGreetText = swagLabsCheckoutComplete.getGreetInformation();
		String expectedGreetText = "Thank you for your order!\n"
				+ "Your order has been dispatched, and will arrive just as fast as the pony can get there!\n"
				+ "Back Home";
		
		System.out.println("actualGreetText = "+actualGreetText);
		System.out.println("expectedGreetText = "+expectedGreetText);
		
		Assert.assertEquals(expectedGreetText, actualGreetText);
		test = reports.createTest("openCheckoutComplete_GreetInformation_Displyed");
		Thread.sleep(100);
	}
	
	@Test(priority=2)
	public void openCheckoutComplete_BackToHomeButton_RedirectedToProductpage() throws InterruptedException {
		
		SwagLabsCheckoutComplete swagLabsCheckoutComplete = new SwagLabsCheckoutComplete(driver);
		swagLabsCheckoutComplete.clickOnBackToHomeButton();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		
		System.out.println("actualUrl = "+actualUrl);
		System.out.println("expectedUrl = "+expectedUrl);
		
		Assert.assertEquals(expectedUrl, actualUrl);
		test = reports.createTest("openCheckoutComplete_BackToHomeButton_RedirectedToProductpage");
		Thread.sleep(100);
	}
	
	

	@AfterMethod
	public void publishResult (ITestResult result ) {
		
		if(result.getStatus()==ITestResult.SUCCESS)
	    {test.log(Status.PASS,result.getName());}
	    
		else if(result.getStatus()==ITestResult.FAILURE) 
		{test.log(Status.FAIL, result.getName());}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{test.log(Status.SKIP, result.getName());}
		
		driver.close();
	}

	@AfterTest
	public void createReport()
	{reports.flush();}
		

}
