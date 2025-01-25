package companyname.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int retryCount = 0;
	int maxRetryCount = 2; // Number of retries
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;// Retry the test
		}
		return false;// Don't retry
	}

}
