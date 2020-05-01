package Day10;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment3 {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.navigate().to("https://www.phptravels.net/index.php");
		

		driver.findElement(
				By.xpath("//div[contains(@class, 'dropdown dropdown-login dropdown-tab')]/a[@id='dropdownCurrency']"))
				.click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

		// login
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
		System.out.println(driver.getCurrentUrl());


	}
}
