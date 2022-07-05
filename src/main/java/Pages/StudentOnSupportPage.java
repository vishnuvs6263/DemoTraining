package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentOnSupportPage {
	WebDriver driver;

	public StudentOnSupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement toastCloseBtn;
	

	// Page details
	@FindBy(xpath = "//a[@id='staff_students_on_support']")
	WebElement StudentsOnSupportModule;
	
	@FindBy(xpath = "(//td[@role='cell'])[2]")
	WebElement getStudentName;
	
	@FindBy(xpath = "(//td[@role='cell'])[4]")
	WebElement getSupportType;
	
	@FindBy(xpath = "(//td[@role='cell'])[5]")
	WebElement getRole;
	@FindBy(xpath = "(//td[@role='cell'])[6]")
	WebElement getRoleRate;
	
	@FindBy(xpath = "(//td[@role='cell'])[7]")
	WebElement getStudEmail;
	
	@FindBy(xpath = "(//td[@role='cell'])[8]")
	WebElement getPlannedHours;
	
	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	
	public WebElement toastMsg() {
		return toastMsg;
	}
	public WebElement toastCloseBtn() {
		return toastCloseBtn;
	}
	public WebElement getStudentName() {
		return getStudentName;
	}

	// page details
	public WebElement StudentsOnSupportModule() {
		return StudentsOnSupportModule;
	}

	public WebElement getSupportType() {
		return getSupportType;
	}

	public WebElement getRole() {
		return getRole;
	}

	// Add student details
	public WebElement getRoleRate() {
		return getRoleRate;
	}

	public WebElement getStudEmail() {
		return getStudEmail;
	}

	public WebElement getPlannedHours() {
		return getPlannedHours;
	}

	
}
