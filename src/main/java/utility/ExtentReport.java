package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports createExtentReports() {
		
		ExtentReports reports = new ExtentReports();
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports.html");
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("SwagLabs Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("SwagLabs Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");
		
	    reports.attachReporter(sparkReporter);
	    
	    reports.setSystemInfo("Application URL","https://www.saucedemo.com");
	    reports.setSystemInfo("Browser Name","Chrome");
	    reports.setSystemInfo("Operating System",System.getProperty("os.name"));
	    reports.setSystemInfo("Java Version",System.getProperty("java.version"));
		
	    
	    return reports;

	}

}
