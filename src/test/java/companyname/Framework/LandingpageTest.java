package companyname.Framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import companyname.Framework.pageobjects.LandingPage;
import companyname.Framework.pageobjects.MyCart;
import companyname.Framework.pageobjects.OrderHistoryPage;
import companyname.Framework.pageobjects.Payment;
import companyname.Framework.pageobjects.ProductCatelogue;
import companyname.Framework.pageobjects.confirmationPage;
import companyname.TestComponents.BaseTest;

public class LandingpageTest extends BaseTest{
	String productName = "ZARA COAT 3";
	String orderID;

	@Test(dataProvider = "getData", groups = "Sanity")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		
		ProductCatelogue pc = lp.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> product = pc.getProducts();
		MyCart mc= pc.addProductsToCart(input.get("productName"));
		List<WebElement> prodcts = mc.getProducts();
		Assert.assertTrue(mc.getProductByName(input.get("productName")));
		Payment payPage = mc.checkOut();
		confirmationPage cp= payPage.addPersonalShippingInfo(input.get("cvv"), input.get("Name"), input.get("coun"), input.get("Country"));
		cp.confoirmationMs();
		Assert.assertTrue(true);
		orderID = cp.getOrderID();
		orderID = orderID.trim().replace("|", "").trim();
	}
	
	@Test (dataProvider = "getData", dependsOnMethods = {"submitOrder"})
	public void verifyOrderHistory(HashMap<String, String> input) {
		ProductCatelogue pc = lp.loginApplication(input.get("email"), input.get("password"));
		OrderHistoryPage ohp = pc.openOrderHistory();
		Assert.assertTrue(ohp.verifyOrderHistory(orderID));;
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//companyname//TestData//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * return new Object[][] {{"agnusjosephh@gmail.com",
	 * "Rahulshettyacademy@123","ZARA COAT 3"}, {"agnusjosephh@gmail.com",
	 * "Rahulshettyacademy@123", "ADIDAS ORIGINAL"}};
	 */
		
	/*
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "agnusjosephh@gmail.com"); map.put("password", "Rahulshettyacademy@123");
	 * map.put("productName", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "agnusjosephh@gmail.com"); map1.put("password",
	 * "Rahulshettyacademy@123"); map1.put("productName", "ADIDAS ORIGINAL");
	 */
	
}
