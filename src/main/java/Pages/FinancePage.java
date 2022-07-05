package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancePage {
	WebDriver driver;

	public FinancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//img[@class='brand-logo']")
	WebElement HomeBtn;
	
	@FindBy(xpath= "//button[@id='modal_close']")WebElement closeBtn;

	// Page details
	@FindBy(xpath = "//a[@id='staff_finance']")
	WebElement FinanceModule;
	
	@FindBy(xpath = "(//p[@class='field-value'])[2]")
	WebElement getHoursWorksedGeneric;
	
	@FindBy(xpath = "(//p[@class='field-value'])[3]")
	WebElement getAmountEarnedGeneric;
	
	@FindBy(xpath = "(//td[@role='cell'])[1]")
	WebElement getStudentName;
	@FindBy(xpath = "//td[@class='acion-btns text-center']")
	WebElement viewDetailsBtn;
	
	
	//ViewDetails Page
	@FindBy(xpath = "(//p[@class='sup-des col-4 col-md-6'])[1]")
	WebElement getStudNameDetails;
	
	@FindBy(xpath = "(//p[@class='sup-des col-4 col-md-6'])[4]")
	WebElement getStudEmailDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[3]")
	WebElement getSessionNameDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[4]")
	WebElement getSupportTypeDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[5]")
	WebElement getRoleDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[6]")
	WebElement getLocationDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[7]")
	WebElement getMODDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[11]")
	WebElement getFBDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[12]")
	WebElement getAmountDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[13]")
	WebElement getBreakDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[14]")
	WebElement getTotalHoursDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[15]")
	WebElement getMissedSessionTitleDetails;
	@FindBy(xpath = "(//td[@role='cell'])[18]")
	WebElement getMissedSessionReasonDetails;
	
	@FindBy(xpath = "(//td[@role='cell'])[23]")
	WebElement getMissedAmountDetails;
	@FindBy(xpath = "(//td[@role='cell'])[25]")
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
	public WebElement HomeBtn() {
		return HomeBtn;
	}
	
	public WebElement closeBtn()
	{
		return closeBtn;
	}
	
	public WebElement FinanceModule() {
		return FinanceModule;
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

	public WebElement getStudNameDetails() {
		return getStudNameDetails;
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
