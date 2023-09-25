package beforetest_aftertest_annotations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

//script to test loginpage using valid&invalid details using @BeforeTest&@AfterTest
public class BeforeTest_AfterTest_Annotation {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
