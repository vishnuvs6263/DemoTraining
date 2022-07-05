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

public class Student_CreateEvent_VerifySessionBookingBasedOnStaffAvailability_RepeatAlternateMonths extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test
	//Session booking staff availability - negative scenarios
	public void student_createevent_RepeatAlternateMonths() throws Exception {

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
			wait.until(ExpectedConditions.elementToBeClickable(objects.CreateEventDate_NeverRepeat()));
			objects.CreateEventDate_NeverRepeat().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
			String toastsuccessMessageFailure = objects.toastMsg().getText();
			objects.toastCloseBtn().click();
			System.out.println(toastsuccessMessageFailure);
			if (toastsuccessMessageFailure.contains("Staff is not available on this day")) {
				Assert.assertEquals(toastsuccessMessageFailure, "Staff is not available on this day");
				System.out.println("Verify create event on day staff is not available executed and passed successfully!!!   "+toastsuccessMessageFailure);
			}
			
			
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
				wait.until(ExpectedConditions.elementToBeClickable(objects.eventDeleteBtn()));
				objects.eventDeleteBtn().click();
				wait.until(ExpectedConditions.elementToBeClickable(objects.eventDelete_ConfirmBtn()));
				objects.eventDelete_ConfirmBtn().click();
				wait.until(ExpectedConditions.elementToBeClickable(objects.toastCloseBtn()));
				objects.toastCloseBtn().click();




	}
	}

}
