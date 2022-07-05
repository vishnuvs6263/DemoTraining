package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.DashboardPage;
import Pages.StudentPage;

public class Student_CreateEvent extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test
	//New features scripting- Student staff allocation - negative scenarios
	public void student_createevent() throws Exception {

		DashboardPage objects = new DashboardPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentDashboard_Calendar()));
		objects.StudentDashboard_Calendar().click();
		select = new Select(objects.selectSupportDrpDwn());
		select.selectByVisibleText(prop.getProperty("Staff_SupportDetails"));
		//String firstWordTextNew = StringHelper.getCurrentSystemDate().substring(0,
				//StringHelper.getCurrentSystemDate().lastIndexOf(" - "));
		//String getCurMonthString = firstWordTextNew.substring(firstWordTextNew.lastIndexOf(" ") + 1);
		//String CalMonthYear = objects.CalMonth().getText();
		//String CurrMonthActual = CalMonthYear.substring(0, CalMonthYear.lastIndexOf(" "));


			objects.CalendarFrwdBtn().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.CreateEventDate()));
			objects.CreateEventDate().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.CreateSessionWindowTitle()));
			String windowTitle = objects.CreateSessionWindowTitle().getText();
			if (windowTitle.contentEquals("Create Session")) {

				objects.EventTitle().sendKeys(prop.getProperty("EventTitle"));
				objects.EventEndDateField().click();
				Thread.sleep(2000);
				objects.EventEndTime().click();
				objects.EventLocation().sendKeys(prop.getProperty("EventLoctation"));
				objects.EventSubmit().click();
				String toastsuccessMessage = objects.toastMsg().getText();
				objects.toastCloseBtn().click();
				System.out.println(toastsuccessMessage);
				if (toastsuccessMessage.contentEquals("Session created successfully")) {
					Assert.assertEquals(toastsuccessMessage, "Session created successfully");
					System.out.println("Verify create event executed and passed successfully!!!   "+toastsuccessMessage);
				}
				
				
				else {
					System.out.println("Verification failed");
					Exception e = new Exception();
					e.printStackTrace();
					Assert.fail();
					
				}
				wait.until(ExpectedConditions.elementToBeClickable(objects.EventCard()));
				objects.EventCard().click();
				wait.until(ExpectedConditions.elementToBeClickable(objects.getStaffName()));
				String actualStaffName = objects.getStaffName().getText();
				String actualEventTitle = objects.getEventTitle().getText();
				String actualEventLocation = objects.getEventLocation().getText();
				String actualEventStartDate = objects.getEventStartDate().getText();
				String actualEventEndDate = objects.getEventEndDate().getText();
				String actualSupportType = objects.getSupportType().getText();
				String actualRole = objects.getRole().getText();

				if (actualStaffName.contentEquals(prop.getProperty("Staff_Fullname"))) {
					Assert.assertEquals(actualStaffName, prop.getProperty("Staff_Fullname"));
					System.out.println(
							"Verify staff name for created event executed and passed successfully!!!  Staff Name is :  "
									+ actualStaffName);
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
							"Verify role for created event executed and passed successfully!!!  Role Name is :  "
									+ actualRole);
				}

				else {
					Assert.fail();
					System.out.println("Verification failed");
				}
				
		objects.closeBtn().click();
		

			} else {
				Assert.fail();
				System.out.println("Verification failed");
			}



	}

}
