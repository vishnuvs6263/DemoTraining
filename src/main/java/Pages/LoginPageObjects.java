package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath= "//button[@type='submit']")WebElement LoginBtn;
	@FindBy(xpath= "//input[@name='username']")WebElement UsernameField;
	@FindBy(xpath= "//input[@name='password']")WebElement PasswordField;
	@FindBy(xpath= "//input[@placeholder='Enter Code']")WebElement OTPField;
	@FindBy(xpath= "//div[@class='d-inline-block font-weight-600']")WebElement getUserName;
	
	public WebElement LoginBtn()
	{
		return LoginBtn;
	}
	
	public WebElement UsernameField()
	{
		return UsernameField;
	}
	
	public WebElement PasswordField()
	{
		return PasswordField;
	}
	
	public WebElement OTPField()
	{
		return OTPField;
	}
	
	public WebElement getUserName()
	{
		return getUserName;
	}
	
	@FindBy(xpath= "(//h2[text()='Payments'])[2]")WebElement PaymentsModule;
	@FindBy(xpath= "//span[text()='Maintain a service provider beneficiary']")WebElement AddBillerBtn;
	@FindBy(xpath= "//select[@name='merchant']")WebElement SelectMerchantDropDown;
	@FindBy(xpath= "//input[@name='serviceNumber']")WebElement AccountNumberField;
	@FindBy(xpath= "//input[@name='shortName']")WebElement ShortNameField;
	@FindBy(xpath= "//p[text()='Submit']")WebElement SubmitBtn;
	
	public WebElement PaymentsModule()
	{
		return PaymentsModule;
	}
	
	public WebElement AddBillerBtn()
	{
		return AddBillerBtn;
	}
	
	public WebElement SelectMerchantDropDown()
	{
		return SelectMerchantDropDown;
	}
	
	public WebElement AccountNumberField()
	{
		return AccountNumberField;
	}
	
	public WebElement ShortNameField()
	{
		return ShortNameField;
	}
	public WebElement SubmitBtn()
	{
		return SubmitBtn;
	}

}
