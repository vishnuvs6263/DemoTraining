package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.AdminProfilePage;
import Pages.AssignDocPage;

public class Admin_AssignDocuments extends BaseClass {

	public static WebDriverWait wait;
	public static Actions actions;

	@Test(priority = 1)
	public void verifyProfileDetails() {

		AssignDocPage objects = new AssignDocPage(driver);
		
	}

}
