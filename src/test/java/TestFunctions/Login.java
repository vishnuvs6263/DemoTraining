package TestFunctions;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.LoginPage;

public class Login extends BaseClass {

	public static WebDriverWait wait;

	
	@Test
	public void verifyLogin() {
		LoginPage objects = new LoginPage(driver);
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectUserTypeAdmin()));

		// Select the usertype for login
		objects.SelectUserTypeAdmin().click();
		objects.EmailField().sendKeys(prop.getProperty("AdminEmail"));
		objects.PasswordField().sendKeys(prop.getProperty("AdminPassword"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.LoginBtn()));
		objects.LoginBtn().click();
		// Verify the signed in user details
		wait.until(ExpectedConditions.elementToBeClickable(objects.ProfileModule()));
		objects.ProfileModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.UserEmail()));
		String UserEmail = objects.UserEmail().getText();
		if (UserEmail.contentEquals(prop.getProperty("AdminEmail"))) {
			Assert.assertEquals(UserEmail, prop.getProperty("AdminEmail"));
			System.out.println("Verify login using valid username and password executed and passed successfully!!!     "
					+ objects.UserName().getText() + " signed in successfully");
		}

		else {
			Assert.fail();
			System.out.println("Verification failed");
		}

	}

}
