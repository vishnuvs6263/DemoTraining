package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_SupportType extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(priority =1)
	public void addSupportType() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SupportTypeSubModule()));
		objects.SupportTypeSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterSupportTypeNameField()));
		objects.EnterSupportTypeNameField().sendKeys(prop.getProperty("SupportTypeName"));
		objects.EnterSupportTypeDescField().sendKeys(prop.getProperty("SupportTypeDesc"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Support type created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Support type created successfully");
			System.out.println("Verify create SupportType executed and passed successfully!!!   "+toastsuccessMessage);
		}
		else if (toastsuccessMessage.contentEquals("Support type already exists")) {
			Assert.assertEquals(toastsuccessMessage, "Support type already exists");
			System.out.println("Verify create SupportType executed and passed successfully!!!   "+toastsuccessMessage);
		}
		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
	}
}
