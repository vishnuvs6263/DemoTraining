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

public class Staff_CreateEvent_Joblist extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void Staff_CreateEvent_Joblist() throws Exception {

		JoblistPage objects = new JoblistPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.JoblistModule()));
		objects.JoblistModule().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.Joblist_CreateSession()));
		objects.Joblist_CreateSession().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectStudentDropDown()));
		Select select = new Select(objects.SelectStudentDropDown());
		select.selectByVisibleText(prop.getProperty("Student_Fullname"));
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectSUpportCheckBox()));
		objects.SelectSUpportCheckBox().click();
		objects.SessionTitle().sendKeys("Session Created From Joblist");
		objects.SessionLocation().sendKeys("Location Joblist");
		objects.SaveBtn().click();
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		System.out.println(toastsuccessMessage);
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Session created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Session created successfully");
			System.out.println(
					"Verify create session from joblist executed and passed successfully!!!   " + toastsuccessMessage);

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			
		}
	}


}
