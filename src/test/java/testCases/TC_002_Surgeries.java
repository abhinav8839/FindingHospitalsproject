package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SurgeriesPage;
import testBase.BaseClass;

public class TC_002_Surgeries extends BaseClass {
	@Test(priority = 1)
	public void topSurgeries() throws IOException, InterruptedException {
		logger.info("Starting TC_002_Surgeries");
		
		HomePage hp = new HomePage(driver);
		logger.info("getting surgeries");
		hp.getSurgeries().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600)");

		Thread.sleep(1000);
		logger.debug("taking screenshot");
		takeSnapshot(driver, "Surgeries");
		logger.info("opening surgeries");
		List<WebElement> surgeries = driver.findElements(By.xpath(
				"//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div//p"));
		System.out.println("Top surgeries");
		for (WebElement surgery : surgeries) {
			System.out.println(surgery.getText());
		}
		
		System.out.println("\nSurgery based on Departments");
	}

	@Test(priority = 2)
	public void generalSurgeries() {
		logger.info("recording general surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType1().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));

		System.out.println("\nGeneral Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}

	@Test(priority = 3)
	public void practologySurgeries() {
		logger.info("recording practology surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType2().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));
		System.out.println("\nPractology Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}

	@Test(priority = 4)
	public void ophtomologySurgeries() {
		logger.info("recording opthomology surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType3().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));
		System.out.println("\nOphtomology Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}

	@Test(priority = 5)
	public void urologySurgeries() {
		logger.info("recording urology surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType4().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));
		System.out.println("\nUrology Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}

	@Test(priority = 6)
	public void cosmeticSurgeries() {
		logger.info("recording cosmetic surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType5().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));
		System.out.println("\ncosmetic Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}

	@Test(priority = 3)
	public void orthopedicSurgeries() {
		logger.info("recording orthopedic surgeries");
		SurgeriesPage sp = new SurgeriesPage(driver);
		sp.getSurgeryType6().click();
		List<WebElement> generalSurgeries = driver.findElements(
				By.xpath("//div[@class='flex flex-wrap gap-x-48px gap-y-44px px-20px pt-8px pb-32px']/div//p"));
		System.out.println("\nOrthopedic Surgeries");
		logger.debug("checking if surgeries are getting displayed");
		for (WebElement surgery : generalSurgeries) {
			System.out.println(surgery.getText());
		}
		if (sp.getCloseModal().isDisplayed()) {
			sp.getCloseModal().click();
		}
	}
}
