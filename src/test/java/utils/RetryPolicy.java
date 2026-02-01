package utils;

public class RetryPolicy {

	private RetryPolicy() {
	}

	public static boolean isRetryEnabled() {
		return Boolean.parseBoolean(ConfigManager.get("retry.enabled"));
	}

	public static int getMaxRetries() {
		return Integer.parseInt(ConfigManager.get("retry.count"));
	}
	
	public static int getRetryDelayMs() {
		return Integer.parseInt(ConfigManager.get("timeout.ms"));
	}
}
