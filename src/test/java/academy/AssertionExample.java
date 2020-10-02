package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.DriverClass;
import resources.HomeObjects;

public class AssertionExample extends DriverClass {
	
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(AssertionExample.class.getName());
	
	@BeforeTest
	public void init() throws IOException {
		
		driver = initialiseDriver();
		
		log.info("driver initialised.");
		
		driver.get(prop.getProperty("url"));
		
		log.info("url launched");
	}
	
	@Test
	public void checkText() {
		
		HomeObjects hObjects = new HomeObjects(driver);
		
		Assert.assertEquals(hObjects.getText().getText(),"FEATURED COURSES12");
		
		log.info("text checked");
		
		Assert.assertTrue(hObjects.getContact().isDisplayed());
		
		log.info("displayed check");
	}
	
	@AfterTest
	public void destroy() {
		
		driver.close();
		
		log.info("driver closed.");
	}

}
