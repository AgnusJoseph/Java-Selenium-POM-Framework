package companyname.Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class Payment extends AbstractComponents{

	WebDriver driver;
	
	public Payment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='payment__cc']//div[2]//input[1]")
	WebElement CVV;
	
	@FindBy (xpath = "//div[@class='payment__info']//div[3]//div[1]//input[1]")
	WebElement nameOnCard;
	
	@FindBy (css = "input[placeholder='Select Country")
	WebElement countryDropDown;
	
	@FindBy (css=".ta-item.list-group-item.ng-star-inserted")
	WebElement dropdownlist;
	
	@FindBy (css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrder;
	
	By dropDownValues = By.cssSelector(".ta-item.list-group-item.ng-star-inserted");
	
	public confirmationPage addPersonalShippingInfo(String cvv, String name, String country, String ExpectedCountry ) {
		
		CVV.sendKeys(cvv);
		nameOnCard.sendKeys(name);
		countryDropDown.sendKeys(country);
		
		List<WebElement> dropdownValue = driver.findElements(dropDownValues);
		waitForElementToAppear(dropDownValues);
		for (WebElement dropdown : dropdownValue) {
			
			if (dropdown.getText().equalsIgnoreCase(ExpectedCountry)) {
				dropdown.click();
				break;
			}
			
	}
		placeOrder.click();	
		confirmationPage cp = new confirmationPage(driver);
		return cp;
	
	}
}