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

	public int insert(Department dept) {
		String sql = "INSERT DepartmentKanri(deptID, deptName, deptKana) VALUES(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(dept.getDeptID());
		params.add(dept.getDeptName());
		params.add(dept.getDeptKana());
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public int delete(String deptID) {
		String sql = "DELETE FROM DepartmentKanri WHERE deptID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(deptID);
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
