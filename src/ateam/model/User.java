package ateam.model;

public class User {
	// ユーザID varchar(20) NotNull
	private String userID = "";
	// パスワード varchar(50) NotNull
	private String password = "";
	// 氏名 varchar(50) NotNull
	private String userName = "";
	// 氏名（フリガナ） varchar(100) NotNull
	private String userKana = "";
	// 部署ID varchar(20) NotNull
	private String deptID = "";
	// 権限 int NotNull
	private int authority = User.GENERAL;

	// 権限定数
	public static final int GENERAL = 1;
	public static final int ADMINISTRATOR = 2;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		if (userID == null) {
			return;
		}
		if (userID.length() > 20) {
			userID = userID.substring(0, 20);
		}
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) {
			return;
		}
		if (password.length() > 50) {
			password = password.substring(0, 50);
		}
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (userName == null) {
			return;
		}
		if (userName.length() > 50) {
			userName = userName.substring(0, 50);
		}
		this.userName = userName;
	}

	public String getUserKana() {
		return userKana;
	}

	public void setUserKana(String userKana) {
		if (userKana == null) {
			return;
		}
		if (userKana.length() > 100) {
			userKana = userKana.substring(0, 100);
		}
		this.userKana = userKana;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		if (deptID == null) {
			return;
		}
		if (deptID.length() > 20) {
			deptID = deptID.substring(0, 20);
		}
		this.deptID = deptID;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		if (authority < User.GENERAL || User.ADMINISTRATOR < authority) {
			return;
		}
		this.authority = authority;
	}
}
