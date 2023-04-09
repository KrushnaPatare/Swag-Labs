package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;
	
	
	public void onStart(ITestContext context) {
		
		reports = ExtentReport.createExtentReports();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started " +result.getName());
		test = reports.createTest(result.getName(),"This is the description of Test.\n "
				+ "You can write any information related to Test here.");
		test.assignAuthor("Krushna Patare");
		test.assignCategory("Homepage","Regression");
		test.assignDevice("windows 10-Chrome");
		test.log(Status.INFO,result.getName()+" started executing");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed " +result.getName());
		test.log(Status.PASS,result.getName()+" got successfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		String screenshotDestinationPath=null;
		try{
			screenshotDestinationPath = Screenshot.takeScreenshot(driver, result.getName());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Test is failed " +result.getName());
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.FAIL,result.getName()+" got failed");
		test.addScreenCaptureFromPath(screenshotDestinationPath);
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped " +result.getName());
		test.log(Status.INFO,result.getThrowable());
		test.log(Status.SKIP, result.getName()+" got skipped");
	}
	
	public void onFinish(ITestContext context) {
		
		reports.flush();
		String extentReportPath = "F:\\WorkSpace\\SwagLabs\\extentreports.html";
		File extentReportCopy = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(extentReportCopy.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
