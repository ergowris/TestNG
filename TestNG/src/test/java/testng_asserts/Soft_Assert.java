package testng_asserts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//script to perform soft assert
public class Soft_Assert {
	public WebDriver driver;

	@Test
	public void testSoftAssert() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHR";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle, "Title doesn't match");

		// This line will be executed even if the assertion fails.
		System.out.println("This line will be executed even if the assertion fails.");

		// At the end of the test, decide whether to pass or fail based on collected
		// failures.
		softAssert.assertAll();

		driver.quit();
	}
}
