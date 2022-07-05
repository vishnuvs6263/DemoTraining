package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffPage {
	WebDriver driver;

	public StaffPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement UpdateBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement toastCloseBtn;
	
	@FindBy(xpath = "//input[@class='form-control search-inp']")
	WebElement searchField;
	@FindBy(xpath = "//button[@title='Click to change status']")
	WebElement statusBtn;
	@FindBy(xpath = "//a[@title='Edit']")
	WebElement editBtn;
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteBtn;
	@FindBy(xpath = "//button[@class='yes-btn']")
	WebElement cnfrmYesBtn;

	// Page details
	@FindBy(xpath = "//a[@id='admin_staffs']")
	WebElement staffsModule;
	@FindBy(xpath = "//span[@class='add-new']")
	WebElement addNewBtn;
	@FindBy(xpath = "//div[@class='error-message']")
	WebElement errorMsg;
	// Add staff details
	@FindBy(xpath = "//input[@id='addstaff_firstname']")
	WebElement staff_firstname;
	@FindBy(xpath = "//input[@placeholder='Enter last name']")
	WebElement staff_lastname;
	@FindBy(xpath = "//input[@placeholder='Enter phone']")
	WebElement staff_phone;
	@FindBy(xpath = "//input[@placeholder='Enter last mobile']")
	WebElement staff_mobile;
	@FindBy(xpath = "//input[@id='addstaff_email']")
	WebElement staff_RegisteredEmail;
	@FindBy(xpath = "//input[@id='addstaff_email']")
	WebElement staff_address;
	@FindBy(xpath = "//input[@id='add_staff_dateofbirth']")
	WebElement staff_dob;
	
	@FindBy(xpath = "//div[@class=' css-1hwfws3']")
	WebElement staff_Organisation_Field;
	
	@FindBy(xpath = "//div[@id='react-select-2-option-0']")
	WebElement staff_Organisation_DD_Option;
	
	@FindBy(xpath = "//input[@name='staffDBSCert']")
	WebElement browse_StaffDBS;
	
	@FindBy(xpath = "//label[text()='Staff DBS Certificate']")
	WebElement staff_DBSField;
	
	@FindBy(xpath = "//select[@id='addstaff_role1']")
	WebElement staff_SelectRole;
	
	@FindBy(xpath = "//input[@id='addstaff_rate1']")
	WebElement staff_EnterRateField;
	
	@FindBy(xpath = "//h4[text()='Assign Document']")
	WebElement AssignDocPageTitle;
	
	@FindBy(xpath = "(//select[@id='bundle_document_cat'])[1]")
	WebElement selectBundleDropdown;
	
	@FindBy(xpath = "//i[@class='ri-add-line']")
	WebElement AddLineBtn;
	@FindBy(xpath = "//div[@class='docs-area']")
	WebElement Document;
	
	//staff availability
	
	@FindBy(xpath = "(//button[@id='addstaff_row'])[2]")
	WebElement addAvailability;
	
	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement Calendar_NextMonthBtn;
	
	@FindBy(xpath = "//div[text()=14]")
	WebElement Staff_avail_startDate;
	
	@FindBy(xpath = "//div[text()=29]")
	WebElement Staff_avail_endDate;
	
	@FindBy(xpath = "//select[@id='addstaff_repeat']")
	WebElement Staff_avail_repeatType;
	@FindBy(xpath = "//button[@id='addstafftiming_save']")
	WebElement Staff_avail_saveBtn;
	
	@FindBy(xpath = "//input[@id='addstaff_enddate']")
	WebElement Staff_Support_EndDate_Field;
	
	
	
	@FindBy(xpath = "//input[@id='addstaff_startdate']")
	WebElement Staff_Support_StartDate_Field;
	
	@FindBy(xpath = "(//button[@id='addstaff_row'])[2]")
	WebElement Add_availability_button;
	
	@FindBy(xpath = "//a[@id='addstaff_edit']")
	WebElement Staff_EditButton;
	
	@FindBy(xpath = "//button[@id='addstaff_trash1']")
	WebElement Timing_DeleteButton;
	
	@FindBy(xpath = "//button[@id='addstaff_trash1']")
	List<WebElement> Timing_DeleteButtonSize;
	
	@FindBy(xpath = "//input[@id='weekday-mon2']")
	WebElement Timing_Weekly_Monday;
	@FindBy(xpath = "//input[@id='weekday-tue2']")
	WebElement Timing_Weekly_Tuesday;
	
	@FindBy(xpath = "(//div[@class='error-message'])[5]")
	WebElement AvailabilityErrorMsg;

	@FindBy(xpath = "//input[@name='frequency']")
	WebElement AvailabilityFrequency;

	
	//Slot - 2
	
	@FindBy(xpath = "(//input[@id='addstaff_enddate'])[2]")
	WebElement Staff_Support_EndDate_Field2;
	
	
	
	@FindBy(xpath = "(//input[@id='addstaff_startdate'])[2]")
	WebElement Staff_Support_StartDate_Field2;
	
	@FindBy(xpath = "(//select[@id='addstaff_repeat'])[2]")
	WebElement Staff_avail_repeatType2;
	
	@FindBy(xpath = "(//button[@id='addstafftiming_save'])[2]")
	WebElement Staff_avail_saveBtn2;
	
	@FindBy(xpath = "//input[@id='addstaff_alldayalltime']")
	WebElement Staff_avail_alldayAllTime;
	

	
	// common
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	public WebElement SaveBtn() {
		return SaveBtn;
	}
	public WebElement Staff_EditButton() {
		return Staff_EditButton;
	}
	
	public WebElement editBtn() {
		return editBtn;
	}
	
	public WebElement searchField() {
		return searchField;
	}
	
	public WebElement statusBtn() {
		return statusBtn;
	}
	
	public WebElement deleteBtn() {
		return deleteBtn;
	}
	
	public WebElement cnfrmYesBtn() {
		return cnfrmYesBtn;
	}
	
	public WebElement toastMsg() {
		return toastMsg;
	}
	
	public WebElement toastCloseBtn() {
		return toastCloseBtn;
	}
	// page details
	public WebElement staffsModule() {
		return staffsModule;
	}

	public WebElement addNewBtn() {
		return addNewBtn;
	}

	public WebElement errorMsg() {
		return errorMsg;
	}

	// Add staff details
	public WebElement staff_firstname() {
		return staff_firstname;
	}

	public WebElement staff_lastname() {
		return staff_lastname;
	}

	public WebElement staff_phone() {
		return staff_phone;
	}

	public WebElement staff_mobile() {
		return staff_mobile;
	}

	public WebElement staff_RegisteredEmail() {
		return staff_RegisteredEmail;
	}

	public WebElement staff_address() {
		return staff_address;
	}
	
	public WebElement staff_dob() {
		return staff_dob;
	}
	
	
	
	public WebElement staff_Organisation_Field() {
		return staff_Organisation_Field;
	}
	
	public WebElement staff_Organisation_DD_Option() {
		return staff_Organisation_DD_Option;
	}
	
	public WebElement browse_StaffDBS() {
		return browse_StaffDBS;
	}
	
	public WebElement staff_DBSField() {
		return staff_DBSField;
	}
	public WebElement staff_SelectRole() {
		return staff_SelectRole;
	}
	public WebElement staff_EnterRateField() {
		return staff_EnterRateField;
	}
	
	
	public WebElement selectBundleDropdown() {
		return selectBundleDropdown;
	}
	
	public WebElement AddLineBtn() {
		return AddLineBtn;
	}
	public WebElement AssignDocPageTitle() {
		return AssignDocPageTitle;
	}
	
	public WebElement Document() {
		return Document;
	}
	
	public WebElement Calendar_NextMonthBtn() {
		return Calendar_NextMonthBtn;
	}
	
	

	public WebElement Staff_avail_startDate() {
		return Staff_avail_startDate;
	}
	
	public WebElement Staff_avail_endDate() {
		return Staff_avail_endDate;
	}
	
	public WebElement Staff_avail_repeatType() {
		return Staff_avail_repeatType;
	}
	public WebElement Staff_avail_saveBtn() {
		return Staff_avail_saveBtn;
	}
	public WebElement Staff_Support_EndDate_Field() {
		return Staff_Support_EndDate_Field;
	}
	public WebElement Staff_Support_StartDate_Field() {
		return Staff_Support_StartDate_Field;
	}
	
	public WebElement Add_availability_button() {
		return Add_availability_button;
	}
	
	public WebElement Timing_DeleteButton() {
		return Timing_DeleteButton;
	}
	
	public List<WebElement> Timing_DeleteButtonSize() {
		return Timing_DeleteButtonSize;
	}
	
	public WebElement UpdateBtn() {
		return UpdateBtn;
	}
	public WebElement Staff_avail_saveBtn2() {
		return Staff_avail_saveBtn2;
	}
	
	public WebElement Staff_avail_repeatType2() {
		return Staff_avail_repeatType2;
	}
	
	public WebElement Staff_Support_StartDate_Field2() {
		return Staff_Support_StartDate_Field2;
	}
	
	public WebElement Staff_Support_EndDate_Field2() {
		return Staff_Support_EndDate_Field2;
	}
	
	public WebElement AvailabilityErrorMsg() {
		return AvailabilityErrorMsg;
	}
	
	public WebElement Timing_Weekly_Monday() {
		return Timing_Weekly_Monday;
	}
	
	public WebElement Timing_Weekly_Tuesday() {
		return Timing_Weekly_Tuesday;
	}
	
	public WebElement AvailabilityFrequency() {
		return AvailabilityFrequency;
	}
	public WebElement Staff_avail_alldayAllTime() {
		return Staff_avail_alldayAllTime;
	}
	
	
}
