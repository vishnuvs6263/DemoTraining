package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.StudentPage;

public class Student_CreateStudent extends BaseClass  {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;
	@Test
	public void createStudentProfile() throws Exception {
		
		StudentPage objects = new StudentPage(driver);
		objects.HomeBtn().click();
		Thread.sleep(2000);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.StudentsModule()));
		objects.StudentsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.addNewBtn()));
		objects.addNewBtn().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.student_firstname()));
		//Enter student details
		objects.student_firstname().sendKeys(prop.getProperty("Student_Firstname"));
		objects.student_lastname().sendKeys(prop.getProperty("Student_Lastname"));
		//objects.student_mobile().sendKeys(prop.getProperty("Student_Mobile"));
		objects.student_RegisteredEmail().sendKeys(prop.getProperty("Student_Email"));

		actions.moveToElement(objects.Student_Course_Field());
		actions.perform();  
		objects.Student_Course_Field().click();
		Thread.sleep(2000);
		objects.Student_Course_DD_Option().click();
		Thread.sleep(2000);
		objects.Student_Institution_Field().click();
		Thread.sleep(2000);
		objects.Student_Institution_DD_Option().click();
		
		actions.moveToElement(objects.SaveBtn());
		actions.perform();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectSupportType()));
		select = new Select(objects.SelectSupportType()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("SupportTypeName"));
		select = new Select(objects.SelectSupportStaff()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("Staff_Fullname"));
		select = new Select(objects.Student_SelectRole_Rate()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("Staff_Role_Rate"));
		select = new Select(objects.Student_SelectFB()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("FBName"));
		objects.Student_RateFB().sendKeys(prop.getProperty("FBRate"));
		
		
		
		
		
		objects.Student_PlannedHoursField().sendKeys(prop.getProperty("Student_Plannedhours"));
		objects.Student_Support_StartDate().click();
		Thread.sleep(1000);
		objects.PrevButton().click();
		Thread.sleep(1000);
		objects.PrevButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Student_course_startDate()));
		objects.Student_course_startDate().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Student_Support_EndDate()));
		objects.Student_Support_EndDate().click();
		Thread.sleep(1000);
		objects.Calendar_NextMonthBtn().click();
		Thread.sleep(1000);
		objects.Calendar_NextMonthBtn().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Student_course_endDate()));
		objects.Student_course_endDate().click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(objects.SaveBtn()));
		objects.SaveBtn().click();
		
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Student profile created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Student profile created successfully");
			System.out.println("Verify create student profile manually executed and passed successfully!!!   "+toastsuccessMessage);
			wait.until(ExpectedConditions.elementToBeClickable(objects.AssignDocPageTitle()));
			String pageTitle = objects.AssignDocPageTitle().getText();
			if (pageTitle.contentEquals("Assign Document")) {
				Assert.assertEquals(pageTitle, "Assign Document");
				System.out.println("Assign document page loaded successfully successfully!!!");
				wait.until(ExpectedConditions.elementToBeClickable(objects.selectBundleDropdown()));
				select  = new Select(objects.selectBundleDropdown());
				select.selectByVisibleText(prop.getProperty("BundleName"));
				wait.until(ExpectedConditions.elementToBeClickable(objects.Document()));
				Thread.sleep(1000);
				actions.moveToElement(objects.SaveBtn());
				actions.perform();
				Thread.sleep(1000);
				objects.SaveBtn().click();
				String toastsuccessMessageAssigndoc = objects.toastMsg().getText();
				objects.toastCloseBtn().click();
				if (toastsuccessMessageAssigndoc.contentEquals("Document assigned successfully")) {
					Assert.assertEquals(toastsuccessMessageAssigndoc, "Document assigned successfully");
					System.out.println("Verify create staff profile executed and passed successfully!!!   "+toastsuccessMessageAssigndoc);		
				
			}else {
				Assert.fail();
				System.out.println("Verification failed");
			}
				}
			else {
				Assert.fail();
				System.out.println("Verification failed");
			}
			
		}
		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		}

		

	}


