package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_TimesheetPage {
	WebDriver driver;

	public Admin_TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	
	@FindBy(xpath= "//button[@id='modal_close']")WebElement closeBtn;
	
	@FindBy(xpath= "(//select[@class='form-control custom-filter-select w3-select'])[1]")WebElement selctDropDown;
	@FindBy(xpath = "//button[@class='tablinks active']")
	WebElement GetUsersName	;
	
	// Page details
	@FindBy(xpath = "//a[@id='admin_timesheet']")
	WebElement Admin_TimesheetModule;
	
	@FindBy(xpath = "(//p[@class='field-value'])[2]")
	WebElement getHoursWorksedGeneric;
	
	@FindBy(xpath = "(//p[@class='field-value'])[3]")
	WebElement getAmountEarnedGeneric;
	
	@FindBy(xpath = "(//td[@role='cell'])[1]")
	WebElement getStudentName;
	@FindBy(xpath = "//td[@class='acion-btns text-center']")
	WebElement viewDetailsBtn;
	
	
	//ViewDetails Page
	@FindBy(xpath = "(//td[@role='cell'])[13]")
	WebElement getNameDetails;
	
	@FindBy(xpath = "(//p[@class='sup-des col-5'])[2]")
	WebElement getStudEmailDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[1]")
	WebElement getSessionNameDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[2]")
	WebElement getSupportTypeDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[3]")
	WebElement getRoleDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[4]")
	WebElement getLocationDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[5]")
	WebElement getMODDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[7]")
	WebElement getFBDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[6]")
	WebElement getAmountDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[11]")
	WebElement getBreakDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[12]")
	WebElement getTotalHoursDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[14]")
	WebElement getMissedSessionTitleDetails;
	@FindBy(xpath = "(//td[@role='cell'])[19]")
	WebElement getMissedSessionReasonDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[17]")
	WebElement getMissedAmountDetails;
	@FindBy(xpath = "(//td[@role='cell'])[24]")
	WebElement getMissedHoursDetails;
	
	
	// common
	public WebElement getMissedSessionTitleDetails() {
		return getMissedSessionTitleDetails;
	}
	public WebElement getMissedSessionReasonDetails() {
		return getMissedSessionReasonDetails;
	}
	public WebElement getMissedAmountDetails() {
		return getMissedAmountDetails;
	}
	public WebElement getMissedHoursDetails() {
		return getMissedHoursDetails;
	}
	
	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	
	public WebElement closeBtn()
	{
		return closeBtn;
	}
	
	public WebElement GetUsersName()
	{
		return GetUsersName;
	}
	public WebElement selctDropDown()
	{
		return selctDropDown;
	}
	
	public WebElement Admin_TimesheetModule() {
		return Admin_TimesheetModule;
	}
	public WebElement getHoursWorksedGeneric() {
		return getHoursWorksedGeneric;
	}
	public WebElement getStudentName() {
		return getStudentName;
	}

	// page details
	public WebElement getAmountEarnedGeneric() {
		return getAmountEarnedGeneric;
	}

	public WebElement viewDetailsBtn() {
		return viewDetailsBtn;
	}

	public WebElement getNameDetails() {
		return getNameDetails;
	}

	public WebElement getStudEmailDetails() {
		return getStudEmailDetails;
	}

	public WebElement getSessionNameDetails() {
		return getSessionNameDetails;
	}

	public WebElement getSupportTypeDetails() {
		return getSupportTypeDetails;
	}
	
	public WebElement getRoleDetails() {
		return getRoleDetails;
	}
	public WebElement getLocationDetails() {
		return getLocationDetails;
	}
	public WebElement getMODDetails() {
		return getMODDetails;
	}
	public WebElement getFBDetails() {
		return getFBDetails;
	}
	public WebElement getAmountDetails() {
		return getAmountDetails;
	}
	public WebElement getBreakDetails() {
		return getBreakDetails;
	}
	public WebElement getTotalHoursDetails() {
		return getTotalHoursDetails;
	}


	
}
