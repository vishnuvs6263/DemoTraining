package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
	WebDriver driver;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Select module
	@FindBy(xpath = "//a[@id='admin_settings']")
	WebElement SettingsModule;
	// Common items
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//button[@class='close-btn']")
	WebElement windowCloseBtn;
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
	@FindBy(xpath = "(//tbody/tr/td)[2]")
	WebElement entrySearched;
	@FindBy(xpath = "(//tbody/tr/td)[3]")
	WebElement entrydescSearched;
	@FindBy(xpath = "//i[@class='fa fa-thumbs-down']")
	WebElement noentryFound;
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	@FindBy(xpath = "//span[@class='add-new']")
	WebElement AddNew;
	@FindBy(xpath = "//i[@class='ri-add-line']")
	WebElement AddLineBtn;


	// Course
	@FindBy(xpath = "//a[text()='Course of Study']")
	WebElement CourseSubModule;
	@FindBy(xpath = "//input[@id='settings_course_coursename']")
	WebElement EnterCourseNameField;
	@FindBy(xpath = "//input[@placeholder='Enter description']")
	WebElement EnterCourseDescField;

	// Institution
	@FindBy(xpath = "//a[text()='Institution']")
	WebElement InstitutionSubModule;
	@FindBy(xpath = "//input[@id='settings_institution_institutionname']")
	WebElement EnterInstitutionNameField;
	@FindBy(xpath = "//input[@id='settings_institution_description']")
	WebElement EnterInstitutionDescField;

	// Organisation
	@FindBy(xpath = "//a[text()='Organisation']")
	WebElement OrganisationSubModule;
	@FindBy(xpath = "//input[@id='settings_organisation_orgName']")
	WebElement EnterOrganisationNameField;
	@FindBy(xpath = "//input[@id='settings_organisation_description']")
	WebElement EnterOrganisationDescField;

	// Support Type
	@FindBy(xpath = "//a[text()='Support Type']")
	WebElement SupportTypeSubModule;
	@FindBy(xpath = "//input[@id='settings_supporttype_supporttypename']")
	WebElement EnterSupportTypeNameField;
	@FindBy(xpath = "//input[@id='settings_supporttype_description']")
	WebElement EnterSupportTypeDescField;

	// Role
	@FindBy(xpath = "//a[text()='Role']")
	WebElement RoleSubModule;
	@FindBy(xpath = "//input[@id='settings_role_rolename']")
	WebElement EnterRoleNameField;
	@FindBy(xpath = "//input[@id='settings_role_description']")
	WebElement EnterRoleDescField;
	@FindBy(xpath = "//select[@id='settings_role_supporttype']")
	WebElement SelectSupportType;

	// Document Category
	@FindBy(xpath = "//a[text()='Document Category']")
	WebElement DocumentCategorySubModule;
	@FindBy(xpath = "//input[@id='settings_doccat_documentname']")
	WebElement EnterDocumentCategoryNameField;
	
	// Document File
		@FindBy(xpath = "//a[text()='Document File']")
		WebElement DocumentFileSubModule;
		
		@FindBy(xpath = "//select[@id='settings_document_cat']")
		WebElement SelectDocumentCategoryDropDown;
		@FindBy(xpath = "//input[@id='settings_docfile_name']")
		WebElement EnterDocumentFileNameField;
		@FindBy(xpath = "//p[contains(.,'Select a file')]")
		WebElement BrowseFile;
		
		@FindBy(xpath = "//input[@id='file-9-0']")
		WebElement UploadFile;
		
		@FindBy(xpath = "//button[@class='version-btn']")
		WebElement editVersionBtn;
		@FindBy(xpath = "//textarea[@class='version-description form-control']")
		WebElement versionDescriptionField;
		@FindBy(xpath = "//div[@id='root']/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/label/span")
		WebElement root;
		@FindBy(xpath = "//input[@id='versionFile']")
		WebElement chooseFile;
		@FindBy(xpath = "//button[@id='settings_docfile_update_submit']")
		WebElement submitBtn;
		
		
		//File Bundling
		@FindBy(xpath = "//a[text()='File Bundling']")
		WebElement FileBundlingSubModule;
		@FindBy(xpath = "//input[@id='settings_bundle_name']")
		WebElement EnterFileBundlingName;
		@FindBy(xpath = "//input[@id='settings_bundle_desc']")
		WebElement EnterFileBundlingDesc;
		@FindBy(xpath = "//select[@id='bundle_document_cat']")
		WebElement SelectBundleDocumentCategoryDropDown;
		@FindBy(xpath = "(//span[@class='checkmark doc-check-checkbox'])[1]")
		WebElement CheckBox_Assign;
		@FindBy(xpath = "(//span[@class='checkmark doc-check-checkbox'])[2]")
		WebElement CheckBox_TobeSignoff;

		//Funding Body
		@FindBy(xpath = "//a[text()='Funding Body']")
		WebElement FundingBodySubModule;
		@FindBy(xpath = "//input[@id='settings_fb_name']")
		WebElement EnterFundingBodyName;
		@FindBy(xpath = "//input[@id='settings_fb_description']")
		WebElement EnterFundingBodyDesc;
		
		@FindBy(xpath = "//input[@id='org_address_street1']")
		WebElement EnterFundingBodyAddress;
		
		@FindBy(xpath = "//select[@id='org_country']")
		WebElement SelectFBCountry;
		
		@FindBy(xpath = "//div[@id='org_state']")
		WebElement SelectFBCounty;
		@FindBy(xpath = "//div[@id='react-select-2-option-0']")
		WebElement SelectFBCountyOption;
		
		@FindBy(xpath = "//input[@id='org_city']")
		WebElement EnterFundingBodyCity;
		
		@FindBy(xpath = "//input[@id='org_postCode']")
		WebElement EnterFundingBodyPin;
		
		@FindBy(xpath = "//a[@id='admin_settings_question']")
		WebElement ReviewQuestionsSubModule;

		@FindBy(xpath = "//input[@id='settings_question_tname']")
		WebElement EnterQuestionName;
		
	

		public WebElement windowCloseBtn() {
			return windowCloseBtn;
		}
	public WebElement SettingsModule() {
		return SettingsModule;
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

	public WebElement entrySearched() {
		return entrySearched;
	}

	public WebElement entrydescSearched() {
		return entrydescSearched;
	}

	public WebElement noentryFound() {
		return noentryFound;
	}

	public WebElement HomeBtn() {
		return HomeBtn;
	}

	public WebElement AddNew() {
		return AddNew;
	}
	
	public WebElement AddLineBtn() {
		return AddLineBtn;
	}
	

	
	

	public WebElement CourseSubModule() {
		return CourseSubModule;
	}

	public WebElement EnterCourseNameField() {
		return EnterCourseNameField;
	}

	public WebElement EnterCourseDescField() {
		return EnterCourseDescField;
	}

	public WebElement InstitutionSubModule() {
		return InstitutionSubModule;
	}

	public WebElement EnterInstitutionNameField() {
		return EnterInstitutionNameField;
	}

	public WebElement EnterInstitutionDescField() {
		return EnterInstitutionDescField;
	}

	public WebElement OrganisationSubModule() {
		return OrganisationSubModule;
	}

	public WebElement EnterOrganisationNameField() {
		return EnterOrganisationNameField;
	}

	public WebElement EnterOrganisationDescField() {
		return EnterOrganisationDescField;
	}

	public WebElement SupportTypeSubModule() {
		return SupportTypeSubModule;
	}

	public WebElement EnterSupportTypeNameField() {
		return EnterSupportTypeNameField;
	}

	public WebElement EnterSupportTypeDescField() {
		return EnterSupportTypeDescField;
	}

	public WebElement RoleSubModule() {
		return RoleSubModule;
	}

	public WebElement EnterRoleNameField() {
		return EnterRoleNameField;
	}

	public WebElement EnterRoleDescField() {
		return EnterRoleDescField;
	}

	public WebElement SelectSupportType() {
		return SelectSupportType;
	}
	
	public WebElement DocumentCategorySubModule() {
		return DocumentCategorySubModule;
	}
	
	public WebElement EnterDocumentCategoryNameField() {
		return EnterDocumentCategoryNameField;
	}
	
	public WebElement DocumentFileSubModule() {
		return DocumentFileSubModule;
	}
	
	public WebElement SelectDocumentCategoryDropDown() {
		return SelectDocumentCategoryDropDown;
	}
	public WebElement EnterDocumentFileNameField() {
		return EnterDocumentFileNameField;
	}
	
	public WebElement BrowseFile() {
		return BrowseFile;
	}
	public WebElement UploadFile() {
		return UploadFile;
	}
	public WebElement FileBundlingSubModule() {
		return FileBundlingSubModule;
	}
	public WebElement EnterFileBundlingName() {
		return EnterFileBundlingName;
	}
	public WebElement EnterFileBundlingDesc() {
		return EnterFileBundlingDesc;
	}
	public WebElement SelectBundleDocumentCategoryDropDown() {
		return SelectBundleDocumentCategoryDropDown;
	}
	
	public WebElement CheckBox_Assign() {
		return CheckBox_Assign;
	}
	public WebElement CheckBox_TobeSignoff() {
		return CheckBox_TobeSignoff;
	}
	public WebElement FundingBodySubModule() {
		return FundingBodySubModule;
	}
	public WebElement EnterFundingBodyName() {
		return EnterFundingBodyName;
	}
	public WebElement EnterFundingBodyDesc() {
		return EnterFundingBodyDesc;
	}
	public WebElement editVersionBtn() {
		return editVersionBtn;
	}
	public WebElement versionDescriptionField() {
		return versionDescriptionField;
	}
	public WebElement chooseFile() {
		return chooseFile;
	}
	public WebElement submitBtn() {
		return submitBtn;
	}
	
	public WebElement EnterFundingBodyAddress() {
		return EnterFundingBodyAddress;
	}
	
	public WebElement SelectFBCountry() {
		return SelectFBCountry;
	}
	
	public WebElement SelectFBCounty() {
		return SelectFBCounty;
	}
	
	public WebElement SelectFBCountyOption() {
		return SelectFBCountyOption;
	}
	
	public WebElement EnterFundingBodyCity() {
		return EnterFundingBodyCity;
	}
	
	public WebElement EnterFundingBodyPin() {
		return EnterFundingBodyPin;
	}
	
	public WebElement root() {
		return root;
	}
	public WebElement ReviewQuestionsSubModule() {
		return ReviewQuestionsSubModule;
	}
	public WebElement EnterQuestionName() {
		return EnterQuestionName;
	}
	


}
