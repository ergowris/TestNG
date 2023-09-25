package beforesuite_aftersuite_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//script for login&admin page using @BeforeSuite&@AfterSuite
public class BeforeSuite_AfterSuite_Annotation {

	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void cleanUp() {

		driver.quit();
	}
}
