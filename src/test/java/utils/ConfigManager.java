package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static final Properties prop = new Properties();
	private static final String ENV;

	static {
		ENV = System.getProperty("env", "qa");

		String fileName = "config/" + ENV + ".properties";

		try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream(fileName)) {

			if (input == null) {
				throw new RuntimeException("Config file not found: " + fileName);
			}

			prop.load(input);

		} catch (Exception e) {
			throw new RuntimeException("Failed to load config for env: " + ENV, e);
		}
	}

	private ConfigManager() {
	}

	public static String get(String key) {
		String value = prop.getProperty(key);
		if(value == null) {
			throw new RuntimeException("Missing Conig key: " + key);
		}
		return value;
	}
}
