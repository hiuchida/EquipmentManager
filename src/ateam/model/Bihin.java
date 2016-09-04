package ateam.model;

import java.sql.Date;

public class Bihin {
	// 備品ID varchar(20) NotNull
	private String bihinID = "";
	// 備品名 varchar(50) NotNull
	private String bihinName = "";
	// 備品（フリガナ） varchar(100) NotNull
	private String bihinKana = "";
	// ステータス int NotNull
	private int status = Bihin.AVAILABLE;
	// 貸出ユーザID varchar(20)
	private String userID;
	// 返却予定日 date
	private Date returnDay;

	// ステータス定数
	public static final int AVAILABLE = 1;
	public static final int USED = 2;
	public static final int RETURNED = 3;
	public static final int PENDING = 4;
	public static final int OTHER = 0;

	public String getBihinID() {
		return bihinID;
	}

	public void setBihinID(String bihinID) {
		if (bihinID == null) {
			return;
		}
		if (bihinID.length() > 20) {
			bihinID = bihinID.substring(0, 20);
		}
		this.bihinID = bihinID;
	}

	public String getBihinName() {
		return bihinName;
	}

	public void setBihinName(String bihinName) {
		if (bihinName == null) {
			return;
		}
		if (bihinName.length() > 50) {
			bihinName = bihinName.substring(0, 50);
		}
		this.bihinName = bihinName;
	}

	public String getBihinKana() {
		return bihinKana;
	}

	public void setBihinKana(String bihinKana) {
		if (bihinKana == null) {
			return;
		}
		if (bihinKana.length() > 100) {
			bihinKana = bihinKana.substring(0, 100);
		}
		this.bihinKana = bihinKana;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status < Bihin.AVAILABLE || Bihin.PENDING < status) {
			return;
		}
		this.status = status;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		if (userID != null && userID.length() > 20) {
			userID = userID.substring(0, 20);
		}
		this.userID = userID;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}
}
