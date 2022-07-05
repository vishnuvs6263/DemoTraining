package TestFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.Admin_TimesheetPage;
import Pages.DashboardPage;
import Pages.JoblistPage;
import Pages.ReportsPage;
import Pages.StudentOnSupportPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;

public class Admin_ReportsModule extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void verifyAdminReports_StaffListing() throws Exception {

		int claimedhrs = 3;
		int FBRate = 20;
		int missedHrs = 2;

		ReportsPage objects = new ReportsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.ReportsModule()));
		objects.ReportsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.StaffListingSubModule()));
		objects.StaffListingSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ClearBtn()));
		objects.ClearBtn().click();
		objects.FromDate().sendKeys("01-05-2021");;
		Thread.sleep(2000);

		objects.SearchBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewPersonalDetailsBtn()));
		objects.ViewPersonalDetailsBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));
		String username = objects.getStaffName().getText();

		if (username.contentEquals(prop.getProperty("Staff_Fullname"))) {
			Assert.assertEquals(username, prop.getProperty("Staff" + "_Fullname"));
			System.out.println(
					"Verify staff name on admin reports staff listing page executed and passed successfully!!! ");
		}

		wait.until(ExpectedConditions.elementToBeClickable(objects.closeBtn()));
		objects.closeBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewSupportActivitiesBtn()));
		objects.ViewSupportActivitiesBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.expandBtn()));
		objects.expandBtn().click();
		String DetailsPage_GetUserName = objects.getUserName().getText();
		String DetailsPage_GetFBRate = objects.getRate_FB().getText();
		String DetailsPage_GetSessionTitle = objects.getAttendedSessionTitle().getText();
		String DetailsPage_GetMissedSessionTitle = objects.getMissedSessionTitle().getText();
		String DetailsPage_GetSessionStatus = objects.getAttendedSessionStatus().getText();
		String DetailsPage_GetMissedSessionStatus = objects.getMissedSessionStatus().getText();

		if (DetailsPage_GetUserName.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(DetailsPage_GetUserName, prop.getProperty("Student_Fullname"));
			Assert.assertEquals(DetailsPage_GetFBRate, prop.getProperty("FBRate"));
			Assert.assertEquals(DetailsPage_GetSessionTitle, prop.getProperty("EventTitle"));
			Assert.assertEquals(DetailsPage_GetMissedSessionTitle, prop.getProperty("EventTitleMissed"));
			Assert.assertEquals(DetailsPage_GetSessionStatus, "Attended");
			Assert.assertEquals(DetailsPage_GetMissedSessionStatus, "Missed");
			System.out.println(
					"Verify event details on admin reports staff listing page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}
		
		objects.closeBtnSupport().click();

	}
	@Test(priority = 2)
	public void verifyAdminReports_StudentListing() throws Exception {



		ReportsPage objects = new ReportsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.ReportsModule()));
		objects.ReportsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentListingSubModule()));
		objects.StudentListingSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ClearBtn()));
		objects.ClearBtn().click();
		objects.FromDate().sendKeys("01-05-2021");;
		Thread.sleep(2000);

		objects.SearchBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewPersonalDetailsBtn()));
		objects.ViewPersonalDetailsBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getStudentName()));
		String username = objects.getStudentName().getText();

		if (username.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(username, prop.getProperty("Student" + "_Fullname"));
			System.out.println(
					"Verify staff name on admin reports staff listing page executed and passed successfully!!! ");
		}

		wait.until(ExpectedConditions.elementToBeClickable(objects.closeBtn()));
		objects.closeBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewSupportActivitiesBtn()));
		objects.ViewSupportActivitiesBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.expandBtn()));
		objects.expandBtn().click();
		String DetailsPage_GetUserName = objects.getUserName().getText();
		String DetailsPage_GetFBRate = objects.getRate_FB().getText();
		String DetailsPage_GetSessionTitle = objects.getAttendedSessionTitle().getText();
		String DetailsPage_GetMissedSessionTitle = objects.getMissedSessionTitle().getText();
		String DetailsPage_GetSessionStatus = objects.getAttendedSessionStatus().getText();
		String DetailsPage_GetMissedSessionStatus = objects.getMissedSessionStatus().getText();

		if (DetailsPage_GetUserName.contentEquals(prop.getProperty("Staff_Fullname"))) {
			Assert.assertEquals(DetailsPage_GetUserName, prop.getProperty("Staff_Fullname"));
			Assert.assertEquals(DetailsPage_GetFBRate, prop.getProperty("FBRate"));
			Assert.assertEquals(DetailsPage_GetSessionTitle, prop.getProperty("EventTitle"));
			Assert.assertEquals(DetailsPage_GetMissedSessionTitle, prop.getProperty("EventTitleMissed"));
			Assert.assertEquals(DetailsPage_GetSessionStatus, "Attended");
			Assert.assertEquals(DetailsPage_GetMissedSessionStatus, "Missed");
			System.out.println(
					"Verify event details on admin reports staff listing page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}
		
		objects.closeBtnSupport().click();

	}
	
}
