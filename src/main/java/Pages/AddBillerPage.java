package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBillerPage {
	WebDriver driver;

	public AddBillerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath= "(//h2[text()='Payments'])[2]")WebElement PaymentsModule;
	@FindBy(xpath= "(.//*[normalize-space(text()) and normalize-space(.)='ZMW'])[2]/following::h3[1]")WebElement AddBillerBtn;
	@FindBy(xpath= "//select[@name='merchant']")WebElement SelectMerchantDropDown;
	@FindBy(xpath= "//input[@name='serviceNumber']")WebElement AccountNumberField;
	@FindBy(xpath= "//input[@name='shortName']")WebElement ShortNameField;
	@FindBy(xpath= "//p[text()='Submit']")WebElement SubmitBtn;
	@FindBy(xpath= "//p[@class='mt-4 text-secondary']")WebElement VerifySuccessMsg;
	@FindBy(xpath= "//p[@class='my-auto mx-auto']")WebElement DoneBtn;
	@FindBy(xpath= "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/p")WebElement GetUserName;
	@FindBy(xpath= "//div[@class='back-cancel-style']")WebElement DeleteBtn;
	@FindBy(xpath= "//p[@class='my-auto mx-auto']")WebElement CnfrmBtn;
	
	public WebElement VerifySuccessMsg()
	{
		return VerifySuccessMsg;
	}
	
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

	public WebElement GetUserName()
	{
		return GetUserName;
	}
	
	public WebElement DeleteBtn()
	{
		return DeleteBtn;
	}
	
	public WebElement DoneBtn()
	{
		return DoneBtn;
	}
	
	public WebElement CnfrmBtn()
	{
		return CnfrmBtn;
	}
}
