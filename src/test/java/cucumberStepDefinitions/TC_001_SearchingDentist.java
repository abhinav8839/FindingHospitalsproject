package cucumberStepDefinitions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DentistPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_SearchingDentist {
	@Given("user is on practo.com website.")
	public void user_is_on_practo_com_website() {
		System.out.println("User is on the page");
	
	}

	@When("user clicks the location box and clears existing data.")
	public void user_clicks_the_location_box_and_clears_existing_data() {
		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.setLocSearchBox().click();
		hp.setLocSearchBox().clear();

	}

	@When("enters required location.")
	public void enters_required_location() throws InterruptedException {
		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.setLocSearchBox().sendKeys("Bangalore");
		hp.setLocClick().click();
	}

	@When("clicks the search box to type Dentist doctors.")
	public void clicks_the_search_box_to_type_dentist_doctors() throws InterruptedException {
		HomePage hp = new HomePage(BaseClass.getDriver());
		hp.setTypeSearchBox().click();
		Thread.sleep(2000);
		hp.setTypeSearchBox().sendKeys("Dentist");
		Thread.sleep(2000);
		hp.setDentistType().click();
	}

	@Then("the page starts to search for records of doctors who are Dentist and its displayed.")
	public void the_page_starts_to_search_for_records_of_doctors_who_are_dentist_and_its_displayed() {
		HomePage hp = new HomePage(BaseClass.getDriver());
        System.out.println("The doctors details are fetched!!");
	}

	@Then("applying filters for Patient Stories, Experience, Fees, Availability and any one Sorting.")
	public void applying_filters_for_patient_stories_experience_fees_availability_and_any_one_sorting() throws InterruptedException {
		DentistPage dp = new DentistPage(BaseClass.getDriver());
		dp.getPatientStoriesFilter().click();
		Thread.sleep(2000);
		dp.getPatientStoriesOptionOne().click();
		Thread.sleep(2000);
		dp.getExperienceFilter().click();
		Thread.sleep(2000);
		dp.getExperienceFilterOptionOne().click();
		Thread.sleep(2000);
		dp.getAllFilters().click();
		Thread.sleep(5000);
		dp.getAboveRs500().click();

		Thread.sleep(2000);
		dp.getAllFilters().click();
		Thread.sleep(5000);
		dp.getAvailableTomorrow().click();
		dp.getAllFilters().click();
		Thread.sleep(2000);
		dp.getRelevanceFilter().click();
		Thread.sleep(2000);
		dp.getRelevanceOptionTwo().click();
		//logger.debug("taking screenshot");
		//takeSnapshot(driver, "Dentists_Page");
		//logger.info("getting number of dentists");
		

	}

	@Then("Fetch & display the first five Doctor details.")
	public void fetch_display_the_first_five_doctor_details() throws InterruptedException {
		DentistPage dp = new DentistPage(BaseClass.getDriver());
		String totalDentists = dp.getTotalDoctors().getText();
		System.out.println(totalDentists);
		List<WebElement> dentistsNames = dp.getDentists();
		List<WebElement> dentistsExperience = dp.getDentistsExperience();
		List<WebElement> dentistsLocation = dp.getDentistsLocation();
		List<WebElement> detnistsClinic = dp.getDentistsClinic();
		//List<WebElement> dentistsConsulationFees = dp.getDentistsConsulationFees();
		List<WebElement> dentistsRating = dp.getDentistsRating();

		for (int i = 0; i < 5; i++) {
			//System.out.println(i);
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
			js.executeScript("arguments[0].scrollIntoView()", dentistsExperience.get(i));
			
			//takeSnapshot(BaseClass.getDriver(), "dentist" + (i + 1));
			Thread.sleep(2000);
			System.out.println("\nDoctor " + (i + 1));
			System.out.println("Name: " + dentistsNames.get(i).getText());
			System.out.println("Experience: " + dentistsExperience.get(i).getText());
			System.out.println("Location: " + dentistsLocation.get(i).getText());
			System.out.println("Clinic: " + detnistsClinic.get(i).getText());
			//System.out.println(dentistsConsulationFees.get(i).getText() + " consulation fees");
			System.out.println("Rating: " + dentistsRating.get(i).getText());
	}



}
}
