package companyname.Framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import companyname.Framework.pageobjects.ProductCatelogue;
import companyname.TestComponents.BaseTest;

public class viewAnItemTest extends BaseTest {
	
	@Test(dataProvider = "getData", groups = "Sanity")
	public void logoutTest(HashMap<String, String> input) throws InterruptedException {
		ProductCatelogue pc = lp.loginApplication(input.get("email"), input.get("password"));
		Thread.sleep(1000);
		pc.viewItem(input.get("productName"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//companyname//TestData//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
	}

}
