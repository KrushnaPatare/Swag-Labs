package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Parameterization;

@Listeners(utility.Listeners.class)
public class SwagLabs1LoginTest extends BaseClass {
	

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
		public Object[][] cred(){
			return new Object[][] {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
			}
	
	@Test(priority=1,dataProvider = "LoginData")
	public void doLogin_1ValidId2ValidPwd_OpenedHomepage(String user, String pass) throws InterruptedException{
	
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		System.out.println("username = " +user );
	    System.out.println("password = " +pass );
		swagLabsLoginPage.enterUsername(user);
	    swagLabsLoginPage.enterPassword(pass);
		swagLabsLoginPage.clickOnLogin();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		System.out.println("actualUrl = " +actualUrl );
	    System.out.println("expectedUrl = " +expectedUrl );
		Assert.assertEquals( actualUrl, expectedUrl );
		
		test = reports.createTest("public void doLogin_1ValidId2ValidPwd_OpenedHomepage");
		Thread.sleep(100);
	}
	
	@Test(priority=2 )
	public void doLogin_1ValidId2InvalidPwd_FailedLoginAndVerifyErrorMSG() throws InterruptedException, EncryptedDocumentException, IOException {
		
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = Parameterization.getExelData("credentials",0,1);
       String pass = Parameterization.getExelData("credentials",1,1);
       System.out.println("username = " +user );
	   System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedErrorMSG = "Epic sadface: Username and password do not match any user in this service"; 
		String actualErrorMSG = swagLabsLoginPage.getErrorMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		
		   System.out.println("actualUrl = " +actualUrl );
		   System.out.println("expectedUrl = " +expectedUrl );
	       System.out.println("expectedErrorMSG = " +expectedErrorMSG );
	       System.out.println("actualErrorMSG = " +actualErrorMSG );
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedErrorMSG,actualErrorMSG  );
		softAssert.assertAll();
		Assert.assertEquals( actualUrl, expectedUrl);
		
		test = reports.createTest("doLogin_1ValidId2InvalidPwd_FailedLoginAndVerifyErrorMSG"  );
		Thread.sleep(100);
	}

	@Test(priority=3)
	public void doLogin_1InvalidId2validPwd_FailedLoginAndVerifyErrorMSG() throws InterruptedException, EncryptedDocumentException, IOException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = Parameterization.getExelData("credentials",0,2 );
       String pass = Parameterization.getExelData("credentials",1,2 );
       System.out.println("username = " +user );
	   System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedErrorMSG = "Epic sadface: Username and password do not match any user in this service"; 
		String actualErrorMSG = swagLabsLoginPage.getErrorMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		
		   System.out.println("actualUrl = " +actualUrl );
		   System.out.println("expectedUrl = " +expectedUrl );
	       System.out.println("expectedErrorMSG = " +expectedErrorMSG );
	       System.out.println("actualErrorMSG = " +actualErrorMSG );
	      
