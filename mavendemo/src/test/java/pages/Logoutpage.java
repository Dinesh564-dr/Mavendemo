package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logoutpage {
	WebDriver driver;

	public Logoutpage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	By admintxt = By.xpath("//*[@id=\\\"account-job\\\"]/i");
	By logout = By.xpath("//*[@id=\\\"logoutLink\\\"]");

	public void Logoutfromapplication() {
		driver.findElement(admintxt).click();
		driver.findElement(logout).click();
	}

}
