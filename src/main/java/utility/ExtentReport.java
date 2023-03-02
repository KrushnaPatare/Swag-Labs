package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports createExtentReports() {
		
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports.html");
	    reports.attachReporter(sparkReporter);
	    return reports;

	}

}