	    SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedErrorMSG,actualErrorMSG  );
		softAssert.assertAll();
		Assert.assertEquals( actualUrl, expectedUrl);
		
		test = reports.createTest("doLogin_1InvalidId2validPwd_FailedLoginAndVerifyErrorMSG"  );
		Thread.sleep(100);
	}
	
	@Test(priority=4)
	public void doLogin_1InvalidId2InvalidPwd_FailedLoginAndVerifyErrorMSG() throws InterruptedException, EncryptedDocumentException, IOException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = Parameterization.getExelData("credentials",0,3 );
       String pass = Parameterization.getExelData("credentials",1,3 );
       System.out.println("username = " +user );
	   System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedErrorMSG = "Epic sadface: Username and password do not match any user in this service"; 
		String actualErrorMSG = swagLabsLoginPage.getErrorMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		
		   System.out.println("actualUrl = " +actualUrl );
		   System.out.println("expectedUrl = " +expectedUrl );
	       System.out.println("expectedErrorMSG = " +expectedErrorMSG );
	       System.out.println("actualErrorMSG = " +actualErrorMSG );
	      
	    SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedErrorMSG,actualErrorMSG  );
		softAssert.assertAll();
		Assert.assertEquals( actualUrl, expectedUrl);
		
		test = reports.createTest("doLogin_1InvalidId2InvalidPwd_FailedLoginAndVerifyErrorMSG"  );
		Thread.sleep(100);
	}
	
	@Test(priority=5)
	public void doLogin_1EmptyId2GivenPwd_FailedLoginAndVerifyWarningMSG() throws InterruptedException, EncryptedDocumentException, IOException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
	
	   String user ="";
       String pass = Parameterization.getExelData("credentials",1,4 );
       System.out.println("username = " +user );
	   System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedWarningMSG = "Epic sadface: Username is required"; 
		String actualWarningMSG = swagLabsLoginPage.getWarningMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		
		   System.out.println("actualUrl = " +actualUrl );
		   System.out.println("expectedUrl = " +expectedUrl );
		   System.out.println("expectedWarningMSG = " +expectedWarningMSG );
	       System.out.println("actualWarningMSG = " +actualWarningMSG );
	       
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedWarningMSG,actualWarningMSG  );
		softAssert.assertAll();
		Assert.assertNotEquals(actualUrl, expectedUrl );
		
		test = reports.createTest("doLogin_1EmptyId2GivenPwd_FailedLoginAndVerifyWarningMSG"  );
		Thread.sleep(100);
	}
	
	@Test(priority=6)
	public void doLogin_1EmptyPwd2GivenId_FailedLoginAndVerifyWarningMSG() throws InterruptedException, EncryptedDocumentException, IOException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = Parameterization.getExelData("credentials",0,5);
       String pass="";
       System.out.println("username = " +user );
	   System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedWarningMSG = "Epic sadface: Password is required"; 
		String actualWarningMSG = swagLabsLoginPage.getWarningMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		
		   System.out.println("actualUrl = " +actualUrl );
		   System.out.println("expectedUrl = " +expectedUrl );
		   System.out.println("expectedWarningMSG = " +expectedWarningMSG );
	       System.out.println("actualWarningMSG = " +actualWarningMSG );
	       
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedWarningMSG,actualWarningMSG  );
		softAssert.assertAll();
		Assert.assertNotEquals(actualUrl, expectedUrl );
		
		test = reports.createTest("doLogin_1EmptyPwd2GivenId_FailedLoginAndVerifyWarningMSG"  );
		Thread.sleep(100);
	}
	
	@Test(priority=7)
	public void doLogin_1EmptyId2EmptyPwd_FailedLoginAndVerifyWarningMSG() throws InterruptedException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = "";
       String pass = "";
       System.out.println("no usename given" );
       System.out.println("no password given" );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String expectedWarningMSG = "Epic sadface: Username is required"; 
		String actualWarningMSG = swagLabsLoginPage.getWarningMSG();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		
		System.out.println("actualUrl = " +actualUrl );
	    System.out.println("expectedUrl = " +expectedUrl );
		System.out.println("expectedWarningMSG = " +expectedWarningMSG );
	    System.out.println("actualWarningMSG = " +actualWarningMSG );
			
		    
			Assert.assertEquals(actualUrl, expectedUrl );
			
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals( expectedWarningMSG,actualWarningMSG  );
		softAssert.assertAll();
		Assert.assertEquals(actualUrl, expectedUrl );
		
		test = reports.createTest("doLogin_1EmptyId2EmptyPwd_FailedLoginAndVerifyWarningMSG"  );
		Thread.sleep(100);	
	}
	
	@Test(priority=8)
	public void doLogin_Clickable_CompletedLogin() throws InterruptedException, EncryptedDocumentException, IOException {
	SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);

       String user = Parameterization.getExelData("credentials",0,0);
       String pass = Parameterization.getExelData("credentials",1,0);
       System.out.println("username = " +user );
	    System.out.println("password = " +pass );

		swagLabsLoginPage.enterUsername(user );
	    swagLabsLoginPage.enterPassword(pass );
		swagLabsLoginPage.clickOnLogin();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualUrl, expectedUrl );
		
		test = reports.createTest("doLogin_Clickable_CompletedLogin"  );
		Thread.sleep(100);	
	}
	
	@Test(priority=9)
	public void doLogin_SwagLabsLogo_DisplayedLogoAndVerifyText() throws InterruptedException {
		
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		
		String expectedImgText ="Swag Labs";
		String actualImgText = swagLabsLoginPage.getLogoText();
		boolean expectedLogoIMG = true;
		boolean actualLogoIMG = swagLabsLoginPage.showLogo();
		
	       System.out.println("expectedImgText = " +expectedImgText );
	       System.out.println("actualImgText = " +actualImgText );
		   System.out.println("expectedLogoIMG = " +expectedLogoIMG );
		   System.out.println("actualLogoIMG = " +actualLogoIMG );
		    
		   SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals( expectedImgText,actualImgText  );
			softAssert.assertAll();
			Assert.assertEquals(expectedLogoIMG, actualLogoIMG ); 
	
		    test = reports.createTest("doLogin_SwagLabsLogo_DisplayedLogoAndVerifyText"  );
			Thread.sleep(100);
	}

	@Test(priority=10)
	public void doLogin_ErrorBoxCancelButton_ClosedErrorOrWarningMSG() throws InterruptedException, EncryptedDocumentException, IOException {
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		
	       String userN = "";
	       String passW = "";
	       System.out.println("no usename given" );
	       System.out.println("no password given" );

			swagLabsLoginPage.enterUsername(userN );
		    swagLabsLoginPage.enterPassword(passW );
			swagLabsLoginPage.clickOnLogin();
			swagLabsLoginPage.clickErrorOrWarningBoxCancelButton();
			
			boolean warningMSG = false;
		
			 try {
					driver.findElement(By.xpath("//h3[@data-test='error']"));
				 }
			catch(NoSuchElementException e)
			     {
					warningMSG = true;
					System.out.println("NoSuchElementException");
			     }
			System.out.println("warningMSG = "+warningMSG);
			System.out.println("NoSuchElementException");
			
			Assert.assertTrue(warningMSG);
			
			
			
		       String user = Parameterization.getExelData("credentials",0,1);
		       String pass = Parameterization.getExelData("credentials",1,1);
		       System.out.println("username = " +user );
			   System.out.println("password = " +pass );

				swagLabsLoginPage.enterUsername(user );
			    swagLabsLoginPage.enterPassword(pass );
				swagLabsLoginPage.clickOnLogin();
				swagLabsLoginPage.clickErrorOrWarningBoxCancelButton();
				
				boolean errorMSG = false;
				try {
					driver.findElement(By.xpath("//h3[@data-test='error']"));
				    }
			  catch(NoSuchElementException d)
			        {
					errorMSG = true;
					System.out.println("NoSuchElementException");
			        }
				System.out.println("errorMSG = "+errorMSG);
				System.out.println("NoSuchElementException");
				
				Assert.assertTrue(errorMSG);
		
		 test = reports.createTest("doLogin_ErrorBoxCancelButton_ClosedErrorOrWarningMSG"  );
			Thread.sleep(100);
	}

	@Test(priority=11)
	public void doLogin_PlaceHolderText_Displayed() throws InterruptedException {
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		String expectedUsernamePlaceHolderText = "Username";
		String actualUsernamePlaceHolderText = swagLabsLoginPage.getusernamePlaceHolderText();
		String expectedPasswordPlaceHolderText = "Password";
		String actualPasswordPlaceHolderText = swagLabsLoginPage.getpasswordPlaceHolderText();
		
		System.out.println("expectedUsernamePlaceHolderText = "+expectedUsernamePlaceHolderText);
		System.out.println("actualUsernamePlaceHolderText = "+actualUsernamePlaceHolderText);
		System.out.println("expectedPasswordPlaceHolderText = "+expectedPasswordPlaceHolderText);
		System.out.println("expectedPasswordPlaceHolderText = "+actualPasswordPlaceHolderText);
		
		Assert.assertEquals(expectedUsernamePlaceHolderText, actualUsernamePlaceHolderText);
		Assert.assertEquals(expectedPasswordPlaceHolderText,actualPasswordPlaceHolderText);
		
		test = reports.createTest("doLogin_PlaceHolderText_Displayed"  );
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


