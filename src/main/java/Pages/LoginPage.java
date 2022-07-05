package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
WebDriver driver ;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Select user type for login
	@FindBy(xpath= "//div[text()='Admin']")WebElement SelectUserTypeAdmin;
	@FindBy(xpath= "//div[text()='Student']")WebElement SelectUserTypeStudent;
	@FindBy(xpath= "//div[text()='Support Staff']")WebElement SelectUserTypeStaff;
	
	//Email field
	@FindBy(xpath= "(//*[@placeholder='Email'])[1]")WebElement EmailField;
	
	//Password Field
	@FindBy(xpath= "(//*[@placeholder='Password'])[1]")WebElement PasswordField;
	
	//Login Btn
	@FindBy(xpath= "(//button[@class='login-btn'])[1]")WebElement LoginBtn;
	
	//Common
	@FindBy(xpath= "//a[@class='navbar-brand']")WebElement HomeBtn;
	
	//Mandatory fields required text
	@FindBy(xpath= "(//div[text()='*Email is required.'])[1]")WebElement EmailReqText;
	@FindBy(xpath= "(//div[text()='*Password is required.'])[1]")WebElement PasswordReqText;
	@FindBy(xpath= "//div[@class='toast-message']")WebElement ToastMessage;
	
	//Verify signed in user
	@FindBy(xpath= "//a[@id='admin_profile']")WebElement ProfileModule;
	@FindBy(xpath= "//a[@id='staff_profile']")WebElement StaffProfileModule;
	@FindBy(xpath= "//a[@id='student_profile']")WebElement StudentProfileModule;
	@FindBy(xpath= "//p[@class='stu-subtext']")WebElement UserEmail;
	@FindBy(xpath= "//p[@class='student-name']")WebElement UserName;
	
	//Reset password
	@FindBy(xpath= "//input[@id='resetpswd_newPassword']")WebElement set_NewPwd;
	@FindBy(xpath= "//input[@id='resetpswd_confirm_pswd']")WebElement set_CnfrmPwd;
	@FindBy(xpath= "//button[@id='resetpswd_submit']")WebElement subBtn;
	@FindBy(xpath= "//button[@id='signdoc_accept']")WebElement agreeDocs;
	@FindBy(xpath= "//button[@id='signdoc_accept']")List<WebElement> agreeDocsCount;
	
	public List<WebElement> agreeDocsCount()
	{
		return agreeDocsCount;
	}
	
	public WebElement SelectUserTypeAdmin()
	{
		return SelectUserTypeAdmin;
	}
	
	public WebElement SelectUserTypeStudent()
	{
		return SelectUserTypeStudent;
	}
	
	public WebElement SelectUserTypeStaff()
	{
		return SelectUserTypeStaff;
	}
	
	public WebElement EmailField()
	{
		return EmailField;
	}
	
	public WebElement PasswordField()
	{
		return PasswordField;
	}
	
	public WebElement LoginBtn()
	{
		return LoginBtn;
	}
	
	public WebElement EmailReqText()
	{
		return EmailReqText;
	}
	public WebElement PasswordReqText()
	{
		return PasswordReqText;
	}
	
	public WebElement ToastMessage()
	{
		return ToastMessage;
	}
	
	public WebElement ProfileModule()
	{
		return ProfileModule;
	}
	
	public WebElement UserEmail()
	{
		return UserEmail;
	}
	
	public WebElement UserName()
	{
		return UserName;
	}
	
	//Reset password
	public WebElement set_NewPwd()
	{
		return set_NewPwd;
	}
	public WebElement set_CnfrmPwd()
	{
		return set_CnfrmPwd;
	}
	
	public WebElement subBtn()
	{
		return subBtn;
	}
	
	public WebElement agreeDocs()
	{
		return agreeDocs;
	}
	public WebElement StaffProfileModule()
	{
		return StaffProfileModule;
	}
	
	public WebElement StudentProfileModule()
	{
		return StudentProfileModule;
	}
}
