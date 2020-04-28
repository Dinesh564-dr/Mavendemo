package Day10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Spicejet {
	WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\\\dinesh kumar reddy\\\\eclipse\\\\selenium\\\\driver\\\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.navigate().to("https://www.spicejet.com/");
}
	@Test
	public void setup() throws InterruptedException {
		driver.findElement(By.xpath("//li[@class='book_flight']//span[@class='text-label']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='tblTrip']//input[@value='RoundTrip']")).click();
		
		String date="march 2019";
		String month="marh";
		String year="2019";
		String day="20";

		
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a[day]")).click();
		
	}
	@AfterMethod
	public void teardown() {
		//driver.close();
	}
}