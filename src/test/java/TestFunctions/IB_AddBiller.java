package TestFunctions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.JiraPolicy;
import Common.StringHelper;
import Pages.AddBeneficiary;
import Pages.AddBillerPage;
import Pages.LoginPage;
import Pages.LoginPageObjects;

public class IB_AddBiller extends BaseClass {

	public static WebDriverWait wait;

	@JiraPolicy(logTicketReady = true)
	@Test
	public void addBiller() throws Exception {
		AddBillerPage objects = new AddBillerPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.PaymentsModule()));
		objects.PaymentsModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddBillerBtn()));
		objects.AddBillerBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SubmitBtn()));
		Select select = new Select(objects.SelectMerchantDropDown());
		select.selectByValue("MLife");
		Random rnd = new Random();
		int n = 1000000000 + rnd.nextInt(900000000);
		String accnumber = String.valueOf(n);
		objects.AccountNumberField().sendKeys(accnumber);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mmss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String BillerName = "Test Demo Biller";
		objects.ShortNameField().sendKeys(BillerName);
		objects.SubmitBtn().click();
		String SuccessMSg = objects.VerifySuccessMsg().getText();
		if (SuccessMSg.contains("Biller Beneficiary Added Successfully")) {
			Assert.assertTrue(true);
			System.out.println("Verify user add biller executed and passed successfully");

		} else {
			Assert.fail();
			System.out.println("Test case verification failed");

		}
		wait.until(ExpectedConditions.elementToBeClickable(objects.DoneBtn()));
		objects.DoneBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DeleteBtn()));
		objects.DeleteBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CnfrmBtn()));
		objects.CnfrmBtn().click();
	}

}
