package companyname.Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class MyCart extends AbstractComponents {

	WebDriver driver;

	public MyCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css =".totalRow button")
	WebElement addtoCart;

	By productsBy = By.cssSelector(".cartSection h3");

	public List<WebElement> getProducts() {
		waitForElementToAppear(productsBy);
		return cartItems;
	}

	public Boolean getProductByName(String productName) {
		
		Boolean cartAvail = cartItems.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return cartAvail;

	}
	public Payment checkOut() {
		addtoCart.click();
		Payment payPage = new Payment(driver);
		return payPage;
	}
}