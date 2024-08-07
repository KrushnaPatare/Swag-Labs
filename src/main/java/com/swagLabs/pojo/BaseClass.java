package com.swagLabs.pojo;

import com.swagLabs.pom.*;
import com.swagLabs.utilities.Listeners;
import com.swagLabs.utilities.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass  
{

	public static WebDriver driver;
	
	public static SwagLabsLoginPage swagLabsLoginPage ;
	public static SwagLabsHomepage swagLabsHomepage;
	public static SwagLabsProductpage swagLabsProductpage;
	public static SwagLabsCartPage swagLabsCartPage;
	public static SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage;
	public static SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage;
	public static SwagLabsCheckoutComplete swagLabsCheckoutComplete;
	
	public static Listeners listners;
	public static Screenshot screenshot;

	@Parameters({"browser"})
	public static WebDriver openBrowser(String browser)
	{

		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");

	
		
		swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsHomepage = new SwagLabsHomepage(driver);
		swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
		swagLabsCheckoutComplete = new SwagLabsCheckoutComplete(driver);
		
		listners = new Listeners();
		screenshot = new Screenshot();
		
		
		 return driver;
		
	}
	
	
	public static void login(String browser, String username, String password) 
	{
		BaseClass.openBrowser(browser);
		swagLabsLoginPage.enterUsername(username);
		swagLabsLoginPage.enterPassword(password);
		swagLabsLoginPage.clickOnLogin();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static void logout() 
	{
		swagLabsHomepage.clickOnAllItemsButton();
		swagLabsHomepage.clickOnlogoutButton();
	}

}
