package ateam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ateam.model.User;

public class UserDAO {
	private static UserDAO instance = new UserDAO();
	private static UserBeansMapping mapping = new UserBeansMapping();

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		return instance;
	}

	public User getUser(String userID) {
		String sql = "SELECT * FROM UserKanri WHERE userID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(userID);
		try {
			return DBManager.getObject(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public List<User> getUserList() {
		String sql = "SELECT * FROM UserKanri ORDER BY userID ASC";
		List<Object> params = new ArrayList<Object>();
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public int insert(User user) {
		String sql = "INSERT UserKanri(userID, password, userName, userKana, deptID, authority) VALUES(?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUserID());
		params.add(user.getPassword());
		params.add(user.getUserName());
		params.add(user.getUserKana());
		params.add(user.getDeptID());
		params.add(user.getAuthority());
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public int delete(String userID) {
		String sql = "DELETE FROM UserKanri WHERE userID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(userID);
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
