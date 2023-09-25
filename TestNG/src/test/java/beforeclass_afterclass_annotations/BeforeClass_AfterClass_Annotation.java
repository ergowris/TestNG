package beforeclass_afterclass_annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//script to test admin & dashboard page using @BeforeClass & @AfterClass
public class BeforeClass_AfterClass_Annotation {

	WebDriver driver;

	@BeforeClass
	public void login() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys("admin123");

		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
	}

	@Test
	public void testDashboardPage() {

		System.out.println(driver.getCurrentUrl());
		WebElement dashboard = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		dashboard.click();

	}

	@Test
	public void testAdminPage() {

		System.out.println(driver.getCurrentUrl());
		WebElement admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		admin.click();

		WebElement add_User = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_User.click();

	}

	@AfterClass
	public void logout() {
		WebElement user_id = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		user_id.click();

		WebElement logout = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]"));
		logout.click();
		driver.quit();
	}
}
