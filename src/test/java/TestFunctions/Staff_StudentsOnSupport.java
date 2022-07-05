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
import Pages.StudentOnSupportPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;

public class Staff_StudentsOnSupport extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void StudentsOnSupport() throws Exception {

		StudentOnSupportPage objects = new StudentOnSupportPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentsOnSupportModule()));
		objects.StudentsOnSupportModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getStudentName()));
		
		String Actual_StudName = objects.getStudentName().getText();
		String Actual_SupportType = objects.getSupportType().getText();
		String Actual_Role = objects.getRole().getText();
		String Actual_Rate = objects.getRoleRate().getText();
		String Actual_Email = objects.getStudEmail().getText();
		String Actual_PlannedHours = objects.getPlannedHours().getText();

		if (Actual_StudName.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(Actual_StudName, prop.getProperty("Student_Fullname"));
			System.out.println(
					"Verify student name on student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			
		}
		
		if (Actual_SupportType.contentEquals(prop.getProperty("SupportTypeName"))) {
			Assert.assertEquals(Actual_SupportType, prop.getProperty("SupportTypeName"));
			System.out.println(
					"Verify support type on student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_SupportType);
			
		}
		
		if (Actual_Role.contentEquals(prop.getProperty("RoleName"))) {
			Assert.assertEquals(Actual_Role, prop.getProperty("RoleName"));
			System.out.println(
					"Verify role on student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_Role);
			
		}
		
		if (Actual_Rate.contentEquals("£"+prop.getProperty("Staff_Rate"))) {
			Assert.assertEquals(Actual_Rate, "£"+prop.getProperty("Staff_Rate"));
			System.out.println(
					"Verify support rate on student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_Rate);
			
		}
		
		if (Actual_Email.contentEquals(prop.getProperty("Student_Email"))) {
			Assert.assertEquals(Actual_Email, prop.getProperty("Student_Email"));
			System.out.println(
					"Verify student email in student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_Email);
		}
		System.out.println(Actual_PlannedHours);
		if (Actual_PlannedHours.contentEquals(prop.getProperty("Student_Plannedhours"))) {
			Assert.assertEquals(Actual_PlannedHours, prop.getProperty("Student_Plannedhours"));
			System.out.println(
					"Verify student support planned hors in student on support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_Email);
		}
		
	}


}
