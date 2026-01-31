package base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utils.ConfigReader;

public class BaseTest {

	@BeforeClass
	public void setup() {
		String baseUrl = ConfigReader.loadConfig().getProperty("base.url");
		RestAssured.baseURI = baseUrl;
	}
}
