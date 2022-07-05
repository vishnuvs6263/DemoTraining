package TestFunctions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.LogoutPage;

public class Logout extends BaseClass {
	
	public static WebDriverWait wait;
	@Test(alwaysRun = true)
	public void Logout() throws Exception {
		LogoutPage objects = new LogoutPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeBtn()));
		objects.HomeBtn().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewUserBtn()));
		objects.ViewUserBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.LogoutBtn()));
		objects.LogoutBtn().click();
		Thread.sleep(3000);
		if(objects.DSALogo().size()>0) {
			Assert.assertTrue(objects.DSALogo().size()>0);
			System.out.println("Verify logout executed and passed successfully");
		}else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		

		
	}


}
