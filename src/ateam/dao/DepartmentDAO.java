package ateam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ateam.model.Department;

public class DepartmentDAO {
	private static DepartmentDAO instance = new DepartmentDAO();
	private static DepartmentBeansMapping mapping = new DepartmentBeansMapping();

	private DepartmentDAO() {
	}

	public static DepartmentDAO getInstance() {
		return instance;
	}

	public Department getDepartment(String deptID) {
		String sql = "SELECT * FROM DepartmentKanri WHERE deptID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(deptID);
		try {
			return DBManager.getObject(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public List<Department> getDepartmentList() {
		String sql = "SELECT * FROM DepartmentKanri ORDER BY deptID ASC";
		List<Object> params = new ArrayList<Object>();
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
