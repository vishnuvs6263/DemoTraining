package TestFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.StaffPage;

public class Staff_DeleteStaff extends BaseClass {
	public static Actions actions;
	public static WebDriverWait wait;

	@Test
	public void createStaffProfile() throws Exception {

		StaffPage objects = new StaffPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.staffsModule()));
		objects.staffsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.addNewBtn()));
		objects.searchField().sendKeys(prop.getProperty("Staff_Fullname"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Staff profile deleted successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Staff profile deleted successfully");
			System.out.println("Verify create staff profile executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

	}

}
