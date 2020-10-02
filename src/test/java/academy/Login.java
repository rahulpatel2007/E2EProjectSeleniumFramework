package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.DriverClass;
import resources.HomeObjects;

public class Login extends DriverClass{
	
	public WebDriver driver;
	
	
	public static Logger log = LogManager.getLogger(AssertionExample.class.getName());
	
	@BeforeTest
	public void init() throws IOException {
		
		driver = initialiseDriver();
		
		log.info("driver initialised");
		
		driver.get(prop.getProperty("url"));
		
		log.info("url launched");
	}

	
	@Test()
	public void launchHome(){
		
		HomeObjects hObject = new HomeObjects(driver);
		
		hObject.getLoginElement().click();
		
		log.info("clicked on login");
				
	}
	

	
	@AfterTest
	public void destroy() {
		
		driver.close();
		
		log.info("driver closed.");
	}
}
