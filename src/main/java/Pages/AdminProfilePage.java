package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminProfilePage {
	
WebDriver driver ;
	
	public AdminProfilePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Select user type for login
	//Verify signed in user
	@FindBy(xpath= "//a[@id='admin_profile']")WebElement ProfileModule;
	//Fields new
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[1]")WebElement FirstName;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[2]")WebElement LastName;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[3]")WebElement DOB;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[4]")WebElement Organisation;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[5]")WebElement Mobile;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[6]")WebElement SFEmail;
	@FindBy(xpath= "(//p[@class='sup-des col-8'])[7]")WebElement Address;
	
	//Edit profile button
	@FindBy(xpath= "//button[@class='edit-profile']")WebElement EditBtn;
	
	
	//Editable fields
	@FindBy(xpath= "//input[@placeholder='Enter first name']")WebElement FirstNameEdit;
	@FindBy(xpath= "//input[@placeholder='Enter last name']")WebElement LastNameEdit;
	@FindBy(xpath= "//input[@name='dateOfBirth']")WebElement DOBEdit;
	@FindBy(xpath= "//input[@placeholder='Enter mobile']")WebElement MobileEdit;
	@FindBy(xpath= "//input[@placeholder='Enter sfe registered email']")WebElement SFEmailEdit;
	@FindBy(xpath= "//textarea[@placeholder='Enter Address']")WebElement AddressEdit;
	
	//update button
	@FindBy(xpath= "//button[@id='popup_undefined_submit']")WebElement ProfileUpdateBtn;
	
	//Edit success message
	@FindBy(xpath= "//div[@class='toast-message']")WebElement EditSuccessMessage;
	
	//Common
		@FindBy(xpath= "//img[@class='brand-logo']")WebElement HomeBtn;
		@FindBy(xpath = "//button[@class='toast-close-button']")
		WebElement toastCloseBtn;
	
	public WebElement ProfileModule()
	{
		return ProfileModule;
	}
	public WebElement FirstName()
	{
		return FirstName;
	}
	public WebElement LastName()
	{
		return LastName;
	}
	public WebElement DOB()
	{
		return DOB;
	}
	public WebElement Organisation()
	{
		return Organisation;
	}
	public WebElement Mobile()
	{
		return Mobile;
	}
	public WebElement SFEmail()
	{
		return SFEmail;
	}
	public WebElement Address()
	{
		return Address;
	}
	public WebElement EditBtn()
	{
		return EditBtn;
	}
	public WebElement FirstNameEdit()
	{
		return FirstNameEdit;
	}
	public WebElement LastNameEdit()
	{
		return LastNameEdit;
	}
	public WebElement DOBEdit()
	{
		return DOBEdit;
	}

	public WebElement MobileEdit()
	{
		return MobileEdit;
	}
	public WebElement SFEmailEdit()
	{
		return SFEmailEdit;
	}
	public WebElement AddressEdit()
	{
		return AddressEdit;
	}
	
	public WebElement ProfileUpdateBtn()
	{
		return ProfileUpdateBtn;
	}
	public WebElement EditSuccessMessage()
	{
		return EditSuccessMessage;
	}
	
	public WebElement HomeBtn()
	{
		return HomeBtn;
	}
	
	public WebElement toastCloseBtn()
	{
		return toastCloseBtn;
	}
}
