package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_SupportType extends BaseClass {
	
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
		
		Thread.sleep(3000);
		objects.searchField().sendKeys(prop.getProperty("SupportTypeName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("SupportTypeName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("SupportTypeName"));
			System.out.println(
					"Verify SupportType list executed & passed successfully!!!   New SupportType added is "
							+ addedentry);

		} else {
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
	}
	
	@Test(priority =2, dependsOnMethods = { "addSupportType" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SupportTypeSubModule()));
		objects.SupportTypeSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("SupportTypeName"));
		String statusText = objects.statusBtn().getText();
		Thread.sleep(2000);
		objects.statusBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Status updated successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Status updated successfully");
			System.out.println("Verify update status executed and passed successfully!!!   "+toastsuccessMessage);
			
			String statusUpdatedText = objects.statusBtn().getText();
			if (statusUpdatedText.contentEquals("Disable")) {
				Assert.assertEquals(statusUpdatedText, "Disable");
				System.out.println(
						"Verify update status functionality executed & passed successfully!!!   Updated status is "
								+ statusUpdatedText);

			} else {
				Assert.fail();
				System.out.println("Test failure observed");
			}
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		
		
	}
	@Test(priority =3, dependsOnMethods = { "addSupportType" }, alwaysRun = true)
	public void editSupportType() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SupportTypeSubModule()));
		objects.SupportTypeSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("SupportTypeName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterSupportTypeNameField()));
		objects.EnterSupportTypeNameField().clear();
		objects.EnterSupportTypeNameField().sendKeys(prop.getProperty("SupportTypeNameEdited"));
		objects.EnterSupportTypeDescField().clear();
		objects.EnterSupportTypeDescField().sendKeys(prop.getProperty("SupportTypeDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedSupportTypeName = objects.entrySearched().getText();
		String editedSupportTypeDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Support type updated successfully")) {
			Assert.assertEquals(toastMessage, "Support type updated successfully");
			System.out.println(
					"Verify update SupportType details  executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		objects.toastCloseBtn().click();
		
		if (editedSupportTypeName.contentEquals(prop.getProperty("SupportTypeNameEdited"))) {
			Assert.assertEquals(editedSupportTypeName, prop.getProperty("SupportTypeNameEdited"));
			System.out.println(
					"Verify edit SupportType name  executed & passed successfully!!!   Updated SupportType name is "
							+ editedSupportTypeName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		if (editedSupportTypeDesc.contentEquals(prop.getProperty("SupportTypeDescEdited"))) {
			Assert.assertEquals(editedSupportTypeDesc, prop.getProperty("SupportTypeDescEdited"));
			System.out.println(
					"Verify edit SupportType description  executed & passed successfully!!!   Updated SupportType description is "
							+ editedSupportTypeDesc);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
	}
	
}
