package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeObjects {
	
	private WebDriver driver;
	
	By login = By.cssSelector("#homepage > header > div.tools > div > nav > ul > li:nth-child(4) > a > span");
	
	By text = By.cssSelector("#content > div > div > h2");
	
	By contact = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul > li:nth-child(8) > a");
	
	
	
	public HomeObjects(WebDriver driver){
		
		this.driver=driver;
	}
	
	public WebElement getLoginElement() {
		
		return driver.findElement(login);
	}
	
	public WebElement getText() {
		
		return driver.findElement(text);
	}
	
public WebElement getContact() {
		
		return driver.findElement(contact);
	}

}
