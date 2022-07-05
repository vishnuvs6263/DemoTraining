package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPage {
	WebDriver driver;

	public StudentPage(WebDriver driver) {
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
	@FindBy(xpath = "//a[@id='admin_students']")
	WebElement StudentsModule;
	@FindBy(xpath = "//span[@class='add-new']")
	WebElement addNewBtn;
	@FindBy(xpath = "//div[@class='error-message']")
	WebElement errorMsg;
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement SaveBtn;
	// Add student details
	@FindBy(xpath = "//input[@placeholder='Enter first name']")
	WebElement student_firstname;
	@FindBy(xpath = "//input[@placeholder='Enter last name']")
	WebElement student_lastname;
	@FindBy(xpath = "//input[@placeholder='Enter phone']")
	WebElement student_phone;
	@FindBy(xpath = "//input[@placeholder='Enter mobile']")
	WebElement student_mobile;
	@FindBy(xpath = "//input[@id='add_student_email']")
	WebElement student_RegisteredEmail;
	@FindBy(xpath = "//textarea[@id='add_student_address']")
	WebElement student_address;
	@FindBy(xpath = "//input[@id='add_student_dateofbirth']")
	WebElement student_dob;
	@FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
	WebElement Student_Course_Field;
	
	@FindBy(xpath = "//div[@id='react-select-2-option-0']")
	WebElement Student_Course_DD_Option;
	@FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
	WebElement Student_Institution_Field;
	@FindBy(xpath = "//div[@id='react-select-3-option-0']")
	WebElement Student_Institution_DD_Option;

	@FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
	WebElement Student_Organisation_Field;
	@FindBy(xpath = "//div[@id='react-select-4-option-0']")
	WebElement Student_Organisation_DD_Option;
	
	@FindBy(xpath = "//select[@id='add_student_support_type_1']")
	WebElement SelectSupportType;
	
	@FindBy(xpath = "//select[@id='add_student_support_staff_1']")
	WebElement SelectSupportStaff;
	
	@FindBy(xpath = "//input[@id='add_student_support_plannedhours_1']")
	WebElement Student_PlannedHoursField;
	
	@FindBy(xpath = "//input[@id='add_student_support_enddate_1']")
	WebElement Student_Support_EndDate;
	
	
	
	@FindBy(xpath = "//input[@id='add_student_support_startdate_1']")
	WebElement Student_Support_StartDate;
	
	@FindBy(xpath = "//select[@id='add_student_role_1']")
	WebElement Student_SelectRole_Rate;
	
	@FindBy(xpath = "//select[@id='add_student_fundingBody_1']")
	WebElement Student_SelectFB;
	
	@FindBy(xpath = "//input[@id='add_student_rate_1']")
	WebElement Student_RateFB;
	
	//Date Picker
	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement Calendar_NextMonthBtn;
	
	@FindBy(xpath = "//div[text()=14]")
	WebElement Student_course_startDate;
	
	@FindBy(xpath = "//div[text()=29]")
	WebElement Student_course_endDate;

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
	
	@FindBy(xpath = "//h4[text()='Assign Document']")
	WebElement AssignDocPageTitle;
	
	@FindBy(xpath = "(//select[@id='bundle_document_cat'])[1]")
	WebElement selectBundleDropdown;
	
	@FindBy(xpath = "//i[@class='ri-add-line']")
	WebElement AddLineBtn;
	@FindBy(xpath = "//div[@class='docs-area']")
	WebElement Document;
	
	@FindBy(xpath = "//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")
	WebElement PrevButton;
	

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
	public WebElement SaveBtn() {
		return SaveBtn;
	}

	// page details
	public WebElement StudentsModule() {
		return StudentsModule;
	}

	public WebElement addNewBtn() {
		return addNewBtn;
	}

	public WebElement errorMsg() {
		return errorMsg;
	}

	// Add student details
	public WebElement student_firstname() {
		return student_firstname;
	}

	public WebElement student_lastname() {
		return student_lastname;
	}

	public WebElement student_phone() {
		return student_phone;
	}

	public WebElement student_mobile() {
		return student_mobile;
	}

	public WebElement student_RegisteredEmail() {
		return student_RegisteredEmail;
	}

	public WebElement student_address() {
		return student_address;
	}
	
	public WebElement student_dob() {
		return student_dob;
	}
	
	public WebElement Student_Course_Field() {
		return Student_Course_Field;
	}
	public WebElement Student_Course_DD_Option() {
		return Student_Course_DD_Option;
	}
	public WebElement Student_Institution_DD_Option() {
		return Student_Institution_DD_Option;
	}
	public WebElement Student_Organisation_DD_Option() {
		return Student_Organisation_DD_Option;
	}
	public WebElement Student_Institution_Field() {
		return Student_Institution_Field;
	}
	public WebElement Student_Organisation_Field() {
		return Student_Organisation_Field;
	}
	
	public WebElement SelectSupportStaff() {
		return SelectSupportStaff;
	}
	
	public WebElement Student_PlannedHoursField() {
		return Student_PlannedHoursField;
	}
	
	public WebElement Student_Support_EndDate() {
		return Student_Support_EndDate;
	}
	
	public WebElement Student_Support_StartDate() {
		return Student_Support_StartDate;
	}
	
	public WebElement Student_SelectRole_Rate() {
		return Student_SelectRole_Rate;
	}
	
	public WebElement Student_SelectFB() {
		return Student_SelectFB;
	}
	
	public WebElement Student_RateFB() {
		return Student_RateFB;
	}
	
	
	public WebElement Calendar_NextMonthBtn() {
		return Calendar_NextMonthBtn;
	}
	
	
	public WebElement SelectSupportType() {
		return SelectSupportType;
	}
	
	public WebElement Student_course_startDate() {
		return Student_course_startDate;
	}
	
	public WebElement Student_course_endDate() {
		return Student_course_endDate;
	}
	
	
	public WebElement searchField() {
		return searchField;
	}
	
	public WebElement statusBtn() {
		return statusBtn;
	}
	
	public WebElement editBtn() {
		return editBtn;
	}
	
	public WebElement deleteBtn() {
		return deleteBtn;
	}
	
	public WebElement cnfrmYesBtn() {
		return cnfrmYesBtn;
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
	
	public WebElement PrevButton() {
		return PrevButton;
	}
}
