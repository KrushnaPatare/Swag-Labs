package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
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
	}

	
	
	
	
	@DataProvider (name = "LoginData")
	public Object[][] cre(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
		}
	@Test(priority=1)
	public void clickCheckout_InvalidFirstname_DisplayedErrorMSG() {
		
	}
	
	@DataProvider (name = "LoginData")
	public Object[][] cred(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
		}
	@Test(priority=2)
	public void clickCheckout_InvalidLastname_DisplayedErrorMSG() {
		
	}
	
	@DataProvider (name = "LoginData")
	public Object[][] cr(){
		return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
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
