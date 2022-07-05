package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
WebDriver driver ;
	
	public ReportsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Common
	@FindBy(xpath= "//a[@id='admin_report']")WebElement ReportsModule;
	@FindBy(xpath= "//a[@id='admin_report_staff']")WebElement StaffListingSubModule;
	@FindBy(xpath= "//a[@id='admin_report_student']")WebElement StudentListingSubModule;


	@FindBy(xpath= "//input[@id='fb_from']")WebElement FromDate;
	@FindBy(xpath= "(//button[@class='react-datepicker__close-icon'])[1]")WebElement ClearBtn;
	
	//Select user type for login
	@FindBy(xpath= "//div[@aria-label='Choose Saturday, May 1st, 2021']")WebElement SelectFromDate;
	@FindBy(xpath= "//button[@id='staff_recordsession_save']")WebElement SearchBtn;

	

	
	@FindBy(id = "settings_institution_edit")
	WebElement ViewPersonalDetailsBtn;
	@FindBy(id = "settings_institution_delete")
	WebElement ViewSupportActivitiesBtn;
	@FindBy(xpath = "//p[@class='user-name']")
	WebElement getStaffName;
	
	@FindBy(xpath = "//button[@id='close_profile_report']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//button[@id='close_activity_report']")
	WebElement closeBtnSupport;
	
	@FindBy(xpath = "//a[@id='rot-icon']")
	WebElement expandBtn;
	

	@FindBy(xpath = "(//div[@class='staff-title-info'])[1]")
	WebElement getUserName;
	
	@FindBy(xpath = "(//p[@class='user-name'])[1]")
	WebElement getStudentName;
	@FindBy(xpath = "(//div[@class='staff-title-info'])[6]")
	WebElement getRate_FB;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[1]/td[2]")
	WebElement getAttendedSessionTitle;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[2]/td[2]")
	WebElement getMissedSessionTitle;
	
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[1]/td[7]")
	WebElement getAttendedSessionStatus;
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]/tbody/tr[2]/td[7]")
	WebElement getMissedSessionStatus;
	

	
	
	
	
	
	
	//Common
	public WebElement getStudentName()
	{
		return getStudentName;
	}
	public WebElement closeBtnSupport()
	{
		return closeBtnSupport;
	}
	public WebElement ReportsModule()
	{
		return ReportsModule;
	}
	public WebElement StaffListingSubModule()
	{
		return StaffListingSubModule;
	}

	public WebElement StudentListingSubModule()
	{
		return StudentListingSubModule;
	}
	
	public WebElement FromDate()
	{
		return FromDate;
	}
	
	public WebElement ClearBtn()
	{
		return ClearBtn;
	}
	

	public WebElement SelectFromDate()
	{
		return SelectFromDate;
	}
	
	public WebElement SearchBtn()
	{
		return SearchBtn;
	}
	

	
	
	public WebElement getMissedSessionStatus()
	{
		return getMissedSessionStatus;
	}
	
	
	public WebElement getAttendedSessionStatus()
	{
		return getAttendedSessionStatus;
	}
	
	
	public WebElement getMissedSessionTitle()
	{
		return getMissedSessionTitle;
	}
	
	
	public WebElement getAttendedSessionTitle()
	{
		return getAttendedSessionTitle;
	}
	
	
	public WebElement getRate_FB()
	{
		return getRate_FB;
	}
	
	
	public WebElement getUserName()
	{
		return getUserName;
	}
	
	
	public WebElement expandBtn()
	{
		return expandBtn;
	}
	
	
	public WebElement closeBtn()
	{
		return closeBtn;
	}
	
	public WebElement getStaffName()
	{
		return getStaffName;
	}
	
	public WebElement ViewSupportActivitiesBtn()
	{
		return ViewSupportActivitiesBtn;
	}
	
	public WebElement ViewPersonalDetailsBtn()
	{
		return ViewPersonalDetailsBtn;
	}
	
	
	
}
