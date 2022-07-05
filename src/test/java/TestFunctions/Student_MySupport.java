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
import Pages.MySupportPage;
import Pages.StudentOnSupportPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;

public class Student_MySupport extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void StudentsOnSupport() throws Exception {

		MySupportPage objects = new MySupportPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.MySupportModule()));
		objects.MySupportModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getStaffName()));
		
		String Actual_StaffName = objects.getStaffName().getText();
		String Actual_SupportType = objects.getSupportType().getText();
		String Actual_Role = objects.getRole().getText();

		String Actual_PlannedHours = objects.getPlannedHours().getText();

		if (Actual_StaffName.contentEquals(prop.getProperty("Staff_Fullname"))) {
			Assert.assertEquals(Actual_StaffName, prop.getProperty("Staff_Fullname"));
			System.out.println(
					"Verify staff name on student my support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			
		}
		
		if (Actual_SupportType.contentEquals(prop.getProperty("SupportTypeName"))) {
			Assert.assertEquals(Actual_SupportType, prop.getProperty("SupportTypeName"));
			System.out.println(
					"Verify support type on student my support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			System.out.println(Actual_SupportType);
			
		}
		System.out.println(Actual_Role);
		if (Actual_Role.contentEquals(prop.getProperty("RoleName"))) {
			Assert.assertEquals(Actual_Role, prop.getProperty("RoleName"));
			System.out.println(
					"Verify role on student my support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
			
			
		}
		

		
		if (Actual_PlannedHours.contentEquals(prop.getProperty("Student_Plannedhours"))) {
			Assert.assertEquals(Actual_PlannedHours, prop.getProperty("Student_Plannedhours"));
			System.out.println(
					"Verify student support planned hours in student my support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}
		
		objects.StaffViewDetailsButton().click();
		String useremailActual = objects.UserEmail().getText();
		if (useremailActual.contentEquals(prop.getProperty("Staff_Email"))) {
			Assert.assertEquals(useremailActual, prop.getProperty("Staff_Email"));
			System.out.println(
					"Verify staff email in student my support page executed and passed successfully!!! ");

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}
		objects.StaffViewDetailsCloseButton().click();
		
		System.out.println("Students my support page verification of support details completed successfully");
		
	}


}
