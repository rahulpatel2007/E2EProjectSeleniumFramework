package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	private WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By username = By.cssSelector("#user_email");
	
	By password = By.cssSelector("#user_password");
	
	By login = By.cssSelector("#hero > div > form > div.form-group.text-center > input");
	
	public WebElement getUsername() {
		
		return driver.findElement(username);
		
	}
	
	public WebElement getPassword() {
		
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		
		return driver.findElement(login);
	}

}
