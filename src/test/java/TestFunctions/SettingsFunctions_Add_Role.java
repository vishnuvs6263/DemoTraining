package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_Role extends BaseClass {
	
	public static WebDriverWait wait;
	@Test
	public void addRole() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.RoleSubModule()));
		objects.RoleSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterRoleNameField()));
		objects.EnterRoleNameField().sendKeys(prop.getProperty("RoleName"));
		objects.EnterRoleDescField().sendKeys(prop.getProperty("RoleDesc"));
		Select select = new Select(objects.SelectSupportType()); 
		select.selectByVisibleText(prop.getProperty("SupportTypeName"));
		objects.SaveBtn().click();
		
	}
}
