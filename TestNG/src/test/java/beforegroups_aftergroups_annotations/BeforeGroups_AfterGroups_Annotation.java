package beforegroups_aftergroups_annotations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

//script to test authentication groups using @BeforeGroups & @AfterGroups 
public class BeforeGroups_AfterGroups_Annotation {

	static WebDriver driver;

	@BeforeGroups(groups = { "authentication" })
	public void setupAuthentication() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterGroups(groups = { "authentication" })
	public void teardownAuthentication() {

		driver.quit();
	}

}
