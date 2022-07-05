package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignDocPage {
	WebDriver driver;

	public AssignDocPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common
	@FindBy(xpath = "//h4[text()='Assign Document']")
	WebElement AssignDocPageTitle;
	@FindBy(xpath = "//button[@class='save-btn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[@class='toast-close-button']")
	WebElement toastCloseBtn;
	
	@FindBy(xpath = "(//select[@id='bundle_document_cat'])[1]")
	WebElement selectBundleDropdown;
	
	@FindBy(xpath = "//i[@class='ri-add-line']")
	WebElement AddLineBtn;
	
	
	
	
	// common
	public WebElement AssignDocPageTitle() {
		return AssignDocPageTitle;
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
	
	public WebElement selectBundleDropdown() {
		return selectBundleDropdown;
	}
	
	public WebElement AddLineBtn() {
		return AddLineBtn;
	}
	

}
