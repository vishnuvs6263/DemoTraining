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

public class Staff_CancelEvent extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test
	// Session booking staff availability - negative scenarios
	public void Staff_CancelEvent() throws Exception {

		DashboardPage objects = new DashboardPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StaffDashboard_Calendar()));
		objects.StaffDashboard_Calendar().click();

		objects.CalendarFrwdBtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.EventCard()));
		objects.EventCard().click();

		wait.until(ExpectedConditions.elementToBeClickable(objects.eventDeleteBtn()));
		objects.eventDeleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.eventDelete_ConfirmBtn()));
		objects.eventDelete_ConfirmBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastCloseBtn()));
		objects.toastCloseBtn().click();
		System.out.println("Session cancellation verified and executed successfully");

	}
}
