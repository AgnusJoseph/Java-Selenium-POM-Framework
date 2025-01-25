package companyname.Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class OrderHistoryPage extends AbstractComponents{
	WebDriver driver;
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//th[@scope='row'])")
	List<WebElement> OrderIDPrproducts;
	
	public Boolean verifyOrderHistory(String OrderIDPrproduct) {
		//System.out.println(OrderIDPrproducts.get(0).getText());
		Boolean match = OrderIDPrproducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(OrderIDPrproduct));
		return match;
	}
	
}
