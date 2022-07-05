package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_FundingBody extends BaseClass {
	
	public static WebDriverWait wait;
	public static Select select;
	@Test(priority =1)
	public void addFundingBody() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FundingBodySubModule()));
		objects.FundingBodySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterFundingBodyName()));
		objects.EnterFundingBodyName().sendKeys(prop.getProperty("FBName"));
		objects.EnterFundingBodyDesc().sendKeys(prop.getProperty("FBDesc"));
objects.EnterFundingBodyAddress().sendKeys(prop.getProperty("FBAdress"));
		
		select = new Select(objects.SelectFBCountry()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("FBCountry"));
		Thread.sleep(1000);
		
		objects.SelectFBCounty().click();
		Thread.sleep(2000);
		objects.SelectFBCountyOption().click();
		Thread.sleep(2000);
		objects.EnterFundingBodyCity().sendKeys(prop.getProperty("FBCity"));
		objects.EnterFundingBodyPin().sendKeys(prop.getProperty("FBPinCode"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastsuccessMessage);
		if (toastsuccessMessage.contentEquals("Funding Body created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Funding Body created successfully");
			System.out.println("Verify create funding body executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		else if (toastsuccessMessage.contentEquals("Funding body name already exists!")) {
			Assert.assertEquals(toastsuccessMessage, "Funding body name already exists!");
			System.out.println("Verify create institution executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
		Thread.sleep(3000);
		objects.searchField().sendKeys(prop.getProperty("FBName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("FBName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("FBName"));
			System.out.println(
					"Verify funding body list executed & passed successfully!!!   New institution added is "
							+ addedentry);

		} else {
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
	}
	
	@Test(priority =2, dependsOnMethods = { "addFundingBody" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FundingBodySubModule()));
		objects.FundingBodySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("FBName"));
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
				Assert.assertEquals(statusUpdatedText, "Disabled");
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
	@Test(priority =3, dependsOnMethods = { "addFundingBody" }, alwaysRun = true)
	public void editFundingBody() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FundingBodySubModule()));
		objects.FundingBodySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("FBName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterFundingBodyName()));
		objects.EnterFundingBodyName().clear();
		objects.EnterFundingBodyName().sendKeys(prop.getProperty("FBNameEdited"));
		objects.EnterFundingBodyDesc().clear();
		objects.EnterFundingBodyDesc().sendKeys(prop.getProperty("FBDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedInstitutionName = objects.entrySearched().getText();
		String editedInstitutionDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Funding Body updated successfully")) {
			Assert.assertEquals(toastMessage, "Funding Body updated successfully");
			System.out.println(
					"Verify update Funding Body executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		objects.toastCloseBtn().click();
		
		
		
	}
	@Test(priority =4, dependsOnMethods = { "editFundingBody" }, alwaysRun = true)
	public void deleteFundingBody() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FundingBodySubModule()));
		objects.FundingBodySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("FBNameEdited"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastDeleteMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastDeleteMessage);
		if (toastDeleteMessage.contentEquals("Successfully deleted funding body")) {
			Assert.assertEquals(toastDeleteMessage, "Successfully deleted funding body");
			System.out.println(
					"Verify delete Funding Body executed & passed successfully!!!  "
							+ toastDeleteMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}
}
