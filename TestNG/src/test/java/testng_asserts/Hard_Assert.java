package testng_asserts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//script to perform hard assert using testng assert class methods
public class Hard_Assert {

	static WebDriver driver;

	@Test
	public void testHardAssert() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHR";

		Assert.assertEquals(actualTitle, expectedTitle, "Assert Doesn't Pass");
		System.out.println("This line will not be executed if the assertion fails.");

		driver.quit();

	}
}
