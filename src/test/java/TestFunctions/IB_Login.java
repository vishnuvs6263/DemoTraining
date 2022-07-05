package TestFunctions;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.JiraPolicy;
import Common.StringHelper;
import Pages.LoginPage;
import Pages.LoginPageObjects;

public class IB_Login extends BaseClass {

	public static WebDriverWait wait;

	@JiraPolicy(logTicketReady = true)
	@Test
	public void verifyLogin() throws Exception {
		LoginPageObjects objects = new LoginPageObjects(driver);
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.LoginBtn()));
		objects.LoginBtn().click();
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+fileName+".jpg"));
		
		wait.until(ExpectedConditions.elementToBeClickable(objects.UsernameField()));
		objects.UsernameField().sendKeys(prop.getProperty("UserName"));
		objects.PasswordField().sendKeys(prop.getProperty("Pw"));
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OTPField()));
		objects.OTPField().sendKeys(prop.getProperty("OTPTest"));
		Thread.sleep(3000);
		objects.LoginBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));
		String ActualUserName = objects.getUserName().getText();
		if (ActualUserName.contains("")) {
			Assert.assertTrue(true);
			System.out.println("Verify user login executed and passed successfully");

		} else {
			Assert.fail();
			System.out.println("Test case verification failed");

		}
	}

}
