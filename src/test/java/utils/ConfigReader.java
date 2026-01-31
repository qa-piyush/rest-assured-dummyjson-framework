package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static Properties loadConfig() {

		if (prop == null) {
			prop = new Properties();

			String env = System.getProperty("env", "qa");
			String fileName = "config/" + env + ".properties";

			try (InputStream input = ConfigReader.class
					.getClassLoader()
					.getResourceAsStream(fileName)) {

				prop.load(input);
			}
			catch (Exception e) {
				throw new RuntimeException("Unable to load file: " + fileName);
			}
		}
		return prop;
	}
}
