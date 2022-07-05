package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.Admin_TimesheetPage;
import Pages.DashboardPage;
import Pages.JoblistPage;
import Pages.StudentOnSupportPage;
import Pages.StudentPage;
import Pages.StudentTimesheetPage;

public class Admin_TimesheetModule extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test(priority = 1)
	public void verifyAdminTimesheet_StudentDetails() throws Exception {

		int claimedhrs = 3;
		int FBRate = 20;
		int missedHrs = 2;

		Admin_TimesheetPage objects = new Admin_TimesheetPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Admin_TimesheetModule()));
		objects.Admin_TimesheetModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.selctDropDown()));
		select = new Select(objects.selctDropDown());
		select.selectByVisibleText("Student");
		Thread.sleep(2000);
		String Actual_StudentName = objects.GetUsersName().getText();
		if (Actual_StudentName.contentEquals(prop.getProperty("Student_Fullname"))) {
			Assert.assertEquals(Actual_StudentName, prop.getProperty("Student_Fullname"));
			System.out.println("Verify student name on admin timesheet page executed and passed successfully!!! ");

			String DetailsPage_GetStaffName = objects.getNameDetails().getText();
			String DetailsPage_GetSessionTitle = objects.getSessionNameDetails().getText();
			String DetailsPage_GetST = objects.getSupportTypeDetails().getText();
			String DetailsPage_GetRole = objects.getRoleDetails().getText();
			String DetailsPage_GetLocation = objects.getLocationDetails().getText();
			String DetailsPage_GetMOD = objects.getMODDetails().getText();
			String DetailsPage_GetFB = objects.getFBDetails().getText();
			String DetailsPage_GetAmount = objects.getAmountDetails().getText();
			String DetailsPage_GetBreak = objects.getBreakDetails().getText();
			String DetailsPage_GetTotalHours = objects.getTotalHoursDetails().getText();
			String DetailsPage_Missed_Title = objects.getMissedSessionTitleDetails().getText();
			String DetailsPage_Missed_Reason = objects.getMissedSessionReasonDetails().getText();
			String DetailsPage_Missed_Amount = objects.getMissedAmountDetails().getText();
			String DetailsPage_Missed_Duration = objects.getMissedHoursDetails().getText();


			if (DetailsPage_GetStaffName.contentEquals(prop.getProperty("Staff_Fullname"))) {
				Assert.assertEquals(DetailsPage_GetStaffName, prop.getProperty("Staff_Fullname"));
				System.out.println(
						"Verify student name on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetSessionTitle.contentEquals(prop.getProperty("EventTitle"))) {
				Assert.assertEquals(DetailsPage_GetSessionTitle, prop.getProperty("EventTitle"));
				System.out.println(
						"Verify event title on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetST.contentEquals(prop.getProperty("SupportTypeName"))) {
				Assert.assertEquals(DetailsPage_GetST, prop.getProperty("SupportTypeName"));
				System.out.println(
						"Verify support type on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetRole.contentEquals(prop.getProperty("RoleName"))) {
				Assert.assertEquals(DetailsPage_GetRole, prop.getProperty("RoleName"));
				System.out.println(
						"Verify role on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetLocation.contentEquals(prop.getProperty("EventLoctation"))) {
				Assert.assertEquals(DetailsPage_GetLocation, prop.getProperty("EventLoctation"));
				System.out.println(
						"Verify location on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetMOD.contentEquals(prop.getProperty("ClaimMOD"))) {
				Assert.assertEquals(DetailsPage_GetMOD, prop.getProperty("ClaimMOD"));
				System.out.println(
						"Verify mode of delivery on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetFB.contentEquals(prop.getProperty("FBName"))) {
				Assert.assertEquals(DetailsPage_GetFB, prop.getProperty("FBName"));
				System.out.println(
						"Verify funding board on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetAmount.contentEquals(prop.getProperty("CurrencySymbol") + (FBRate * claimedhrs))) {
				Assert.assertEquals(DetailsPage_GetAmount, prop.getProperty("CurrencySymbol") + (FBRate * claimedhrs));
				System.out.println(
						"Verify amount earned on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetBreak.contentEquals(prop.getProperty("ClaimBreakTime"))) {
				Assert.assertEquals(DetailsPage_GetBreak, prop.getProperty("ClaimBreakTime"));
				System.out.println(
						"Verify break time on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetTotalHours.contentEquals(prop.getProperty("ClaimWorkedTime"))) {
				Assert.assertEquals(DetailsPage_GetTotalHours, prop.getProperty("ClaimWorkedTime"));
				System.out.println(
						"Verify hours worked on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}
			if (DetailsPage_Missed_Title.contentEquals(prop.getProperty("EventTitleMissed"))) {
				Assert.assertEquals(DetailsPage_Missed_Title, prop.getProperty("EventTitleMissed"));
				System.out.println(
						"Verify missed event title on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(DetailsPage_Missed_Title);
				
			}
			
			if (DetailsPage_Missed_Reason.contentEquals(prop.getProperty("EventMissedReason"))) {
				Assert.assertEquals(DetailsPage_Missed_Reason, prop.getProperty("EventMissedReason"));
				System.out.println(
						"Verify missed event title on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");
				
			}
			
			if (DetailsPage_Missed_Amount.contentEquals(prop.getProperty("CurrencySymbol")+(missedHrs*FBRate))) {
				Assert.assertEquals(DetailsPage_Missed_Amount, prop.getProperty("CurrencySymbol")+(missedHrs*FBRate));
				System.out.println(
						"Verify actual amount on staff admin timesheet page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(prop.getProperty("CurrencySymbol")+(claimedhrs*FBRate));
				
			}
			if (DetailsPage_Missed_Duration.contentEquals(prop.getProperty("EventMissedDuration"))) {
				Assert.assertEquals(DetailsPage_Missed_Duration, prop.getProperty("EventMissedDuration"));
				System.out.println(
						"Verify missed event duration on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(DetailsPage_Missed_Duration);
				
			}

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}

	}
	
	
	@Test(priority = 2)
	public void verifyAdminTimesheet_StaffDetails() throws Exception {

		int claimedhrs = 3;
		int RoleRate = 10;
		int missedHrs = 2;

		Admin_TimesheetPage objects = new Admin_TimesheetPage(driver);
		Thread.sleep(2000);
		select = new Select(objects.selctDropDown());
		select.selectByVisibleText("Staff");
		Thread.sleep(2000);
		String Actual_StaffName = objects.GetUsersName().getText();
		if (Actual_StaffName.contentEquals(prop.getProperty("Staff_Fullname"))) {
			Assert.assertEquals(Actual_StaffName, prop.getProperty("Staff_Fullname"));
			System.out.println("Verify staff name on admin timesheet page executed and passed successfully!!! ");

			String DetailsPage_GetStudentName = objects.getNameDetails().getText();
			String DetailsPage_GetSessionTitle = objects.getSessionNameDetails().getText();
			String DetailsPage_GetST = objects.getSupportTypeDetails().getText();
			String DetailsPage_GetRole = objects.getRoleDetails().getText();
			String DetailsPage_GetLocation = objects.getLocationDetails().getText();
			String DetailsPage_GetMOD = objects.getMODDetails().getText();
			String DetailsPage_GetFB = objects.getFBDetails().getText();
			String DetailsPage_GetAmount = objects.getAmountDetails().getText();
			String DetailsPage_GetBreak = objects.getBreakDetails().getText();
			String DetailsPage_GetTotalHours = objects.getTotalHoursDetails().getText();
			String DetailsPage_Missed_Title = objects.getMissedSessionTitleDetails().getText();
			String DetailsPage_Missed_Reason = objects.getMissedSessionReasonDetails().getText();
			String DetailsPage_Missed_Amount = objects.getMissedAmountDetails().getText();
			String DetailsPage_Missed_Duration = objects.getMissedHoursDetails().getText();

			if (DetailsPage_GetStudentName.contentEquals(prop.getProperty("Student_Fullname"))) {
				Assert.assertEquals(DetailsPage_GetStudentName, prop.getProperty("Student_Fullname"));
				System.out.println(
						"Verify student name on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetSessionTitle.contentEquals(prop.getProperty("EventTitle"))) {
				Assert.assertEquals(DetailsPage_GetSessionTitle, prop.getProperty("EventTitle"));
				System.out.println(
						"Verify event title on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetST.contentEquals(prop.getProperty("SupportTypeName"))) {
				Assert.assertEquals(DetailsPage_GetST, prop.getProperty("SupportTypeName"));
				System.out.println(
						"Verify support type on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetRole.contentEquals(prop.getProperty("RoleName"))) {
				Assert.assertEquals(DetailsPage_GetRole, prop.getProperty("RoleName"));
				System.out.println(
						"Verify role on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetLocation.contentEquals(prop.getProperty("EventLoctation"))) {
				Assert.assertEquals(DetailsPage_GetLocation, prop.getProperty("EventLoctation"));
				System.out.println(
						"Verify location on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetMOD.contentEquals(prop.getProperty("ClaimMOD"))) {
				Assert.assertEquals(DetailsPage_GetMOD, prop.getProperty("ClaimMOD"));
				System.out.println(
						"Verify mode of delivery on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetFB.contentEquals(prop.getProperty("FBName"))) {
				Assert.assertEquals(DetailsPage_GetFB, prop.getProperty("FBName"));
				System.out.println(
						"Verify funding board on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetAmount.contentEquals(prop.getProperty("CurrencySymbol") + (RoleRate * claimedhrs))) {
				Assert.assertEquals(DetailsPage_GetAmount, prop.getProperty("CurrencySymbol") + (RoleRate * claimedhrs));
				System.out.println(
						"Verify amount earned on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetBreak.contentEquals(prop.getProperty("ClaimBreakTime"))) {
				Assert.assertEquals(DetailsPage_GetBreak, prop.getProperty("ClaimBreakTime"));
				System.out.println(
						"Verify break time on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}

			if (DetailsPage_GetTotalHours.contentEquals(prop.getProperty("ClaimWorkedTime"))) {
				Assert.assertEquals(DetailsPage_GetTotalHours, prop.getProperty("ClaimWorkedTime"));
				System.out.println(
						"Verify hours worked on admin timesheet view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");

			}
			
			if (DetailsPage_Missed_Title.contentEquals(prop.getProperty("EventTitleMissed"))) {
				Assert.assertEquals(DetailsPage_Missed_Title, prop.getProperty("EventTitleMissed"));
				System.out.println(
						"Verify missed event title on finance view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(DetailsPage_Missed_Title);
				
			}
			
			if (DetailsPage_Missed_Reason.contentEquals(prop.getProperty("EventMissedReason"))) {
				Assert.assertEquals(DetailsPage_Missed_Reason, prop.getProperty("EventMissedReason"));
				System.out.println(
						"Verify missed event title on finance view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println("Verification failed");
				
			}
			
			if (DetailsPage_Missed_Amount.contentEquals(prop.getProperty("CurrencySymbol")+(missedHrs*RoleRate))) {
				Assert.assertEquals(DetailsPage_Missed_Amount, prop.getProperty("CurrencySymbol")+(missedHrs*RoleRate));
				System.out.println(
						"Verify actual amount on staff finance page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(prop.getProperty("CurrencySymbol")+(claimedhrs*RoleRate));
				
			}
			if (DetailsPage_Missed_Duration.contentEquals(prop.getProperty("EventMissedDuration"))) {
				Assert.assertEquals(DetailsPage_Missed_Duration, prop.getProperty("EventMissedDuration"));
				System.out.println(
						"Verify missed event duration on finance view details page executed and passed successfully!!! ");

			} else {
				Assert.fail();
				System.out.println(DetailsPage_Missed_Duration);
				
			}

		} else {
			Assert.fail();
			System.out.println("Verification failed");

		}

	}


}
