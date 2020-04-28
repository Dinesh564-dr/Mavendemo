package Day10;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
public class Assignment1testng{



	public WebDriver driver;
	
	
	String username="TeamCity"+System.currentTimeMillis();
	String password="TeamCity"+System.currentTimeMillis();
	
	@BeforeClass
	public  void startSession()
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\\\dinesh kumar reddy\\\\eclipse\\\\selenium\\\\driver\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void stopSession()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyTitle()
	{
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Title Verification Failed");	
	}
	
	@Test(priority=2)
	public void verifySocialLinks()
	{
		List<String> expectedLinks=new ArrayList<String>();
		expectedLinks.add("http://www.linkedin.com/groups?home=&gid=891077");
		expectedLinks.add("http://www.facebook.com/OrangeHRM");
		expectedLinks.add("http://twitter.com/orangehrm");
		expectedLinks.add("http://www.youtube.com/orangehrm");
		
		List<String> actualList = new ArrayList<String>();
		
		List<WebElement> SocialMedia =driver.findElements(By.xpath("//div[@id='social-icons']//a"));
		
		for(WebElement element:SocialMedia)
		{
				actualList.add(element.getAttribute("href"));	
		}
		Assert.assertEquals(actualList, expectedLinks);
	}
	
	@Test(priority=3)
	public void loginToApplication()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
 		driver.findElement(By.id("txtPassword")).sendKeys("VQl3e1Cm@I");
 		driver.findElement(By.id("btnLogin")).click();	
 		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Admin']")).isDisplayed(),"Admin Tab is not displayed");
	}
	
	@Test(priority=4)
	public void createUser() throws InterruptedException
	{
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']"))).click();
 		
		WebDriverWait wait = new WebDriverWait(driver, 20);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']"))).click();
 		
 		WebDriverWait wait6 = new WebDriverWait(driver, 20);
 		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Add']"))).click();
		
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Add']"))).click();
 		
 		new Select(driver.findElement(By.xpath("//*[contains(text(),'User Role')]//following::select[1]"))).selectByVisibleText("Admin");
 		
 		driver.findElement(By.xpath("//*[contains(text(),'Employee Name')]//following::input[1]")).sendKeys("Jasmine Morgan");
 		
 		driver.findElement(By.xpath("//*[contains(text(),'Username')]//following::input[1]")).sendKeys(username);
 		
 		driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys(password);
 		
 		driver.findElement(By.xpath("//*[text()='Confirm Password']//following::input[1]")).sendKeys(password); 		
 		
 		Thread.sleep(1000);
 		
 		driver.findElement(By.xpath("//input[@value='Save']")).click();
 		
 		WebDriverWait wait8 = new WebDriverWait(driver, 20);
 		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully Saved')]")));
	}
	
	@Test(priority=5)
	public void searchNewlyCreatedUser() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[contains(@id,'searchSystemUser')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		//Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']//a[text()='\"+username+\"']")));
		
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']//a[text()='"+username+"']")));
	}
	
	@Test(priority=6)
	public void logOutFromUser()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Logout is not working as expected");
		
	}
	
	@Test(priority=7)
	public void loginToApplicationNewUser()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys(username);
 		driver.findElement(By.id("txtPassword")).sendKeys(password);
 		driver.findElement(By.id("btnLogin")).click();	
 		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Admin']")).isDisplayed(),"Admin Tab is not displayed");
	}
	@Test(priority=8)
	public void logOutFromNewUser()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		driver.findElement(By.linkText("Logout")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Logout is not working as expected");
		
	}
	
	@Test(priority=9)
	public void loginToApplicationAdmin()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
 		driver.findElement(By.id("txtPassword")).sendKeys("VQl3e1Cm@I");
 		driver.findElement(By.id("btnLogin")).click();	
 		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Admin']")).isDisplayed(),"Admin Tab is not displayed");
	} 
	
	@Test(priority=10)
	public void deleteUser() throws InterruptedException
	{
		
		//Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']"))).click();
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']"))).click();
		
 		WebDriverWait wait2 = new WebDriverWait(driver, 20);
 		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'searchSystemUser')]"))).sendKeys(username);	
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'searchSystemUser')]"))).sendKeys(username);	
 		driver.findElement(By.xpath("//input[@value='Search']")).click();
 		Thread.sleep(2000);
 		
 		WebDriverWait wait3 = new WebDriverWait(driver, 20);
 		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']//a[text()='"+username+"']//preceding::input[1]"))).click();	
 		
 		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']//a[text()='"+username+"']//preceding::input[1]"))).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		

//		Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
//				.ignoring(Exception.class)
//		 		.until(ExpectedConditions
//		 		.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully Deleted ')]"))).isDisplayed());
		
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
 		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successfully Deleted ')]"))).isDisplayed();
		
	}
	
	@Test(priority=11)
	public void logOutAferLogin()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		driver.findElement(By.linkText("Logout")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"),"Logout is not working as expected");
		
	}

}
		
	

	


