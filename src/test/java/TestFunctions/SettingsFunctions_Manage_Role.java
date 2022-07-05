package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_Role extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(priority =1)
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
		select.selectByVisibleText(prop.getProperty("SupportTypeName"));;
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Role created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Role created successfully");
			System.out.println("Verify create Role executed and passed successfully!!!   "+toastsuccessMessage);
		}
		else if (toastsuccessMessage.contentEquals("Role already exists")) {
			Assert.assertEquals(toastsuccessMessage, "Role already exists");
			System.out.println("Verify create Role executed and passed successfully!!!   "+toastsuccessMessage);
		}
		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
		Thread.sleep(3000);
		objects.searchField().sendKeys(prop.getProperty("RoleName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("RoleName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("RoleName"));
			System.out.println(
					"Verify Role list executed & passed successfully!!!   New Role added is "
							+ addedentry);

		} else {
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
	}
	
	@Test(priority =2, dependsOnMethods = { "addRole" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.RoleSubModule()));
		objects.RoleSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("RoleName"));
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
	@Test(priority =3, dependsOnMethods = { "addRole" }, alwaysRun = true)
	public void editRole() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.RoleSubModule()));
		objects.RoleSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("RoleName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterRoleNameField()));
		objects.EnterRoleNameField().clear();
		objects.EnterRoleNameField().sendKeys(prop.getProperty("RoleNameEdited"));
		objects.EnterRoleDescField().clear();
		objects.EnterRoleDescField().sendKeys(prop.getProperty("RoleDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedRoleName = objects.entrySearched().getText();
		String editedRoleDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Role updated successfully")) {
			Assert.assertEquals(toastMessage, "Role updated successfully");
			System.out.println(
					"Verify update Role details  executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		objects.toastCloseBtn().click();
		
		if (editedRoleName.contentEquals(prop.getProperty("RoleNameEdited"))) {
			Assert.assertEquals(editedRoleName, prop.getProperty("RoleNameEdited"));
			System.out.println(
					"Verify edit Role name  executed & passed successfully!!!   Updated Role name is "
							+ editedRoleName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		if (editedRoleDesc.contentEquals(prop.getProperty("RoleDescEdited"))) {
			Assert.assertEquals(editedRoleDesc, prop.getProperty("RoleDescEdited"));
			System.out.println(
					"Verify edit Role description  executed & passed successfully!!!   Updated Role description is "
							+ editedRoleDesc);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
	}
	@Test(priority =4, dependsOnMethods = { "editRole" }, alwaysRun = true)
	public void deleteRole() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.RoleSubModule()));
		objects.RoleSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("RoleNameEdited"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastDeleteMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastDeleteMessage);
		if (toastDeleteMessage.contentEquals("Role deleted successfully")) {
			Assert.assertEquals(toastDeleteMessage, "Role deleted successfully");
			System.out.println(
					"Verify delete Role details  executed & passed successfully!!!  "
							+ toastDeleteMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}
}
