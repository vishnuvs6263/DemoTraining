package TestFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_FileBundle extends BaseClass {

	public static WebDriverWait wait;

	@Test
	public void addFileBundle() throws InterruptedException {

		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FileBundlingSubModule()));
		objects.FileBundlingSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterFileBundlingName()));
		objects.EnterFileBundlingName().sendKeys(prop.getProperty("BundleName"));
		objects.EnterFileBundlingDesc().sendKeys(prop.getProperty("BundleDesc"));
		
		Select select = new Select(objects.SelectBundleDocumentCategoryDropDown());
		select.selectByVisibleText(prop.getProperty("DocumentCategory"));
		objects.AddLineBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CheckBox_Assign()));
		objects.CheckBox_Assign().click();
		objects.CheckBox_TobeSignoff().click();
		Thread.sleep(3000);;
		objects.SaveBtn().click();
	
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Bundle created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Bundle created successfully");
			System.out.println(
					"Verify create bundle executed and passed successfully!!!   " + toastsuccessMessage);
		}


		else if (toastsuccessMessage.contentEquals("Bundle name already exists !")) {
			Assert.assertEquals(toastsuccessMessage, "Bundle name already exists !");

		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

	}
}
