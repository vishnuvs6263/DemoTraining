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

public class Staff_AcceptEvent extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void studentVerifyEventInCalendar() throws Exception {

		DashboardPage objects = new DashboardPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentDashboard_Calendar()));
		objects.StudentDashboard_Calendar().click();

		objects.CalendarFrwdBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.EventCard()));
		objects.EventCard().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getStaffName()));
		String actualStudentName = objects.getStaffName().getText();
		String actualEventTitle = objects.getEventTitle().getText();
		String actualEventLocation = objects.getEventLocation().getText();
		String actualEventStartDate = objects.getEventStartDate().getText();
		String actualEventEndDate = objects.getEventEndDate().getText();
		String actualSupportType = objects.getSupportType().getText();
		String actualRole = objects.getRole().getText();
		objects.getStaffName().click();

		if (actualStudentName.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(actualStudentName, prop.getProperty("Student_Fullname"));
			System.out.println(
					"Verify student name for created event executed and passed successfully!!!  Staff Name is :  "
							+ actualStudentName);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualEventTitle.contentEquals(prop.getProperty("EventTitle"))) {
			Assert.assertEquals(actualEventTitle, prop.getProperty("EventTitle"));
			System.out.println(
					"Verify staff name for created event executed and passed successfully!!!  Staff Name is :  "
							+ actualEventTitle);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualEventLocation.contentEquals(prop.getProperty("EventLoctation"))) {
			Assert.assertEquals(actualEventLocation, prop.getProperty("EventLoctation"));
			System.out.println(
					"Verify event location for created event executed and passed successfully!!!  Event location is :  "
							+ actualEventLocation);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualEventStartDate.contentEquals(prop.getProperty("EventStartDate"))) {
			Assert.assertEquals(actualEventStartDate, prop.getProperty("EventStartDate"));
			System.out.println(
					"Verify event end date and time for created event executed and passed successfully!!!  Event end date and time is :  "
							+ actualEventStartDate);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualEventEndDate.contentEquals(prop.getProperty("EventEndDate"))) {
			Assert.assertEquals(actualEventEndDate, prop.getProperty("EventEndDate"));
			System.out.println(
					"Verify event end date and time for created event executed and passed successfully!!!  Event end date and time is :  "
							+ actualEventEndDate);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualSupportType.contentEquals(prop.getProperty("SupportTypeName"))) {
			Assert.assertEquals(actualSupportType, prop.getProperty("SupportTypeName"));
			System.out.println(
					"Verify support type for created event executed and passed successfully!!!  Support Type is :  "
							+ actualSupportType);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		if (actualRole.contentEquals(prop.getProperty("RoleName"))) {
			Assert.assertEquals(actualRole, prop.getProperty("RoleName"));
			System.out.println(
					"Verify role for created event executed and passed successfully!!!  Role Name is :  " + actualRole);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		objects.closeBtn().click();

	}

	@Test(priority = 2)
	public void acceptEventJoblist() throws Exception {

		JoblistPage objects = new JoblistPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.JoblistModule()));
		objects.JoblistModule().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.acceptBtn()));
		objects.acceptBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		System.out.println(toastsuccessMessage);
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Session accepted successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Session accepted successfully");
			System.out.println(
					"Verify accept event as staff executed and passed successfully!!!   " + toastsuccessMessage);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		objects.HomeBtn().click();
	}

}
