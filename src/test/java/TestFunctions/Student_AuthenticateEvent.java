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

public class Student_AuthenticateEvent extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void studentAuthenticateEvent() throws Exception {

		StudentTimesheetPage objects = new StudentTimesheetPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.TimesheetModule()));
		objects.TimesheetModule().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.authBtn()));
		objects.authBtn().click();
		
		String ActualMOD = objects.getMOD().getAttribute("value");
		String ActualBreak = objects.getbreakinMins().getAttribute("value");
		String ActualHoursWorked = objects.gethoursWorked().getAttribute("value");
		String ActualCurrentNotes = objects.getcurrNotes().getAttribute("value");
		String ActualNextNotes = objects.getnextSessionNotes().getAttribute("value");
		
		if (ActualMOD.contentEquals(prop.getProperty("ClaimMOD"))) {
			Assert.assertEquals(ActualMOD, prop.getProperty("ClaimMOD"));
			System.out.println(
					"Verify event mode of delivery executed and passed successfully!!!   Mode of delivery is " + ActualMOD);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualMOD);
			
		}
		
		if (ActualBreak.contentEquals(prop.getProperty("ClaimBreakTime"))) {
			Assert.assertEquals(ActualBreak, prop.getProperty("ClaimBreakTime"));
			System.out.println(
					"Verify event break time executed and passed successfully!!!   Actual break time is " + ActualBreak);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualBreak);
			
		}
		
		if (ActualHoursWorked.contentEquals(prop.getProperty("ClaimWorkedTime"))) {
			Assert.assertEquals(ActualHoursWorked, prop.getProperty("ClaimWorkedTime"));
			System.out.println(
					"Verify event hours worked executed and passed successfully!!!   Actual break time is " + ActualHoursWorked);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualHoursWorked);
			
		}
		
		if (ActualCurrentNotes.contentEquals(prop.getProperty("ClaimCurrentNotes"))) {
			Assert.assertEquals(ActualCurrentNotes, prop.getProperty("ClaimCurrentNotes"));
			System.out.println(
					"Verify notes for current session executed and passed successfully!!!   Actual break time is " + ActualCurrentNotes);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualCurrentNotes);
			
		}
		
		if (ActualNextNotes.contentEquals(prop.getProperty("ClaimNextNotes"))) {
			Assert.assertEquals(ActualNextNotes, prop.getProperty("ClaimNextNotes"));
			System.out.println(
					"Verify notes for the next session executed and passed successfully!!!   Actual break time is " + ActualNextNotes);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualNextNotes);
		}
		wait.until(ExpectedConditions.elementToBeClickable(objects.answerYesBtn()));
		objects.answerYesBtn().click();
		objects.studAuthBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		System.out.println(toastsuccessMessage);
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Session authenticated successfully!")) {
			Assert.assertEquals(toastsuccessMessage, "Session authenticated successfully!");
			System.out.println(
					"Verify authenticate event as student executed and passed successfully!!!   " + toastsuccessMessage);
			wait.until(ExpectedConditions.elementToBeClickable(objects.authBtn()));
			Thread.sleep(3000);
			String StudAuthBtnStatus = objects.authBtn().getText();
			System.out.println(StudAuthBtnStatus);
			if (StudAuthBtnStatus.contentEquals("Signed")) {
				Assert.assertEquals(StudAuthBtnStatus, "Signed");
				System.out.println(
						"Student authenticated the session successfully!!!   " + toastsuccessMessage);
			}
			else {
				Assert.fail();
				System.out.println("Verification failed");
				System.out.println(StudAuthBtnStatus);
				
			}
			

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(toastsuccessMessage);
			
		}
	}


}
