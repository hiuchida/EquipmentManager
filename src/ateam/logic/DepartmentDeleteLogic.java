package ateam.logic;

import ateam.dao.DepartmentDAO;

public class DepartmentDeleteLogic {
	public static boolean deleteDepartment(String deptID) {
		if (deptID == null || deptID.isEmpty()) {
			return false;
		}
		DepartmentDAO dao = DepartmentDAO.getInstance();
		if (1 == dao.delete(deptID)) {
			return true;
		}
		return false;
	}

}
