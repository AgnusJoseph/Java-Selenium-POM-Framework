package companyname.Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import companyname.abstractComponents.AbstractComponents;

public class ProductCatelogue extends AbstractComponents{
	
	WebDriver driver;
	public ProductCatelogue(WebDriver driver) {
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".card-body")
	List<WebElement> proucts;
	
	
	
	By productsBy = By.cssSelector(".card-body");
	By addToCart = By.cssSelector(".btn.w-10.rounded");
	By  toastMsg = By.cssSelector("#toast-container"); 
	
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productsBy);
		return proucts;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}
	public MyCart addProductsToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		Thread.sleep(2000);
		openCart();
		MyCart mc = new MyCart(driver);
		return mc;
	}
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	
	

}
