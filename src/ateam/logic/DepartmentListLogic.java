package ateam.logic;

import java.util.List;

import ateam.dao.DepartmentDAO;
import ateam.model.Department;

public class DepartmentListLogic {
	public static List<Department> getAllDepartmentList() {
		DepartmentDAO dao = DepartmentDAO.getInstance();
		List<Department> list = dao.getDepartmentList();
		return list;
	}

}
