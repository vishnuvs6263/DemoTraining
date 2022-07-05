package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.StudentPage;

public class Student_DeleteStudent extends BaseClass {
	public static Actions actions;
	public static WebDriverWait wait;

	@Test
	public void deleteStudentProfile() throws Exception {

		StudentPage objects = new StudentPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentsModule()));
		objects.StudentsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.addNewBtn()));
		objects.searchField().sendKeys(prop.getProperty("Student_Fullname"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Student profile deleted successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Student profile deleted successfully");
			System.out.println("Verify delete staff profile executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

	}

}
