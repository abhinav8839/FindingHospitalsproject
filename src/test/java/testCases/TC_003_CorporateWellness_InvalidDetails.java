package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.CorporateWellnessPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_003_CorporateWellness_InvalidDetails extends BaseClass {

	@Test(priority = 1)
	public void checkingInvalidDetails() throws IOException, InterruptedException {
		logger.info("Staring TC_003_CorporateWellness_InvalidDetails");
		HomePage hp = new HomePage(driver);
		logger.info("opening booking page");
		hp.getForCorporates();
		hp.getWellnessPlans();

		CorporateWellnessPage cw = new CorporateWellnessPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		logger.info("putting in invalid details");
		js.executeScript("window.scrollBy(0, 100)");
		cw.setName();
		cw.setOrganizationName();
		cw.setContactNumber();
		cw.setEmail().sendKeys("test");
		logger.debug("checking if button is enabled");
		if (!cw.getScheduleButton().isEnabled()) {
			takeSnapshot(driver, "Invalid Details Form");
			System.out.println("Schedule button is disabled");
		}
		cw.getOrgranizationSize();
		Select select1 = new Select(
				driver.findElement(By.xpath("//header[@id='header']//select[@id='organizationSize']")));
		select1.selectByVisibleText("<500");
		cw.getInterestedIn();
		Select select2 = new Select(
				driver.findElement(By.xpath("//header[@id='header']//select[@id='interestedIn']")));
		select2.selectByVisibleText("Taking a demo");
		cw.getScheduleButton();
	}
}
