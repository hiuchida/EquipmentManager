package ateam.logic;

import ateam.dao.DepartmentDAO;
import ateam.model.Department;

public class DepartmentAddLogic {
	public static boolean addDepartment(Department dept) {
		if (dept == null) {
			return false;
		}
		DepartmentDAO dao = DepartmentDAO.getInstance();
		try {
			if (1 == dao.insert(dept)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
