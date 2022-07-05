package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Manage_CourseOfStudy extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(priority =1)
	public void addCourseOfStudy() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CourseSubModule()));
		objects.CourseSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterCourseNameField()));
		objects.EnterCourseNameField().sendKeys(prop.getProperty("CourseName"));
		objects.EnterCourseDescField().sendKeys(prop.getProperty("CourseDesc"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Course added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Course added successfully");
			System.out.println("Verify create course of study executed and passed successfully!!!   "+toastsuccessMessage);
			
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		
		Thread.sleep(3000);
		objects.toastCloseBtn().click();
		objects.searchField().sendKeys(prop.getProperty("CourseName"));
		Thread.sleep(3000);
		String addedentry = objects.entrySearched().getText();
		if (addedentry.contentEquals(prop.getProperty("CourseName"))) {
			Assert.assertEquals(addedentry, prop.getProperty("CourseName"));
			System.out.println(
					"Verify course list executed & passed successfully!!!   New course of study added is "
							+ addedentry);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
	}
	@Test(priority =2, dependsOnMethods = { "addCourseOfStudy" }, alwaysRun = true)
	public void updateStatus() throws Exception {
		
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CourseSubModule()));
		objects.CourseSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("CourseName"));
		String statusText = objects.statusBtn().getText();
		Thread.sleep(2000);
		objects.statusBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Status updated successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Status updated successfully");
			System.out.println("Verify update status executed and passed successfully!!!   "+toastsuccessMessage);
			
			String statusUpdatedText = objects.statusBtn().getText();
			if (statusUpdatedText.contentEquals("Disable")) {
				Assert.assertEquals(statusUpdatedText, "Disable");
				System.out.println(
						"Verify update status functionality executed & passed successfully!!!   Updated status is "
								+ statusUpdatedText);

			} else {
				Assert.fail();
				System.out.println("Test failure observed");
			}
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		
		
	}
	@Test(priority =3, dependsOnMethods = { "addCourseOfStudy" }, alwaysRun = true)
	public void editCourse() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CourseSubModule()));
		objects.CourseSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.searchField()));
		objects.searchField().sendKeys(prop.getProperty("CourseName"));
		Thread.sleep(2000);
		objects.editBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterCourseNameField()));
		objects.EnterCourseNameField().clear();
		objects.EnterCourseNameField().sendKeys(prop.getProperty("CourseNameEdited"));
		objects.EnterCourseDescField().clear();
		objects.EnterCourseDescField().sendKeys(prop.getProperty("CourseDescEdited"));
		//update
		objects.SaveBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		String editedCourseName = objects.entrySearched().getText();
		String editedCourseDesc = objects.entrydescSearched().getText();
		
		if (toastMessage.contentEquals("Course updated successfully")) {
			Assert.assertEquals(toastMessage, "Course updated successfully");
			System.out.println(
					"Verify update course details  executed & passed successfully!!!  "
							+ toastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		
		if (editedCourseName.contentEquals(prop.getProperty("CourseNameEdited"))) {
			Assert.assertEquals(editedCourseName, prop.getProperty("CourseNameEdited"));
			System.out.println(
					"Verify edit course name  executed & passed successfully!!!   Updated course of study name is "
							+ editedCourseName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
		if (editedCourseDesc.contentEquals(prop.getProperty("CourseDescEdited"))) {
			Assert.assertEquals(editedCourseDesc, prop.getProperty("CourseDescEdited"));
			System.out.println(
					"Verify edit course description  executed & passed successfully!!!   Updated course of study description is "
							+ editedCourseDesc);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		
	}
	@Test(priority =4, dependsOnMethods = { "editCourse" }, alwaysRun = true)
	public void deleteCourse() throws Exception {
		SettingsPage objects = new SettingsPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CourseSubModule()));
		objects.CourseSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.searchField().sendKeys(prop.getProperty("CourseNameEdited"));
		Thread.sleep(2000);
		objects.deleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cnfrmYesBtn()));
		objects.cnfrmYesBtn().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastDeleteMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		System.out.println(toastDeleteMessage);
		if (toastDeleteMessage.contentEquals("Course deleted successfully.")) {
			Assert.assertEquals(toastDeleteMessage, "Course deleted successfully.");
			System.out.println(
					"Verify delete course details  executed & passed successfully!!!  "
							+ toastDeleteMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}
}
