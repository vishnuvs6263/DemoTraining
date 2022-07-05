package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBeneficiary {
	WebDriver driver;

	public AddBeneficiary(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	@FindBy(xpath = "(//h2[text()='Transfers'])[2]")
	WebElement Transfers;

	public WebElement Transfers() {
		return Transfers;

	}
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ZMW'])[3]/following::div[6]")
	WebElement AddBeneficiaryTransfers;

	public WebElement AddBeneficiaryTransfers() {
		return AddBeneficiaryTransfers;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/h2")
	WebElement internalBeneficiary;

	public WebElement internalBeneficiary() {
		return internalBeneficiary;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/input")
	WebElement NickNameinternalBeneficiary;

	public WebElement NickNameinternalBeneficiary() {
		return NickNameinternalBeneficiary;

	} 
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/input")
	WebElement AccountNointernalBeneficiary;

	public WebElement AccountNointernalBeneficiary() {
		return AccountNointernalBeneficiary;

	}
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[2]/div[1]/div/input")
	WebElement ConfirmAcNointernalBeneficiary;

	public WebElement ConfirmAcNointernalBeneficiary() {
		return ConfirmAcNointernalBeneficiary;

	} 
	@FindBy(xpath = "//*[@id=\"Layout\"]/div/div/div/div[2]/div[2]/div[2]/div/div/form/div[2]/div[2]/div/input")
	WebElement TransfersLimitInternalBeneficiary;

	public WebElement TransfersLimitInternalBeneficiary() {
		return TransfersLimitInternalBeneficiary;

	} 
	@FindBy(xpath = "//p[@class='my-auto mx-auto']")
	WebElement SubmitInternalBeneficiary;

	public WebElement SubmitInternalBeneficiary() {
		return SubmitInternalBeneficiary;

	}
	@FindBy(xpath = "//p[@class='my-auto mx-auto']")
	WebElement ConfirmSubmit;

	public WebElement ConfirmSubmit() {
		return ConfirmSubmit;
    }
	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
	WebElement OTP1;

	public WebElement OTP1() {
		return OTP1;
    }
	
	@FindBy(xpath = "//input[@aria-label='Digit 2']")
	WebElement OTP2;

	public WebElement OTP2() {
		return OTP2;
    }
	
	@FindBy(xpath = "//input[@aria-label='Digit 4']")
	WebElement OTP4;

	public WebElement OTP4() {
		return OTP4;
    }
	
	@FindBy(xpath = "//input[@aria-label='Digit 3']")
	WebElement OTP3;

	public WebElement OTP3() {
		return OTP3;
    }
	@FindBy(xpath = "//p[@class='my-auto mx-auto']")
	WebElement OTPSubmit;

	public WebElement OTPSubmit() {
		return OTPSubmit;
    }
 }