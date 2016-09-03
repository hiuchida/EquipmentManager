package ateam.config;

public class AppConfig {
	private static AppConfig instance = new AppConfig();

	private AppConfig() {
	}

	public static AppConfig getInstance() {
		return instance;
	}

	private String basePath = "/home/hiuchida/git/EquipmentManager/WebContent";

	public String getBasePath() {
		return basePath;
	}
}
