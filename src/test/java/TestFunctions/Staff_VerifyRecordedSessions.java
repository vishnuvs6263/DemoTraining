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
import Pages.Staff_RecordedSessionsPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;
import Pages.Student_RecordedSessionsPage;

public class Staff_VerifyRecordedSessions extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void staffVerify_RecordedSessions() throws Exception {

		Staff_RecordedSessionsPage objects = new Staff_RecordedSessionsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.RecordedSessionsModule()));
		objects.RecordedSessionsModule().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SearchBtn()));

		Select select = new Select(objects.SelectMonthDropDown());
		select.selectByVisibleText("May");
		objects.SearchBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));
		objects.collapseBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));

		//String ActualMOD = objects.getMOD().getText();
		String ActualUserName = objects.getUserName().getText();
		String ActualSessionStatus = objects.getAuthStatus().getText();
		String ActualSessionTitle = objects.getSessionTitle().getText();
		String ActualHoursWorked = objects.gethoursWorked().getAttribute("value");

		if (ActualUserName.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(ActualUserName, prop.getProperty("Student_Fullname"));
			System.out.println(
					"Verify student name in student recorded sessions module executed and passed successfully!!!   Actual staff name is "
							+ ActualUserName);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(ActualUserName);

		}
		
		if (ActualSessionStatus.contentEquals("Authorised")) {
			Assert.assertEquals(ActualSessionStatus, "Authorised");
			System.out.println(
					"Verify session status in student recorded sessions module executed and passed successfully!!!   Actual session status is "
							+ ActualSessionStatus);

		} else {
			Assert.fail();

		}
		
		if (ActualSessionTitle.contentEquals(prop.getProperty("EventTitle"))) {
			Assert.assertEquals(ActualSessionTitle, prop.getProperty("EventTitle"));
			System.out.println(
					"Verify session title in student recorded sessions module executed and passed successfully!!!   Actual session title is "
							+ ActualSessionTitle);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		

		

		if (ActualHoursWorked.contentEquals(prop.getProperty("ClaimWorkedTime"))) {
			Assert.assertEquals(ActualHoursWorked, prop.getProperty("ClaimWorkedTime"));
			System.out.println("Verify event hours worked executed and passed successfully!!!   Actual hours worked is "
					+ ActualHoursWorked);

		} else {
			System.out.println(ActualHoursWorked);
			Assert.fail();
			System.out.println("Verification failed");
			

		}




		System.out.println("Student recorded session module details verified succesfully");
	}

}
