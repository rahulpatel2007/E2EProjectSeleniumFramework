package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		
		String path = System.getProperty("user.dir")+"\\reports\\report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("framework report");
		
		reporter.config().setDocumentTitle("report");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("tester", "rahul patel");
		
		return extent;
		
	}

}
