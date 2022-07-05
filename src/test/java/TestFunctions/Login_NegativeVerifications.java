package TestFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.LoginPage;

public class Login_NegativeVerifications extends BaseClass {

	public static WebDriverWait wait;

	@Test
	public void verifyNegativeLogin() throws Exception {

		LoginPage objects = new LoginPage(driver);
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectUserTypeAdmin()));

		objects.LoginBtn().click();
		// to verify whether email field is mandatory
		wait.until(ExpectedConditions.elementToBeClickable(objects.EmailReqText()));
		String EmailReqText = objects.EmailReqText().getText();
		if (EmailReqText.contentEquals(prop.getProperty("EmailReqText"))) {
			Assert.assertEquals(EmailReqText, prop.getProperty("EmailReqText"));
			System.out.println(
					"Verify email field mandatory property executed and passed successfully!!!  " + EmailReqText);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		// to verify whether password field is mandatory
		objects.EmailField().sendKeys(prop.getProperty("AdminEmail"));
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.PasswordReqText()));
		String PasswordReqText = objects.PasswordReqText().getText();
		if (PasswordReqText.contentEquals(prop.getProperty("PasswordReqText"))) {
			Assert.assertEquals(PasswordReqText, prop.getProperty("PasswordReqText"));
			System.out.println(
					"Verify password field mandatory property executed and passed successfully!!!  " + PasswordReqText);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		driver.navigate().refresh();

		// verify invalid emailid for login
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectUserTypeAdmin()));
		objects.EmailField().sendKeys(prop.getProperty("InvalidEmailFormat"));
		objects.PasswordField().sendKeys(prop.getProperty("AdminPassword"));
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ToastMessage()));
		String toastmessageemail = objects.ToastMessage().getText();
		if (toastmessageemail.contentEquals(prop.getProperty("InvalidEmailToast"))) {
			Assert.assertEquals(toastmessageemail, prop.getProperty("InvalidEmailToast"));
			System.out.println("Verify login using invalid email id executed and passed successfully!!!   "
					+ "Email id entered for login is incorrect");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
		}
		driver.navigate().refresh();
		// verify incorrect password for login
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectUserTypeAdmin()));
		objects.EmailField().sendKeys(prop.getProperty("AdminEmail"));
		objects.PasswordField().sendKeys(prop.getProperty("InvalidPassword"));
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ToastMessage()));
		String toastmessagepassword = objects.ToastMessage().getText();
		if (toastmessagepassword.contentEquals(prop.getProperty("InvalidPasswordToast"))) {
			Assert.assertEquals(toastmessagepassword, prop.getProperty("InvalidPasswordToast"));
			System.out.println("Verify login using invalid password executed and passed successfully!!!   "
					+ "Password entered for login is incorrect");

		} else {
			Assert.fail();
			System.out.println("Verification failed");
		}

		driver.navigate().refresh();

	}

	

}
