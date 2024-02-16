package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.CorporateWellnessPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_003_CorporateWellness_ValidDetails extends BaseClass {
	@Test
	public void openingCorporateWellness() throws IOException, InterruptedException {
		logger.info("Staring TC_003_CorporateWellness_ValidDetails");
		HomePage hp = new HomePage(driver);
		hp.getForCorporates();
		hp.getWellnessPlans();
		CorporateWellnessPage cw = new CorporateWellnessPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		logger.info("opening booking page");
		js.executeScript("window.scrollBy(0, 100)");
		cw.setName();
		cw.setOrganizationName();
		cw.setContactNumber();
		cw.setEmail().sendKeys("test@test.com");
		cw.getOrgranizationSize();
		Select select1 = new Select(
				driver.findElement(By.xpath("//header[@id='header']//select[@id='organizationSize']")));
		select1.selectByVisibleText("<500");
		cw.getInterestedIn();
		Select select2 = new Select(driver.findElement(By.xpath("//header[@id='header']//select[@id='interestedIn']")));
		select2.selectByVisibleText("Taking a demo");
		logger.debug("checking if button is enabled");
		if (cw.getScheduleButton().isEnabled()) {
			System.out.println("Schedule button is enabled!");
		}
		cw.getScheduleButton().click();
		Thread.sleep(5000);
		logger.info("checking if thank you modal is working or not");
		takeSnapshot(driver, "Valid details");
		String heading = cw.getThankYou();
		String paragraph = cw.getThankYouParagraph();
		System.out.println(heading);
		System.out.println(paragraph);

	}
}
