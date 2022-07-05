package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_DocumentCategory extends BaseClass {
	
	public static WebDriverWait wait;
	@Test
	public void addDocumentCategory() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DocumentCategorySubModule()));
		objects.DocumentCategorySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterDocumentCategoryNameField()));
		objects.EnterDocumentCategoryNameField().sendKeys(prop.getProperty("DocumentCategory"));
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		if (toastsuccessMessage.contentEquals("Category added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Category added successfully");
			System.out.println("Verify create document category executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		else if (toastsuccessMessage.contentEquals("Category added successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Category added successfully");
			System.out.println("Verify create document category executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		else if (toastsuccessMessage.contentEquals("Category name already exists")) {
			Assert.assertEquals(toastsuccessMessage, "Category name already exists");
			
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		
	}
}
