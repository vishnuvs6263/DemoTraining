package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.SettingsPage;

public class SettingsFunctions_Add_FundingBody extends BaseClass {
	
	public static WebDriverWait wait;
	public static Select select;
	@Test(priority =1)
	public void addFundingBody() throws InterruptedException {
		
		SettingsPage objects = new SettingsPage(driver);
		objects.HomeBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SettingsModule()));
		objects.SettingsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FundingBodySubModule()));
		objects.FundingBodySubModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddNew()));
		objects.AddNew().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterFundingBodyName()));
		objects.EnterFundingBodyName().sendKeys(prop.getProperty("FBName"));
		objects.EnterFundingBodyDesc().sendKeys(prop.getProperty("FBDesc"));
		objects.EnterFundingBodyAddress().sendKeys(prop.getProperty("FBAdress"));
		
		select = new Select(objects.SelectFBCountry()); 
		Thread.sleep(1000);
		select.selectByVisibleText(prop.getProperty("FBCountry"));
		Thread.sleep(1000);
		
		objects.SelectFBCounty().click();
		Thread.sleep(2000);
		objects.SelectFBCountyOption().click();
		Thread.sleep(2000);
		objects.EnterFundingBodyCity().sendKeys(prop.getProperty("FBCity"));
		objects.EnterFundingBodyPin().sendKeys(prop.getProperty("FBPinCode"));
		
		objects.SaveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastMsg()));
		String toastsuccessMessage = objects.toastMsg().getText();
		objects.toastCloseBtn().click();
		if (toastsuccessMessage.contentEquals("Funding Body created successfully")) {
			Assert.assertEquals(toastsuccessMessage, "Funding Body created successfully");
			System.out.println("Verify create funding body executed and passed successfully!!!   "+toastsuccessMessage);
		}
		
		else if (toastsuccessMessage.contentEquals("Funding body name already exists!")) {
			Assert.assertEquals(toastsuccessMessage, "Funding body name already exists!");
			System.out.println("Verify create institution executed and passed successfully!!!   "+toastsuccessMessage);
		}

		else {
			System.out.println("Verification failed");
			Exception e = new Exception();
			e.printStackTrace();
			Assert.fail();
			
		}
				
	}
	
	
}
