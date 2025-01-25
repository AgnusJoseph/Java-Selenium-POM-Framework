package companyname.Framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import companyname.Framework.pageobjects.ProductCatelogue;
import companyname.TestComponents.BaseTest;
import companyname.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest{ 	

	@Test(dataProvider = "getData", retryAnalyzer = Retry.class)
	public void passwordValidation(HashMap<String, String> input) {
		ProductCatelogue pc = lp.loginApplication(input.get("email"), input.get("password"));
		lp.getErrorMessage();
		Assert.assertEquals(lp.getErrorMessage(), "Incorrect email or password.");
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//companyname//TestData//PurchaseOrderErrorValidation.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
	}
}
