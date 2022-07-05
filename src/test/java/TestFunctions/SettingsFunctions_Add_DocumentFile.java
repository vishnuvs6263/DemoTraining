package TestFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_DocumentFile extends BaseClass {

	public static WebDriverWait wait;

	@Test
	public void addDocumentCategory() throws InterruptedException, Exception {

		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DocumentFileSubModule()));
		objects.DocumentFileSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterDocumentFileNameField()));
		Select select = new Select(objects.SelectDocumentCategoryDropDown());
		select.selectByVisibleText(prop.getProperty("DocumentCategory"));
		objects.EnterDocumentFileNameField().sendKeys(prop.getProperty("DocumentFileName"));
		// String FilePath = System.getProperty("user.dir"+"\\src\\test\\resources");
		objects.BrowseFile().click();
		Thread.sleep(2000);
		objects.UploadFile().sendKeys(prop.getProperty("DocPath"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Document file added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Document file added successfully");
			System.out.println(
					"Verify create document file executed and passed successfully!!!   " + toastsuccessMessage);
		}

		else if (toastsuccessMessage.contentEquals("Category added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Category added successfully");
			System.out.println(
					"Verify create document category executed and passed successfully!!!   " + toastsuccessMessage);
		}

		else if (toastsuccessMessage.contentEquals("Category name already exists")) {
			Assert.assertEquals(toastsuccessMessage, "Category name already exists");

		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

	}
}
