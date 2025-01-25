package companyname.TestData;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

//The same code is available in the base class and this class in not used anywhere in the test/pages

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// reading the json to string
		String JsonContent = FileUtils.readFileToString(new File(
		System.getProperty("user.dir") + "src//test//java//companyname//TestData//PurchaseOrder.json"),StandardCharsets.UTF_8);
		// String to hashmap - Jackson Data binder
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}
}
