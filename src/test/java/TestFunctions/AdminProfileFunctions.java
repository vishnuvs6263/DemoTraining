package TestFunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.AdminProfilePage;

public class AdminProfileFunctions extends BaseClass {

	public static WebDriverWait wait;
	public static Actions actions;

	@Test(priority = 1)
	public void verifyProfileDetails() {

		AdminProfilePage objects = new AdminProfilePage(driver);
		System.out.println();
		wait = new WebDriverWait(driver, 10);
		objects.HomeBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ProfileModule()));
		objects.ProfileModule().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FirstName()));
		// get all profile details
		String getFirstName = objects.FirstName().getText();
		
		String getLastName = objects.LastName().getText();
		String getDOB = objects.DOB().getText();
		String getOrganisation = objects.Organisation().getText();
		System.out.println(getOrganisation);
		System.out.println(prop.getProperty("Organisation"));
		String getMobile = objects.Mobile().getText();
		String getRegEmail = objects.SFEmail().getText();
		String getAddress = objects.Address().getText();
// Verify all the profile details
		if (getFirstName.contentEquals(prop.getProperty("FirstName"))) {
			Assert.assertEquals(getFirstName, prop.getProperty("FirstName"));
			System.out.println("Verify first name executed & passed successfully!!!   Firstname of signed in user is "
					+ getFirstName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		if (getLastName.contentEquals(prop.getProperty("LastName"))) {
			Assert.assertEquals(getLastName, prop.getProperty("LastName"));
			System.out.println("Verify last name executed & passed successfully!!!   Lastname of signed in user is "
					+ getLastName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		

		

		if (getMobile.contentEquals(prop.getProperty("Mobile"))) {
			Assert.assertEquals(getMobile, prop.getProperty("Mobile"));
			System.out.println(
					"Verify Mobile executed & passed successfully!!!   Mobile of signed in user is " + getMobile);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		if (getOrganisation.contentEquals(prop.getProperty("Organisation"))) {
			Assert.assertEquals(getOrganisation, prop.getProperty("Organisation"));
			System.out.println(
					"Verify Organisation executed & passed successfully!!!   Organisation of signed in user is " + getMobile);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		

		if (getAddress.contentEquals(prop.getProperty("Address"))) {
			Assert.assertEquals(getAddress, prop.getProperty("Address"));
			System.out.println(
					"Verify Address executed & passed successfully!!!   Address of signed in user is " + getAddress);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
	}

	@Test(priority = 2)
	public void editProfile() throws Exception {

		AdminProfilePage objects = new AdminProfilePage(driver);
		objects.EditBtn().click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(objects.FirstNameEdit()));
		objects.FirstNameEdit().clear();
		objects.FirstNameEdit().sendKeys(prop.getProperty("FirstNameEdited"));
		objects.LastNameEdit().clear();
		objects.LastNameEdit().sendKeys(prop.getProperty("LastNameEdited"));

		//actions = new Actions(driver);
		//actions.moveToElement(objects.AddressEdit());
		//actions.perform();
		
		objects.MobileEdit().clear();
		objects.MobileEdit().sendKeys(prop.getProperty("MobileEdited"));
		objects.AddressEdit().clear();
		objects.AddressEdit().sendKeys(prop.getProperty("AddressEdited"));

		// update
		objects.ProfileUpdateBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EditSuccessMessage()));
		String getToastMessage = objects.EditSuccessMessage().getText();
		if (getToastMessage.contentEquals("Admin profile updated successfully")) {
			Assert.assertEquals(getToastMessage, "Admin profile updated successfully");
			System.out.println("Verify admin profile edit executed & passed successfully!!!   " + getToastMessage);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}
		Thread.sleep(2000);
		// get all profile details
		String getEditedFirstName = objects.FirstName().getText();
		String getEditedLastName = objects.LastName().getText();
		String getEditedMobile = objects.Mobile().getText();
		String getEditedAddress = objects.Address().getText();
		// Verify all the profile details
		if (getEditedFirstName.contentEquals(prop.getProperty("FirstNameEdited"))) {
			Assert.assertEquals(getEditedFirstName, prop.getProperty("FirstNameEdited"));
			System.out.println(
					"Verify first name edit executed & passed successfully!!!   Firstname of signed in user is "
							+ getEditedFirstName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		if (getEditedLastName.contentEquals(prop.getProperty("LastNameEdited"))) {
			Assert.assertEquals(getEditedLastName, prop.getProperty("LastNameEdited"));
			System.out
					.println("Verify last name edit executed & passed successfully!!!   Lastname of signed in user is "
							+ getEditedLastName);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}



		if (getEditedMobile.contentEquals(prop.getProperty("MobileEdited"))) {
			Assert.assertEquals(getEditedMobile, prop.getProperty("MobileEdited"));
			System.out.println(
					"Verify Mobile edit executed & passed successfully!!!   Updated Mobile of signed in user is "
							+ getEditedMobile);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		if (getEditedAddress.contentEquals(prop.getProperty("AddressEdited"))) {
			Assert.assertEquals(getEditedAddress, prop.getProperty("AddressEdited"));
			System.out.println(
					"Verify Address edit executed & passed successfully!!!   Updated address of signed in user is "
							+ getEditedAddress);

		} else {
			Assert.fail();
			System.out.println("Test failure observed");
		}

		objects.EditBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.FirstNameEdit()));
		objects.FirstNameEdit().clear();
		objects.FirstNameEdit().sendKeys(prop.getProperty("FirstName"));
		objects.LastNameEdit().clear();
		objects.LastNameEdit().sendKeys(prop.getProperty("LastName"));
		objects.MobileEdit().clear();
		objects.MobileEdit().sendKeys(prop.getProperty("Mobile"));
		objects.AddressEdit().clear();
		objects.AddressEdit().sendKeys(prop.getProperty("Address"));

		// update
		objects.ProfileUpdateBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.toastCloseBtn()));
		objects.toastCloseBtn().click();
		Thread.sleep(1000);

	}

}
