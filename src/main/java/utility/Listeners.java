package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {
	

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started " +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed " +result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		try{
			Screenshot.takeScreenshot(driver, result.getName());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Test is failed " +result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped " +result.getName());
	}
	
	
	
	
	
	
	
	

}
