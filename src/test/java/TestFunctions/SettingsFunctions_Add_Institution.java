package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_Institution extends BaseClass {
	
	public static WebDriverWait wait;
	@Test
	public void addInstitution() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.InstitutionSubModule()));
		objects.InstitutionSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterInstitutionNameField()));
		objects.EnterInstitutionNameField().sendKeys(prop.getProperty("InstitutionName"));
		objects.EnterInstitutionDescField().sendKeys(prop.getProperty("InstitutionDesc"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Institution created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Institution created successfully");
			System.out.println("Verify create institution executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		else if (toastsuccessMessage.contentEquals("Institution already exists")) {
			Assert.assertEquals(toastsuccessMessage, "Institution already exists");
			System.out.println("Verify create institution executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
	}
}
