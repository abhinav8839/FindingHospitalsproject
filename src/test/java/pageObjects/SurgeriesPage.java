package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurgeriesPage extends BasePage {

	public SurgeriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[1]")
	WebElement surgeryType1;

	@FindBy(xpath = "//span[@class='ModalHeader-module_crossIcon__Yf11z utils-module_right0px__yofdH ModalHeader-module_sizeLargeCrossIcon__3a5hf top-[47%]']")
	WebElement closeModal;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[2]")
	WebElement surgeryType2;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[3]")
	WebElement surgeryType3;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[4]")
	WebElement surgeryType4;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[5]")
	WebElement surgeryType5;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[6]")
	WebElement surgeryType6;

	@FindBy(xpath = "//div[@class='OurDepartments-module_container__ZTtOP dweb:pl-52px pb-12px mb-8px']/div/div[7]")
	WebElement surgeryType7;

	public WebElement getCloseModal() {
		return closeModal;
	}

	public WebElement getSurgeryType1() {
		return surgeryType1;
	}

	public WebElement getSurgeryType2() {
		return surgeryType2;
	}
	public WebElement getSurgeryType3() {
		return surgeryType3;
	}
	public WebElement getSurgeryType4() {
		return surgeryType4;
	}
	public WebElement getSurgeryType5() {
		return surgeryType5;
	}
	public WebElement getSurgeryType6() {
		return surgeryType6;
	}
	public WebElement getSurgeryType7() {
		return surgeryType7;
	}
}
