package companyname.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import companyname.Framework.pageobjects.LandingPage;
import companyname.Framework.pageobjects.OrderHistoryPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	@FindBy(css = "li:nth-child(5) button:nth-child(1)")
	WebElement logoutButton;
	
	public LandingPage logout() {
		logoutButton.click();
		LandingPage lanpge = new LandingPage(driver);
		return lanpge;	
	}
	
	public void openCart() {
		cart.click();
	}
	
	public OrderHistoryPage openOrderHistory() {
		orders.click();
		OrderHistoryPage ohp = new OrderHistoryPage(driver);
		return ohp;
	}
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToAppearWebElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
