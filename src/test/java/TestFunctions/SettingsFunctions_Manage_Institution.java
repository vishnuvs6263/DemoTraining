package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_Institution extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(priority =1)
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
		
		Thread.sleep(3000);
		objects.searchField().sendKeys(prop.getProperty("InstitutionName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("InstitutionName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("InstitutionName"));
			System.out.println(
					"Verify institution list executed & passed successfully!!!   New institution added is "
							+ addedentry);

		} else {
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
	}
	
	@Test(priority =2, dependsOnMethods = { "addInstitution" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.InstitutionSubModule()));
		objects.InstitutionSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("InstitutionName"));
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
			if (statusUpdatedText.contentEquals("Disabled")) {
				Assert.assertEquals(statusUpdatedText, "Disabled"
						+ "");
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
	@Test(priority =3, dependsOnMethods = { "addInstitution" }, alwaysRun = true)
	public void editInstitution() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.InstitutionSubModule()));
		objects.InstitutionSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("InstitutionName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterInstitutionNameField()));
		objects.EnterInstitutionNameField().clear();
		objects.EnterInstitutionNameField().sendKeys(prop.getProperty("InstitutionNameEdited"));
		objects.EnterInstitutionDescField().clear();
		objects.EnterInstitutionDescField().sendKeys(prop.getProperty("InstitutionDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedInstitutionName = objects.entrySearched().getText();
		String editedInstitutionDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Institution updated successfully")) {
			Assert.assertEquals(toastMessage, "Institution updated successfully");
			System.out.println(
					"Verify update institution details  executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		objects.toastCloseBtn().click();
		
		if (editedInstitutionName.contentEquals(prop.getProperty("InstitutionNameEdited"))) {
			Assert.assertEquals(editedInstitutionName, prop.getProperty("InstitutionNameEdited"));
			System.out.println(
					"Verify edit institution name  executed & passed successfully!!!   Updated institution name is "
							+ editedInstitutionName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		if (editedInstitutionDesc.contentEquals(prop.getProperty("InstitutionDescEdited"))) {
			Assert.assertEquals(editedInstitutionDesc, prop.getProperty("InstitutionDescEdited"));
			System.out.println(
					"Verify edit institution description  executed & passed successfully!!!   Updated institution description is "
							+ editedInstitutionDesc);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
	}
	@Test(priority =4, dependsOnMethods = { "editInstitution" }, alwaysRun = true)
	public void deleteInstitution() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.InstitutionSubModule()));
		objects.InstitutionSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("InstitutionNameEdited"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastDeleteMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastDeleteMessage);
		if (toastDeleteMessage.contentEquals("Institution deleted successfully")) {
			Assert.assertEquals(toastDeleteMessage, "Institution deleted successfully");
			System.out.println(
					"Verify delete institution details  executed & passed successfully!!!  "
							+ toastDeleteMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}
}
