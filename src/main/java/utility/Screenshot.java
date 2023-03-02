package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("dd-mm-yyyy & hh-mm-ss");
		String realTime = time.format(customFormat);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("F:\\Selenium Screenshot\\" +name +realTime +".png");
		FileHandler.copy(source, destination);
		
	}
	

}
