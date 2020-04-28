package day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Loginpage;
import pages.Logoutpage;
import utility.BrowserFactory;

public class Loginscenario {
	Loginpage login;
	Logoutpage logout;
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getApplication("firefox");
		driver.get("https://pekantidinesh-trials6562.orangehrmlive.com/auth/login");
		login = PageFactory.initElements(driver, Loginpage.class);
		logout = PageFactory.initElements(driver, Logoutpage.class);
	}

	@Test(priority = 0)
	public void verifypage() {

		System.out.println(driver.getTitle());
	}

	@Test(priority = 1, dependsOnMethods = "verifypage")
	public void verifylogin() {
		login.beforelogin();
		login.logintoapplication("Admin", "0wFOY@ki9Z");
		login.afterlogin();
	}

	@Test(priority = 2, dependsOnMethods = "verifylogin",enabled=false)
	public void verifylogout() {

		logout.Logoutfromapplication();

	}
}
