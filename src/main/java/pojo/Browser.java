package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	static WebDriver driver;
	
	public static WebDriver openBrowser(String browser) {
		
		if(browser.equals("chrome"))
		{ WebDriverManager.chromedriver().setup();
		     ChromeOptions options = new ChromeOptions();
		     options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options); }
		
		else if(browser.equals("edge"))
		{ WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver(); }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		
		return driver;
	}

}
