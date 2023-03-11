package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutStepOnePage {
	
	@FindBy (xpath = "//input[@name='firstName']") private WebElement firstName;
	@FindBy (xpath = "//input[@name='lastName']") private WebElement lastName;
	@FindBy (xpath = "//input[@name='postalCode']") private WebElement pincode;
	@FindBy (xpath = "//button[@name='cancel']") private WebElement cancelButton;
	@FindBy (xpath = "//input[@name='continue']") private WebElement cotinueButton;
	
	
	public SwagLabCheckoutStepOnePage(WebDriver driver)
	{PageFactory.initElements(driver, this);}
	
	public String getFirstnamePlaceholderText() {
		String actualPlaceHolderText = firstName.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public String getLastnamePlaceholderText() {
		String actualPlaceHolderText = lastName.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public String getPincodePlaceholderText() {
		String actualPlaceHolderText = pincode.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	public void clickContinueButton() {
		cotinueButton.click();
	}
	

}
