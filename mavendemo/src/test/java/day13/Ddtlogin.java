package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.BrowserFactory;

public class Ddtlogin {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.getApplication("firefox");
		driver.get("https://pekantidinesh-trials6562.orangehrmlive.com/auth/login");
	}

	@Parameters({ "username", "password" })
	@Test(dataProvider = "login")
	public void readdata(String user, String pass) {

		driver.findElement(By.id("txtUsername")).sendKeys(user);

		driver.findElement(By.id("txtPassword")).sendKeys(pass);

		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "login")
	public Object[][] setdata() {
		Object arr[][] = new Object[2][2];
		arr[0][0] = "Admin";
		arr[0][1] = "0wFOY@ki9Z";

		arr[1][0] = "ramesh";
		arr[1][1] = "Suresh2564";

		return arr;

	}
}
