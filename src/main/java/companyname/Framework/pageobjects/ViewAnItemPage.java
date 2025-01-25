package companyname.Framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class ViewAnItemPage extends AbstractComponents{
	
	WebDriver driver;
	public ViewAnItemPage(WebDriver driver) {
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".continue")
	WebElement continueShoppingButton;
	
	public ProductCatelogue getContinueShoppingButton() {
		continueShoppingButton.click();
		ProductCatelogue prodcat = new ProductCatelogue(driver);
		return prodcat;
	}
}
