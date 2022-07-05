package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentTimesheetPage {
	WebDriver driver;

	public StudentTimesheetPage(WebDriver driver) {
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
	
	//Timesheet
	
	@FindBy(xpath = "//a[@id='student_timesheet']")
	WebElement TimesheetModule;
	@FindBy(xpath = "//button[@id='student_timesheet_signed']")
	WebElement authBtn;

	@FindBy(xpath = "//button[@id='student_timesheet_staff_signed']")
	WebElement staffsignStatusBtn;
	@FindBy(xpath = "//input[@name='modeOfDelivery']")
	WebElement getMOD;
	
	@FindBy(xpath = "//input[@name='breakHours']")
	WebElement getbreakinMins;
	
	@FindBy(xpath = "//input[@name='actualTime']")
	WebElement gethoursWorked;
	
	@FindBy(xpath = "//textarea[@id='joblist_currentsession_desc']")
	WebElement getcurrNotes;
	
	@FindBy(xpath = "//textarea[@id='joblist_nextsession_desc']")
	WebElement getnextSessionNotes;
	
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement studAuthBtn;
	
	@FindBy(xpath = "(//span[@class='checkmark'])[1]")
	WebElement answerYesBtn;
	
	@FindBy(xpath = "//button[text()='Missed']")
	WebElement MissedBtn;
	@FindBy(xpath = "//h5[@class='modal-title']")
	WebElement MissedDetails;
	
	@FindBy(xpath = "//button[@id='modal_close']")
	WebElement CloseBtn;
	
	
	
	
	
	
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
	
	public WebElement TimesheetModule() {
		return TimesheetModule;
	}
	
	public WebElement authBtn() {
		return authBtn;
	}
	
	public WebElement getMOD() {
		return getMOD;
	}
	
	public WebElement studsignStatusBtn() {
		return staffsignStatusBtn;
	}
	
	public WebElement getbreakinMins() {
		return getbreakinMins;
	}
	
	public WebElement gethoursWorked() {
		return gethoursWorked;
	}
	
	public WebElement getnextSessionNotes() {
		return getnextSessionNotes;
	}
	
	public WebElement getcurrNotes() {
		return getcurrNotes;
	}
	public WebElement studAuthBtn() {
		return studAuthBtn;
	}
	public WebElement answerYesBtn() {
		return answerYesBtn;
	}
	
	public WebElement MissedBtn() {
		return MissedBtn;
	}
	public WebElement MissedDetails() {
		return MissedDetails;
	}
	public WebElement CloseBtn() {
		return CloseBtn;
	}
	
	
}
