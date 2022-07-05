package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySupportPage {
	WebDriver driver;

	public MySupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	
	@FindBy(xpath = "//button[@id='student_support_viewdetailundefined']")
	WebElement StaffViewDetailsButton;
	@FindBy(xpath = "//button[@id='close_student_support_viewdetail']")
	WebElement StaffViewDetailsCloseButton;
	

	// Page details
	@FindBy(xpath = "//a[@id='student_support']")
	WebElement MySupportModule;
	@FindBy(xpath = "//p[@class='sup-des col-8']")
	WebElement UserEmail;
	
	@FindBy(xpath = "//p[@class='staff-name']")
	WebElement getStaffName;
	
	@FindBy(xpath = "(//div[@class='staff-title-info'])[1]")
	WebElement getSupportType;
	
	@FindBy(xpath = "(//div[@class='staff-title-info'])[2]")
	WebElement getRole;


	@FindBy(xpath = "(//div[@class='staff-title-info'])[4]")
	WebElement getPlannedHours;
	
	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	
	public WebElement UserEmail() {
		return UserEmail;
	}
	
	public WebElement StaffViewDetailsButton() {
		return StaffViewDetailsButton;
	}
	public WebElement StaffViewDetailsCloseButton() {
		return StaffViewDetailsCloseButton;
	}
	public WebElement getStaffName() {
		return getStaffName;
	}

	// page details
	public WebElement MySupportModule() {
		return MySupportModule;
	}

	public WebElement getSupportType() {
		return getSupportType;
	}

	public WebElement getRole() {
		return getRole;
	}

	// Add staff details

	public WebElement getPlannedHours() {
		return getPlannedHours;
	}

	
}
