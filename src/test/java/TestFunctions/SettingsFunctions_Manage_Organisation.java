package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_Organisation extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(priority =1)
	public void addOrganisation() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OrganisationSubModule()));
		objects.OrganisationSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterOrganisationNameField()));
		objects.EnterOrganisationNameField().sendKeys(prop.getProperty("OrganisationName"));
		objects.EnterOrganisationDescField().sendKeys(prop.getProperty("OrganisationDesc"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Organisation created successfully.")) {
			Assert.assertEquals(toastsuccessMessage, "Organisation created successfully.");
			System.out.println("Verify create organisation executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
		Thread.sleep(3000);
		objects.searchField().sendKeys(prop.getProperty("OrganisationName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("OrganisationName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("OrganisationName"));
			System.out.println(
					"Verify organisation list executed & passed successfully!!!   New organisation added is "
							+ addedentry);

		} else {
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
			
	}
	
	@Test(priority =2, dependsOnMethods = { "addOrganisation" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OrganisationSubModule()));
		objects.OrganisationSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("OrganisationName"));
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
	@Test(priority =3, dependsOnMethods = { "addOrganisation" }, alwaysRun = true)
	public void editOrganisation() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OrganisationSubModule()));
		objects.OrganisationSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("OrganisationName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterOrganisationNameField()));
		objects.EnterOrganisationNameField().clear();
		objects.EnterOrganisationNameField().sendKeys(prop.getProperty("OrganisationNameEdited"));
		objects.EnterOrganisationDescField().clear();
		objects.EnterOrganisationDescField().sendKeys(prop.getProperty("OrganisationDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedOrganisationName = objects.entrySearched().getText();
		String editedOrganisationDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Organisation updated successfully.")) {
			Assert.assertEquals(toastMessage, "Organisation updated successfully.");
			System.out.println(
					"Verify update Organisation details  executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		objects.toastCloseBtn().click();
		
		if (editedOrganisationName.contentEquals(prop.getProperty("OrganisationNameEdited"))) {
			Assert.assertEquals(editedOrganisationName, prop.getProperty("OrganisationNameEdited"));
			System.out.println(
					"Verify edit Organisation name  executed & passed successfully!!!   Updated Organisation name is "
							+ editedOrganisationName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		if (editedOrganisationDesc.contentEquals(prop.getProperty("OrganisationDescEdited"))) {
			Assert.assertEquals(editedOrganisationDesc, prop.getProperty("OrganisationDescEdited"));
			System.out.println(
					"Verify edit Organisation description  executed & passed successfully!!!   Updated Organisation description is "
							+ editedOrganisationDesc);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
	}
	@Test(priority =4, dependsOnMethods = { "editOrganisation" }, alwaysRun = true)
	public void deleteOrganisation() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OrganisationSubModule()));
		objects.OrganisationSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("OrganisationNameEdited"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastDeleteMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastDeleteMessage);
		if (toastDeleteMessage.contentEquals("Organisation deleted successfully.")) {
			Assert.assertEquals(toastDeleteMessage, "Organisation deleted successfully.");
			System.out.println(
					"Verify delete Organisation details  executed & passed successfully!!!  "
							+ toastDeleteMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}
}
