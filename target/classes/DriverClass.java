package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverClass {
	
	public WebDriver driver;
	
	public Properties prop;

	public WebDriver initialiseDriver() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fin = new FileInputStream("F:\\selenium\\first\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fin);
		
		//String driverName = prop.getProperty("driver");
		
		String driverName = System.getProperty("browser");
		
		System.out.println("Driver is: " +driverName);
		
		if(driverName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			
			driver = new ChromeDriver();
			
	
		}
		
		else if(driverName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.geko.driver", "");
			
			driver = new FirefoxDriver();
		}
		
		else if(driverName.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "");
			
			driver = new InternetExplorerDriver();
		}
		
		else {
			
			System.out.println("Please select a valid driver.");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public String getScreenshot(String methodName, WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		String fileDestination = System.getProperty("user.dir") + "\\reports\\" + methodName + ".png";
		
		try {
			FileUtils.copyFile(file, new File(fileDestination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileDestination;
	}
}
