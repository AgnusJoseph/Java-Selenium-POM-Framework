package companyname.Framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import companyname.abstractComponents.AbstractComponents;

public class confirmationPage extends AbstractComponents{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css=".hero-primary")
	WebElement confirmation;
	
	@FindBy (css="label[class='ng-star-inserted']")
	WebElement orderID;
	
	
	public Boolean confoirmationMs() {
		waitForElementToAppearWebElement(confirmation);
		Boolean confMsg = confirmation.getText().equalsIgnoreCase("Thankyou for the order.");
		return confMsg;
	}
	
	public String getOrderID() {
		String orderIDCart = orderID.getText();
		return orderIDCart;
	}
	

}
