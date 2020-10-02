package academy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.DriverClass;
import resources.ExtentReporterNG;

public class Listeners extends DriverClass implements ITestListener {
	
	ExtentReports extent = ExtentReporterNG.getReporter();

	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());
		
		extentTest.set(test);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		//System.out.println("test sucess.");
		
		extentTest.get().log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		extentTest.get().fail(result.getThrowable());
		
		String methodName = result.getMethod().getMethodName();
		
	//	System.out.println(methodName);
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("onTestFailure executed.");
		
		extentTest.get().addScreenCaptureFromPath(getScreenshot(methodName, driver), result.getMethod().getMethodName());
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		extent.flush();
	}
	
	

}
