package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoblistPage {
	WebDriver driver;

	public JoblistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement toastCloseBtn;
	
	//Joblist
	
	@FindBy(xpath = "//a[@id='staff_joblist']")
	WebElement JoblistModule;
	@FindBy(xpath = "//button[@class='view-table-btn view-table-yes-btn']")
	WebElement acceptBtn;
	
	@FindBy(xpath = "//button[text()='Claim']")
	WebElement claimBtn;
	@FindBy(xpath = "//button[text()='Report']")
	WebElement reportBtn;
	@FindBy(xpath = "//button[@id='staff_timesheet_auth']")
	WebElement studsignStatusBtn;
	@FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder']")
	WebElement MODSelectMenu;
	@FindBy(xpath = "//div[@id='react-select-2-option-1']")
	WebElement MODSelectOption;
	
	@FindBy(xpath = "//input[@id='joblist_break']")
	WebElement breakinMins;
	
	@FindBy(xpath = "//input[@id='joblist_hoursworked']")
	WebElement hoursWorked;
	
	@FindBy(xpath = "//textarea[@name='currentNote']")
	WebElement currNotes;
	
	@FindBy(xpath = "//textarea[@name='futureNote']")
	WebElement nextSessionNotes;
	
	@FindBy(xpath = "//button[@id='joblist_save']")
	WebElement claimJobBtn;
	
	@FindBy(xpath = "//input[@id='missed_reason']")
	WebElement missedReason;
	@FindBy(xpath = "//button[@class='crte-session-btn']")
	WebElement Joblist_CreateSession;
	
	@FindBy(xpath = "//select[@id='calendar_select_student']")
	WebElement SelectStudentDropDown;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement SelectSUpportCheckBox;
	
	@FindBy(xpath = "//input[@id='session_title']")
	WebElement SessionTitle;
	
	@FindBy(xpath = "//input[@id='session_location']")
	WebElement SessionLocation;
	

	


	
	
	
	
	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	public WebElement SaveBtn() {
		return SaveBtn;
	}
	
	public WebElement toastMsg() {
		return toastMsg;
	}
	
	public WebElement toastCloseBtn() {
		return toastCloseBtn;
	}
	
	public WebElement JoblistModule() {
		return JoblistModule;
	}
	
	public WebElement acceptBtn() {
		return acceptBtn;
	}
	
	public WebElement claimJobBtn() {
		return claimJobBtn;
	}
	
	public WebElement nextSessionNotes() {
		return nextSessionNotes;
	}
	
	public WebElement currNotes() {
		return currNotes;
	}
	
	public WebElement hoursWorked() {
		return hoursWorked;
	}
	
	public WebElement breakinMins() {
		return breakinMins;
	}
	
	public WebElement MODSelectOption() {
		return MODSelectOption;
	}
	
	public WebElement MODSelectMenu() {
		return MODSelectMenu;
	}
	
	public WebElement studsignStatusBtn() {
		return studsignStatusBtn;
	}
	
	public WebElement reportBtn() {
		return reportBtn;
	}
	
	public WebElement claimBtn() {
		return claimBtn;
	}
	
	public WebElement missedReason() {
		return missedReason;
	}
	public WebElement Joblist_CreateSession() {
		return Joblist_CreateSession;
	}
	
	public WebElement SessionLocation() {
		return SessionLocation;
	}
	public WebElement SessionTitle() {
		return SessionTitle;
	}
	public WebElement SelectSUpportCheckBox() {
		return SelectSUpportCheckBox;
	}
	public WebElement SelectStudentDropDown() {
		return SelectStudentDropDown;
	}
}
