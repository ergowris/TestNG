package testng_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

//script to test authentication groups using @BeforeGroups & @AfterGroups 
public class BeforeGroups_AfterGroups_Annotation {

	static WebDriver driver;

	@BeforeGroups("authentication")
	public void setupAuthentication() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);

	}

	@Test(groups = "authentication")
	public void testValidLogin() throws InterruptedException {

		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
		Thread.sleep(2000);
	}

	@Test(groups = "authentication")
	public void testInvalidLogin() throws InterruptedException {

		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys("admin13");
		Thread.sleep(2000);
		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
		Thread.sleep(2000);

	}

	@AfterGroups("authentication")
	public void teardownAuthentication() {

		driver.quit();
	}

	@Test
	public void testDashboard() throws InterruptedException {
		WebElement dashboard = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		dashboard.click();
		Thread.sleep(2000);

	}
}
