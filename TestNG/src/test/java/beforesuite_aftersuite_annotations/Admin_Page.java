package beforesuite_aftersuite_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Admin_Page extends BeforeSuite_AfterSuite_Annotation {

	@Test
	public void testAdminPage() {

		WebElement admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		admin.click();

		WebElement add_User = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_User.click();

		System.out.println(driver.getCurrentUrl());

	}

}
