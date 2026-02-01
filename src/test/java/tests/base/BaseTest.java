package tests.base;

import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;
import utils.ConfigManager;

public class BaseTest {

	@BeforeSuite(alwaysRun = true)
	public void setup() {
		
		RestAssured.baseURI = ConfigManager.get("base.url");
	}
}
