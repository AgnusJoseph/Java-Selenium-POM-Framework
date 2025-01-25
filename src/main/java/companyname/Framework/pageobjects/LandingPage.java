package companyname.Framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Page Factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	@FindBy(css = "#toast-container")
	WebElement errorToast;
	
	 
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public ProductCatelogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCatelogue pc = new ProductCatelogue(driver);
		return pc;
	}
	public String getErrorMessage() {
		waitForElementToAppearWebElement(errorToast);
		return errorToast.getText();
	}
	public String getToast() {
		waitForElementToAppearWebElement(errorToast);
		return errorToast.getText();
	}
}
