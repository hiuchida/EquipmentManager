package ateam.model;

public class Department {
	// 部署ID varchar(20) NotNull
	private String deptID = "";
	// 部署名 varchar(50) NotNull
	private String deptName = "";
	// 部署名（フリガナ） varchar(100) NotNull
	private String deptKana = "";

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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		if (deptName == null) {
			return;
		}
		if (deptName.length() > 50) {
			deptName = deptName.substring(0, 50);
		}
		this.deptName = deptName;
	}

	public String getDeptKana() {
		return deptKana;
	}

	public void setDeptKana(String deptKana) {
		if (deptKana == null) {
			return;
		}
		if (deptKana.length() > 100) {
			deptKana = deptKana.substring(0, 100);
		}
		this.deptKana = deptKana;
	}

}
