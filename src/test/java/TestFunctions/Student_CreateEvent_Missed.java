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

public class Student_CreateEvent_Missed extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test

	public void student_createevent() throws Exception {

		DashboardPage objects = new DashboardPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentDashboard_Calendar()));
		objects.StudentDashboard_Calendar().click();
		select = new Select(objects.selectSupportDrpDwn());
		select.selectByVisibleText(prop.getProperty("Staff_SupportDetails"));
		


			objects.CalendarFrwdBtn().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.CreateEventDate()));
			objects.CreateEventDate().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.CreateSessionWindowTitle()));
			String windowTitle = objects.CreateSessionWindowTitle().getText();
			if (windowTitle.contentEquals("Create Session")) {

				objects.EventTitle().sendKeys(prop.getProperty("EventTitleMissed"));
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
				
	

			} else {
				Assert.fail();
				System.out.println("Verification failed");
			}



	}

}
