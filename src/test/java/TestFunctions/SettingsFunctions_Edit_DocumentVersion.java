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
import Common.StringHelper;
import Pages.SettingsPage;

public class SettingsFunctions_Edit_DocumentVersion extends BaseClass {

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
		wait.until(ExpectedConditions.elementToBeClickable(objects.editVersionBtn()));
		objects.editVersionBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.submitBtn()));
		//objects.versionDescriptionField().sendKeys(prop.getProperty("DocDesc")+StringHelper.getCurrentSystemDate());
		objects.root().click();
		objects.chooseFile().sendKeys(prop.getProperty("NewDocPath"));
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		objects.submitBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		objects.toastCloseBtn().click();
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Document file added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Document file added successfully");
			System.out.println(
					"Verify edit document version executed and passed successfully!!!   " + toastsuccessMessage);
		}

		
		else {
			Assert.fail();
			System.out.println(toastsuccessMessage);

		}
		objects.windowCloseBtn().click();
		
		

	}
}
