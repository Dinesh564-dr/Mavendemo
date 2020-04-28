package Day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Helloworld {
	
	@Test(priority=1,description="this will start the application")
	public void setup() {
	String str="dinesh";
	String str1="dinesh";
	Assert.assertEquals(str, str1,"both are equal");
	}
	@Test(priority=2)
	public void geturl() {
		String str="dinesh";
		String str1="kumar";
		Assert.assertNotEquals(str, str1,"both are not equal");
	}
	@Test(priority=3)
	public void gettitle() {
		String str="dinesh";
		String str1="dinesh";
		if (str.equalsIgnoreCase(str1)) {
			Assert.assertTrue(true);
		}

	}
	@Test(priority=4)
	public void teardown() {
		String str="dinesh";
		String str1="reddy";
		if (str.equals(str1)) {
			Assert.assertFalse(true);
		}
	}
}
