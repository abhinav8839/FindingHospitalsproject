package testCases;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.DentistPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_001_SearchingDentists extends BaseClass{
	public ExtentTest test;
	public ExtentReports extent;
	
	@Test(priority = 1)
	public void searchingDentists() throws InterruptedException, IOException {
		
		logger.info("Starting TC_001_SearchingDentists");
		
		logger.debug("taking screenshot");
		takeSnapshot(driver, "HomePage");
		HomePage hp = new HomePage(driver);
		
		logger.info("searching dentists");
		hp.setLocSearchBox().click();
		hp.setLocSearchBox().clear();
		hp.setLocSearchBox().sendKeys("Bangalore");
		hp.setTypeSearchBox().click();
		hp.setTypeSearchBox().sendKeys("Dentist");
		hp.setDentistType().click();
	}
	
	@Test(dependsOnMethods = "searchingDentists")
	public void gettingDentists() throws InterruptedException, IOException {
		DentistPage dp = new DentistPage(driver);
		logger.info("filtering results");
		dp.getPatientStoriesFilter().click();
		Thread.sleep(1000);
		dp.getPatientStoriesOptionOne().click();
		Thread.sleep(2000);
		dp.getExperienceFilter().click();
		Thread.sleep(1000);
		dp.getPatientStoriesOptionOne().click();
		Thread.sleep(2000);
		dp.getAllFilters().click();
		Thread.sleep(1000);
		dp.getAboveRs500().click();
		Thread.sleep(2000);
		dp.getAllFilters().click();
		dp.getAvailableToday().click();
		dp.getAllFilters().click();
		Thread.sleep(2000);
		dp.getRelevanceFilter().click();
		dp.getRelevanceOptionTwo().click();
		logger.debug("taking screenshot");
		takeSnapshot(driver, "Dentists_Page");
		logger.info("getting number of dentists");
		String totalDentists = dp.getTotalDoctors().getText();
		System.out.println(totalDentists);
		
		ExcelUtility et = new ExcelUtility(System.getProperty("user.dir") + "\\testData\\doctors.xlsx");
		
		logger.info("getting dentist details");
		List<WebElement> dentistsNames = dp.getDentists();
		List<WebElement> dentistsExperience = dp.getDentistsExperience();
		List<WebElement> dentistsLocation = dp.getDentistsLocation();
		List<WebElement> detnistsClinic = dp.getDentistsClinic();
		List<WebElement> dentistsConsulationFees = dp.getDentistsConsulationFees();
		List<WebElement> dentistsRating = dp.getDentistsRating();

		for (int i = 0; i < 5; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", dentistsExperience.get(i));
			takeSnapshot(driver, "dentist" + (i + 1));
			Thread.sleep(1000);

			System.out.println("\nDoctor " + (i + 1));
			System.out.println("Name: " + dentistsNames.get(i).getText());
			System.out.println("Experience: " + dentistsExperience.get(i).getText());
			System.out.println("Location: " + dentistsLocation.get(i).getText());
			System.out.println("Clinic: " + detnistsClinic.get(i).getText());
			System.out.println(dentistsConsulationFees.get(i).getText() + " consulation fees");
			System.out.println("Rating: " + dentistsRating.get(i).getText());

			et.setCellData("Doctor", i, 0, dentistsNames.get(i).getText());
			System.out.println();
		}
	}
	
}
