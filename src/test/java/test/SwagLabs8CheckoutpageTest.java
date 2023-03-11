package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.SwagLabCheckoutStepOnePage;
import pom.SwagLabsCartPage;
import pom.SwagLabsLoginPage;
import pom.SwagLabsProductpage;
import utility.BaseClass;
import utility.ExtentReport;

public class SwagLabs8CheckoutpageTest extends BaseClass{
	
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
	}

	
	@Test(priority=2)
	public void clickCheckout_FirstnamePlaceholderText_Displayed() throws InterruptedException {
	
		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getFirstnamePlaceholderText();
		String expectedPlaceHolderText = "First Name";
		
		System.out.println("actualPlaceHolderText = "+actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = "+expectedPlaceHolderText);
		
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		test = reports.createTest("clickCheckout_FirstnamePlaceholderText_Displayed");
		Thread.sleep(100);
	}

	@Test(priority=2)
	public void clickCheckout_LastnamePlaceholderText_Displayed() throws InterruptedException {
	
		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getLastnamePlaceholderText();
		String expectedPlaceHolderText = "Last Name";
		
		System.out.println("actualPlaceHolderText = "+actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = "+expectedPlaceHolderText);
		
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		test = reports.createTest("clickCheckout_LastnamePlaceholderText_Displayed");
		Thread.sleep(100);
		
	}
	
	@Test(priority=2)
	public void clickCheckout_PincodePlaceholderText_Displayed() throws InterruptedException {
	
		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getLastnamePlaceholderText();
		String expectedPlaceHolderText = "Zip/Postal Code";
		
		System.out.println("actualPlaceHolderText = "+actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = "+expectedPlaceHolderText);
		
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		test = reports.createTest("clickCheckout_PincodePlaceholderText_Displayed");
		Thread.sleep(100);
		
	}
	

	@Test(priority=1)
	public void clickCheckout_InvalidFirstname_DisplayedErrorMSG() {
		
		
		
		
	}
	
	
	@Test(priority=2)
	public void clickCheckout_InvalidLastname_DisplayedErrorMSG() {
		
	}
	
	@Test(priority=3)
	public void clickCheckout_InvalidZipcode_DisplayedErrorMSG() {
		
	}

	@Test(priority=4)
	public void clickCheckout_1EmptyFirstN2EmptyLastN3EmptyZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=5)
	public void clickCheckout_1FillFirstN2EmptyLastN3EmptyZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=6)
	public void clickCheckout_1FillFirstN2FillLastN3EmptyZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=7)
	public void clickCheckout_1FillFirstN2FillLastN3FillZipcode_DisplayedWarningMSG() {
		
	}
	
	
	@Test(priority=8)
	public void clickCheckout_1EmptyFirstN2FillLastN3EmptyZipcode_DisplayedWarningMSG() {
		
	}
	
	
	
	@Test(priority=9)
	public void clickCheckout_1EmptyFirstN2FillLastN3FillZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=10)
	public void clickCheckout_1EmptyFirstN2EmptyLastN3FillZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=11)
	public void clickCheckout_1FillFirstN2EmptyLastN3FillZipcode_DisplayedWarningMSG() {
		
	}
	
	@Test(priority=12)
	public void clickCheckout_ContinueButton_RedirectedToCheckoutOverviewpage() {
		
	}
	
	@Test(priority=13)
	public void clickCheckout_CancelButton_RedirectedToCartpage() {
		
	}
}
