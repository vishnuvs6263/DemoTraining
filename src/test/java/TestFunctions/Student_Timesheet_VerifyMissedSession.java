package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.DashboardPage;
import Pages.JoblistPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;

public class Student_Timesheet_VerifyMissedSession extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void student_Timesheet_VerifyMissedEvent() throws Exception {

		StudentTimesheetPage objects = new StudentTimesheetPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		Thread.sleep(1000);
		objects.TimesheetModule().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.MissedBtn()));
		objects.MissedBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.MissedDetails()));
		objects.MissedDetails().click();
		String MissedDetails = objects.MissedDetails().getText();
		objects.CloseBtn().click();
		if(MissedDetails.contentEquals("Missed Session Details")) {
			Assert.assertEquals(MissedDetails, "Missed Session Details");
			System.out.println(
					"Verify missed session in student timesheet page executed & passed successfully!!!   Mobile of signed in user is " + MissedDetails);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		
		}
		
		
	}


}
