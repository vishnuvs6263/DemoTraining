package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver ;
	
	public LogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Select user type for login
	@FindBy(xpath= "//li[@class='nav-item dropdown']")WebElement ViewUserBtn;
	@FindBy(xpath= "//span[text()='Logout']")WebElement LogoutBtn;
	
	//Common
		@FindBy(xpath= "//img[@class='brand-logo']")WebElement HomeBtn;
		@FindBy(xpath= "//img[@alt='dsa-logo']")List <WebElement> DSALogo;
	public WebElement ViewUserBtn()
	{
		return ViewUserBtn;
	}
	
	public WebElement LogoutBtn()
	{
		return LogoutBtn;
	}
	
	public WebElement HomeBtn()
	{
		return HomeBtn;
	}
	
	public List <WebElement> DSALogo()
	{
		return DSALogo;
	}
}
