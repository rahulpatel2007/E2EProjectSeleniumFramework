package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.DriverClass;
import resources.HomeObjects;
import resources.LoginPageObjects;

public class Home extends DriverClass {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Home.class.getName());

	@BeforeTest
	public void init() throws IOException {

		driver = initialiseDriver();
		
		log.info("driver initialised.");

		driver.get(prop.getProperty("url"));
		
		log.info("url launched");

		HomeObjects hObject = new HomeObjects(driver);

		hObject.getLoginElement().click();

	}

	@Test(dataProvider = "data")
	public void launchHome(String username, String password) {

		LoginPageObjects lObject = new LoginPageObjects(driver);

		lObject.getUsername().sendKeys(username);

		lObject.getPassword().sendKeys(password);

		lObject.getLogin().click();
		
		log.info("username and password entered.");

	}

	@DataProvider
	public Object[][] data() {

		Object[][] data = new Object[2][2];

		data[0][0] = "dataprovider123@gmail.com";

		data[0][1] = "12345678";

		data[1][0] = "restricteduser@gmail.com";

		data[1][1] = "12345678";

		return data;
	}

	@AfterTest
	public void destroy() {

		 driver.close();
		 
		 log.info("driver closed.");
	}
}
