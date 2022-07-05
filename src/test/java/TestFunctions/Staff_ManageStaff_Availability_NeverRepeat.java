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

public class Staff_ManageStaff_Availability_NeverRepeat extends BaseClass {
	public static Actions actions;
	public static WebDriverWait wait;
	public static Select select;

	@Test
	public void StaffAvailability_NeverRepeat() throws Exception {

		StaffPage objects = new StaffPage(driver);
		objects.HomeBtn().click();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.staffsModule()));
		objects.staffsModule().click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_EditButton()));
		objects.Staff_EditButton().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.staff_firstname()));
		
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);
		

		int buttonSize = objects.Timing_DeleteButtonSize().size();
		System.out.println(buttonSize);
		if(buttonSize>0) {
			
		objects.Staff_avail_alldayAllTime().click();
		Thread.sleep(1000);
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);
		objects.UpdateBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_EditButton()));
		objects.Staff_EditButton().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.staff_firstname()));
		
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		Thread.sleep(1000);

		}else {
			objects.Add_availability_button().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_Support_StartDate_Field()));
		objects.Staff_Support_StartDate_Field().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_avail_startDate()));
		objects.Calendar_NextMonthBtn().click();
		objects.Staff_avail_startDate().click();
		objects.Staff_Support_EndDate_Field().click();
		objects.Calendar_NextMonthBtn().click();
		objects.Calendar_NextMonthBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Staff_avail_endDate()));
		objects.Staff_avail_endDate().click();
		Thread.sleep(1000);
		String setEndDate = objects.Staff_Support_EndDate_Field().getAttribute("value");
		System.out.println(setEndDate);
		select  = new Select(objects.Staff_avail_repeatType());
		select.selectByVisibleText("Never repeat");
		String getStartDate = objects.Staff_Support_StartDate_Field().getAttribute("value");
		String getEndDate = objects.Staff_Support_EndDate_Field().getAttribute("value");
		
		System.out.println(getStartDate);
		System.out.println(getEndDate);
		if (getStartDate.contentEquals(getEndDate)) {
			Assert.assertEquals(getStartDate, getEndDate);
			System.out.println("Verify start date and end date is same when Never repeat is chosen as the repeat type executed and passed successfully!!!");
		}else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		actions.moveToElement(objects.Staff_avail_saveBtn());
		actions.perform();
		Thread.sleep(1000);
		objects.Staff_avail_saveBtn().click();
		actions.moveToElement(objects.UpdateBtn());
		actions.perform();
		Thread.sleep(1000);
		objects.UpdateBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastCloseBtn()));
		objects.toastCloseBtn().click();
		}

	}

}

