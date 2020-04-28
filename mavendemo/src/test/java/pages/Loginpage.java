package pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Loginpage {
	WebDriver driver;

	public Loginpage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "txtUsername")
	WebElement user;

	@FindBy(id = "txtPassword")
	WebElement pass;

	@FindBy(id = "btnLogin")
	WebElement login;

	public void getwindowhandles() {
		/*
		 * Set<String> allwindows=driver.getWindowHandles();
		 * System.out.println(allwindows.size()+"no of windows"); ArrayList<String> tabs
		 * =new ArrayList(allwindows); driver.switchTo().window(tabs.get(2));
		 * driver.close(); driver.switchTo().window(tabs.get(1)); driver.close();
		 * //driver.switchTo().window(tabs.get(0)); //driver.close();
		 * 
		 */}
	 public void beforelogin() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("login"),"user is on login page"); }
	 

	public void logintoapplication(String username, String password) {

		user.sendKeys(username);
		pass.sendKeys(password);
		login.click();
	}
	 public void afterlogin() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard") ,"user is on home page"); }
	 
}