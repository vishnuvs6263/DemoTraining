package TestFunctions;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.JiraPolicy;
import Common.StringHelper;
import Pages.AddBeneficiary;
import Pages.LoginPage;
import Pages.LoginPageObjects;

public class IB_AddBeneficiary extends BaseClass {

	public static WebDriverWait wait;

	@JiraPolicy(logTicketReady = true)
	@Test
	public void addBeneficiary() throws Exception {
		AddBeneficiary objects = new AddBeneficiary(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.Transfers()));
		objects.Transfers().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AddBeneficiaryTransfers()));
		objects.AddBeneficiaryTransfers().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.internalBeneficiary()));
		Random rnd = new Random();
		int n = 100000000 + rnd.nextInt(90000000);
		String accnumber = String.valueOf(n);

		objects.internalBeneficiary().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.NickNameinternalBeneficiary()));
		objects.NickNameinternalBeneficiary().sendKeys("");
		objects.AccountNointernalBeneficiary().sendKeys("0011031001087");
		objects.ConfirmAcNointernalBeneficiary().sendKeys("0011031001087");
		objects.TransfersLimitInternalBeneficiary().sendKeys("3");
		objects.SubmitInternalBeneficiary().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ConfirmSubmit()));
		objects.ConfirmSubmit().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.OTP1()));
		objects.OTP1().sendKeys("1");
		objects.OTP2().sendKeys("2");
		objects.OTP3().sendKeys("3");
		objects.OTP4().sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(objects.OTPSubmit()));
		objects.OTPSubmit().click();
		System.out.println("Beneficiary added successfully");
		Assert.assertEquals(accnumber, "54155");
		
	}

}
