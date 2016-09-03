package ateam.config;

public class DBConfig {
	private static DBConfig instance = new DBConfig();

	private DBConfig() {
	}

	public static DBConfig getInstance() {
		return instance;
	}

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/bihin";
	private String user = "root";
	private String password = "";

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
