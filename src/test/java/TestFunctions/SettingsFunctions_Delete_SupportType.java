package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Delete_SupportType extends BaseClass {
	
	public static WebDriverWait wait;
	
	@Test
	public void deleteSupportType() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SupportTypeSubModule()));
		objects.SupportTypeSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("SupportTypeName"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		objects.toastCloseBtn().click();
		Thread.sleep(2000);
		
	}
}
