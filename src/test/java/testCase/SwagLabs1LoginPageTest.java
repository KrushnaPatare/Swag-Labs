package testCase;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.swagLabs.pojo.BaseClass;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs1LoginPageTest extends BaseClass {

	@Test
	public void checkLoginFunctionality(String user, String pass) throws InterruptedException, IOException {

		swagLabsLoginPage.enterUsername(user);
		swagLabsLoginPage.enterPassword(pass);
		
		String screenshotDestinationPath = screenshot.takeScreenshot(driver, "swagLabsLoginPage");
		listners.test.info("Username entered./nPassword entered.", MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotDestinationPath).build());
 
		swagLabsLoginPage.clickOnLogin();
		
		String screenshotDestinationPath1 = screenshot.takeScreenshot(driver, "swagLabsLoginPage");
		listners.test.info("Username entered./nPassword entered.", MediaEntityBuilder
				.createScreenCaptureFromPath(screenshotDestinationPath1).build());
 

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		System.out.println("actualUrl = " + actualUrl);

		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
}
