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

public class Staff_ManageStaff_Availability_RepeatDaily extends BaseClass {
	public static Actions actions;
	public static WebDriverWait wait;
	public static Select select;

	@Test
	public void StaffAvailability_RepeatDaily() throws Exception {

		StaffPage objects = new StaffPage(driver);
		objects.HomeBtn().click();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.staffsModule()));
		objects.staffsModule().click();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_EditButton()));
		objects.Staff_EditButton().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.staff_firstname()));
		
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);
		int buttonSize = objects.Timing_DeleteButtonSize().size();
		if(buttonSize>0) {
		objects.Staff_avail_alldayAllTime().click();
		Thread.sleep(1000);
		objects.Staff_avail_alldayAllTime().click();
		}
			
		
		// Add staff availability
		objects.Add_availability_button().click();
		Thread.sleep(1000);
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_avail_saveBtn()));
		objects.Staff_Support_StartDate_Field().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Calendar_NextMonthBtn()));
		objects.Calendar_NextMonthBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_avail_startDate()));
		objects.Staff_avail_startDate().click();
		objects.Staff_Support_EndDate_Field().click();
		objects.Calendar_NextMonthBtn().click();
		objects.Calendar_NextMonthBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_avail_endDate()));
		objects.Staff_avail_endDate().click();
		Thread.sleep(1000);
		select  = new Select(objects.Staff_avail_repeatType());
		select.selectByVisibleText("Daily");
		
		objects.Staff_avail_saveBtn().click();
		actions.moveToElement(objects.UpdateBtn());
		actions.perform();
		Thread.sleep(1000);
		objects.UpdateBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		Thread.sleep(3000);
				if (toastsuccessMessage.contentEquals("Staff profile updated successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Staff profile updated successfully");
			System.out.println("Verify create staff availability as daily executed and passed successfully!!!   "+toastsuccessMessage);
				}else
				{
					Assert.fail();
					System.out.println("Verification Failed");
				}

	}

}

