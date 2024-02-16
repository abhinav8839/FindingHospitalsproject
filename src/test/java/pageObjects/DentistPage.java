package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DentistPage extends BasePage{

	public DentistPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//h1[@class='u-xx-large-font u-bold']")
	WebElement totalDoctors;
	
	@FindBy(xpath = "//div[@class='c-filter__top']//div[2]")
	WebElement patientStoriesFilter;
	
	@FindBy(xpath = "//div[@class='c-filter__box u-pos-rel c-dropdown open']//ul[@role='listbox']/li[1]/span")
	WebElement patientStoriesOptionOne;
	
	@FindBy(xpath = "//div[@class='c-filter__top']//div[3]")
	WebElement experienceFilter;
	
	@FindBy(xpath = "//div[@class='u-d-inlineblock u-color--white u-c-pointer']/span")
	WebElement allFilters;
	
	@FindBy(xpath = "//div[@class='o-page-container u-cushion--vertical pure-g']/div[2]//label[2]/div")
	WebElement aboveRs500;
	
	@FindBy(xpath = "//div[@class='o-page-container u-cushion--vertical pure-g']/div[3]//label[3]/div")
	WebElement availableTomorrow;
	
	@FindBy(xpath = "//span[@class='c-sort-dropdown__selected c-dropdown__selected']")
	WebElement relevanceFilter;
	
	@FindBy(xpath = "//div[@aria-label='Click to view all sorting options']//ul[@role='listbox']/li[2]/span")
	WebElement relevanceOptionTwo;
	
	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[1]")
	WebElement generalSurgery;
	
	@FindBy(xpath = "//h2[@class='doctor-name']")
	List<WebElement> dentists;
	
	@FindBy(xpath = "//div[@class='u-grey_3-text']/div[2]")
	List<WebElement> dentistsExperience;
	
	@FindBy(xpath = "//span[@data-qa-id='practice_locality']")
	List<WebElement> dentistsLocation;
	
	@FindBy(xpath = "//span[@data-qa-id='doctor_clinic_name']")
	List<WebElement> dentistsClinic;
	
	@FindBy(xpath = "//span[@data-qa-id='consultation_fee']")
	List<WebElement> dentistsConsultationFees;
	
	@FindBy(xpath = "//span[@data-qa-id='doctor_recommendation']")
	List<WebElement> dentistsDentistsRating;
	
	// Actions
	public WebElement getTotalDoctors() {
		return totalDoctors;
	}
	
	public WebElement getPatientStoriesFilter() {
		return patientStoriesFilter;
	}
	public WebElement getPatientStoriesOptionOne() {
		return patientStoriesOptionOne;
	}
	public WebElement getExperienceFilter() {
		return experienceFilter;
	}
	public WebElement getAllFilters() {
		return allFilters;
	}
	public WebElement getAboveRs500() {
		return aboveRs500;
	}
	public WebElement getAvailableToday() {
		return availableTomorrow;
	}
	public WebElement getRelevanceFilter() {
		return relevanceFilter;
	}
	public WebElement getRelevanceOptionTwo() {
		return relevanceOptionTwo;
	}

	public List<WebElement> getDentists() {
		return dentists;
	}

	public List<WebElement> getDentistsExperience() {
		return dentistsExperience;
	}

	public List<WebElement> getDentistsLocation() {
		return dentistsLocation;
	}

	public List<WebElement> getDentistsClinic() {
		return dentistsClinic;
	}

	public List<WebElement> getDentistsConsulationFees() {
		return dentistsConsultationFees;
	}

	public List<WebElement> getDentistsRating() {
		return dentistsDentistsRating;
	}
	
}
