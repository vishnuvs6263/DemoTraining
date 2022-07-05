package TestFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.Read_OTP;
import Pages.StaffPage;

public class Staff_CreateStaff extends BaseClass {
	public static Actions actions;
	public static WebDriverWait wait;
	public static Select select;

	@Test
	public void createStaffProfile() throws Exception {

		StaffPage objects = new StaffPage(driver);
		objects.HomeBtn().click();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.staffsModule()));
		objects.staffsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.addNewBtn()));
		objects.addNewBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.staff_firstname()));
		// Enter staff details
		objects.staff_firstname().sendKeys(prop.getProperty("Staff_Firstname"));
		objects.staff_lastname().sendKeys(prop.getProperty("Staff_Lastname"));
		objects.staff_RegisteredEmail().sendKeys(prop.getProperty("Staff_Email"));
		Thread.sleep(1000);
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);
		select  = new Select(objects.staff_SelectRole());
		select.selectByVisibleText(prop.getProperty("RoleName"));
		objects.staff_EnterRateField().sendKeys(prop.getProperty("Staff_Rate"));

		objects.SaveBtn().click();
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		Thread.sleep(3000);
				if (toastsuccessMessage.contentEquals("Staff profile created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Staff profile created successfully");
			System.out.println("Verify create staff profile executed and passed successfully!!!   "+toastsuccessMessage);
			wait.until(ExpectedConditions.elementToBeClickable(objects.AssignDocPageTitle()));
			String pageTitle = objects.AssignDocPageTitle().getText();
			if (pageTitle.contentEquals("Assign Document")) {
				Assert.assertEquals(pageTitle, "Assign Document");
				System.out.println("Assign document page loaded successfully successfully!!!");
				wait.until(ExpectedConditions.elementToBeClickable(objects.selectBundleDropdown()));
				select  = new Select(objects.selectBundleDropdown());
				select.selectByVisibleText(prop.getProperty("BundleName"));
				wait.until(ExpectedConditions.elementToBeClickable(objects.Document()));
				Thread.sleep(1000);
				actions.moveToElement(objects.SaveBtn());
				actions.perform();
				Thread.sleep(1000);
				objects.SaveBtn().click();
				String toastsuccessMessageAssigndoc = objects.toastMsg().getText();
				objects.toastCloseBtn().click();
				if (toastsuccessMessageAssigndoc.contentEquals("Document assigned successfully")) {
					Assert.assertEquals(toastsuccessMessageAssigndoc, "Document assigned successfully");
					System.out.println("Verify create staff profile executed and passed successfully!!!   "+toastsuccessMessage);		
				
			}else {
				Assert.fail();
				System.out.println("Verification failed");
			}
				}
			else {
				Assert.fail();
				System.out.println("Verification failed");
			}
			
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		

	}

}

