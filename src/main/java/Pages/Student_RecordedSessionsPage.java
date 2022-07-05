package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Student_RecordedSessionsPage {
	WebDriver driver;

	public Student_RecordedSessionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	@FindBy(xpath = "//a[@id='staff_recordsession']")
	WebElement RecordedSessionsModule;
	@FindBy(xpath = "//select[@name='month']")
	WebElement SelectMonthDropDown;
	@FindBy(xpath = "//button[@class='search-btn record-search']")
	WebElement SearchBtn;

	//Timesheet


	@FindBy(xpath = "//p[@class='stu-session-title']")
	WebElement getUserName;
	@FindBy(xpath = "(//div[@class='staff-title-info'])[7]")
	WebElement getMOD;

	
	@FindBy(xpath = "(//div[@class='staff-title-info'])[9]")
	WebElement gethoursWorked;
	

	
	@FindBy(xpath = "(//div[@class='staff-title-info'])[1]")
	WebElement getSessionTitle;
	
	@FindBy(xpath = "//p[@class='stu-session-status']")
	WebElement getAuthStatus;
	@FindBy(xpath = "//a[@id='rot-icon']")
	WebElement collapseBtn;
	
	
	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	public WebElement RecordedSessionsModule() {
		return RecordedSessionsModule;
	}

	public WebElement SelectMonthDropDown() {
		return SelectMonthDropDown;
	}
	public WebElement getMOD() {
		return getMOD;
	}
	public WebElement getUserName() {
		return getUserName;
	}
	public WebElement gethoursWorked() {
		return gethoursWorked;
	}
	public WebElement getSessionTitle() {
		return getSessionTitle;
	}
	public WebElement getAuthStatus() {
		return getAuthStatus;
	}
	public WebElement collapseBtn() {
		return collapseBtn;
	}
	

	public WebElement SearchBtn() {
		return SearchBtn;
	}
	


	
}
