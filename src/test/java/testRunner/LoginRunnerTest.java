package testRunner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.utilities.DataProviders;

import testCase.SwagLabs1LoginPageTest;

//@Listeners(com.swagLabs.utilities.Listeners.class)
public class LoginRunnerTest extends BaseClass {
	
	public static SwagLabs1LoginPageTest swagLabs1LoginPageTest;
	
	@BeforeMethod()
	@Parameters({"browser"})
	public void setUp(String browser) 
	{
		BaseClass.openBrowser(browser);
		 swagLabs1LoginPageTest = new SwagLabs1LoginPageTest();
	}
	
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void TC01(String testCaseName, String user, String pass, ITestContext context) throws InterruptedException, IOException
	{
		
		System.out.println(testCaseName);
		System.out.println(user);
		System.out.println(pass);
		
		context.setAttribute("addingTestCaseName", testCaseName);;
		swagLabs1LoginPageTest.checkLoginFunctionality(user, pass);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		BaseClass.logout();
	}
	

}
