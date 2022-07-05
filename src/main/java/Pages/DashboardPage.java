package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
WebDriver driver ;
	
	public DashboardPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Common
	@FindBy(xpath= "//span[@class='fc-icon fc-icon-chevron-right']")WebElement CalendarFrwdBtn;
	@FindBy(xpath= "//a[@id='student_dasboard']")WebElement StudentDashboard_Calendar;
	@FindBy(xpath= "//a[@id='staff_dashboard']")WebElement StaffDashboard_Calendar;

	@FindBy(xpath= "//img[@alt='dsa-logo']")List <WebElement> DSALogo;
	@FindBy(xpath= "//h2[@class='fc-toolbar-title']")WebElement CalMonth;
	@FindBy(xpath= "//button[@id='session_submit']")WebElement EventSubmit;
	
	//Select user type for login
	@FindBy(xpath= "//a[@class='nav-link dropdown-toggle user-dp-toggle']")WebElement ViewUserBtn;
	@FindBy(xpath= "//span[text()='Logout']")WebElement LogoutBtn;
	@FindBy(xpath= "//select[@id='student_calendar_staff']")WebElement selectSupportDrpDwn;
	@FindBy(xpath= "//select[@id='calendar_select_student']")WebElement selectSStudentDrpDwn;
	
	//Select staff dropdown
	@FindBy(xpath= "//select[@id='student_calendar_staff']")WebElement SelectStaffDropDown;
	@FindBy(xpath= "//td[@data-date='2021-09-14']")WebElement CreateEventDate;
	@FindBy(xpath= "//td[@data-date='2021-09-15']")WebElement CreateEventDate_NeverRepeat;
	
	//Create session window
	@FindBy(xpath= "//h5[@class='modal-title']")WebElement CreateSessionWindowTitle;
	@FindBy(xpath= "//input[@id='session_title']")WebElement EventTitle;
	@FindBy(xpath= "//input[@id='session_end']")WebElement EventEndDateField;
	@FindBy(xpath= "//li[text()='01:30']")WebElement EventEndTime;
	@FindBy(xpath= "//input[@id='session_location']")WebElement EventLocation;
	
	//After creating event
	@FindBy(xpath= "//a[@class='fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-start fc-event-end fc-event-future']")WebElement EventCard;
	
	@FindBy(xpath= "//p[@class='user-name']")WebElement getStaffName;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[1]")WebElement getEventTitle;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[2]")WebElement getEventLocation;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[3]")WebElement getEventStartDate;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[4]")WebElement getEventEndDate;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[5]")WebElement getSupportType;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[6]")WebElement getRole;
	@FindBy(xpath= "//button[@id='modal_close']")WebElement closeBtn;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement toastCloseBtn;
	@FindBy(xpath = "//button[@id='accept_session']")
	WebElement eventAcceptBtn;
	
	@FindBy(xpath = "//button[@id='delete_session']")
	WebElement eventDeleteBtn;
	
	@FindBy(xpath = "//button[@id='yesbtn_popup_delete_event']")
	WebElement eventDelete_ConfirmBtn;
	
	
	
	
	
	
	
	//Common
	public WebElement CalendarFrwdBtn()
	{
		return CalendarFrwdBtn;
	}
	public WebElement ViewUserBtn()
	{
		return ViewUserBtn;
	}
	
	public WebElement LogoutBtn()
	{
		return LogoutBtn;
	}
	
	public WebElement StudentDashboard_Calendar()
	{
		return StudentDashboard_Calendar;
	}
	
	public WebElement StaffDashboard_Calendar()
	{
		return StaffDashboard_Calendar;
	}
	
	public List <WebElement> DSALogo()
	{
		return DSALogo;
	}
	
	public WebElement selectSupportDrpDwn()
	{
		return selectSupportDrpDwn;
	}
	
	public WebElement CalMonth()
	{
		return CalMonth;
	}
	public WebElement CreateEventDate()
	{
		return CreateEventDate;
	}
	public WebElement CreateSessionWindowTitle()
	{
		return CreateSessionWindowTitle;
	}
	public WebElement EventTitle()
	{
		return EventTitle;
	}
	public WebElement EventEndDateField()
	{
		return EventEndDateField;
	}
	public WebElement EventEndTime()
	{
		return EventEndTime;
	}
	public WebElement EventLocation()
	{
		return EventLocation;
	}
	
	public WebElement EventSubmit()
	{
		return EventSubmit;
	}
	
	public WebElement EventCard()
	{
		return EventCard;
	}
	
	public WebElement getStaffName()
	{
		return getStaffName;
	}
	
	public WebElement getEventTitle()
	{
		return getEventTitle;
	}
	
	public WebElement getEventLocation()
	{
		return getEventLocation;
	}
	
	public WebElement getEventStartDate()
	{
		return getEventStartDate;
	}
	
	public WebElement getEventEndDate()
	{
		return getEventEndDate;
	}
	
	public WebElement getSupportType()
	{
		return getSupportType;
	}
	
	public WebElement getRole()
	{
		return getRole;
	}
	
	public WebElement closeBtn()
	{
		return closeBtn;
	}
	
	public WebElement toastMsg() {
		return toastMsg;
	}

	public WebElement toastCloseBtn() {
		return toastCloseBtn;
	}
	

	public WebElement eventAcceptBtn() {
		return eventAcceptBtn;
	}
	
	public WebElement CreateEventDate_NeverRepeat() {
		return CreateEventDate_NeverRepeat;
	}
	public WebElement eventDeleteBtn()
	{
		return eventDeleteBtn;
	}
	
	public WebElement eventDelete_ConfirmBtn()
	{
		return eventDelete_ConfirmBtn;
	}
	
	public WebElement selectSStudentDrpDwn()
	{
		return selectSStudentDrpDwn;
	}
	
}
