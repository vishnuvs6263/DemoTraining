package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_ReviewQuestions extends BaseClass {
	
	public static WebDriverWait wait;
	@Test
	public void addReviewQuestions() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ReviewQuestionsSubModule()));
		objects.ReviewQuestionsSubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterQuestionName()));
		objects.EnterQuestionName().sendKeys(prop.getProperty("ReviewQuestion"));
		
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Question created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Question created successfully");
			System.out.println("Verify create review question executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		
		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
		
	}
}
