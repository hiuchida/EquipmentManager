package ateam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ateam.config.DBConfig;

public class DBManager {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String driver = DBConfig.getInstance().getDriver();
			Class.forName(driver).newInstance();
			// MySQLに接続
			String url = DBConfig.getInstance().getUrl();
			String user = DBConfig.getInstance().getUser();
			String password = DBConfig.getInstance().getPassword();
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// 更新SQLを発行
	public static int doUpdate(String sql, List<Object> params) throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DBManager.getConnection();
			stm = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				Object param = params.get(i);
				if (param instanceof String) {
					stm.setString(i + 1, (String) param);
				} else if (param instanceof Integer) {
					stm.setInt(i + 1, (Integer) param);
				} else if (param instanceof Date) {
					stm.setDate(i + 1, (Date) param);
				}
			}
			return stm.executeUpdate();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	public static <T> T getObject(String sql, List<Object> params, ResultSetBeanMapping<T> mapping) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stm = null;
		try {
			con = DBManager.getConnection();
			stm = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				Object param = params.get(i);
				if (param instanceof String) {
					stm.setString(i + 1, (String) param);
				} else if (param instanceof Integer) {
					stm.setInt(i + 1, (Integer) param);
				} else if (param instanceof Date) {
					stm.setDate(i + 1, (Date) param);
				}
			}
			rs = stm.executeQuery();
			if (rs.next()) {
				return (T) mapping.createFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

	public static <T> List<T> getList(String sql, List<Object> params, ResultSetBeanMapping<T> mapping) throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			stm = con.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				Object param = params.get(i);
				if (param instanceof String) {
					stm.setString(i + 1, (String) param);
				} else if (param instanceof Integer) {
					stm.setInt(i + 1, (Integer) param);
				} else if (param instanceof Date) {
					stm.setDate(i + 1, (Date) param);
				}
			}
			rs = stm.executeQuery();
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				T bean = mapping.createFromResultSet(rs);
				list.add(bean);
			}
			return list;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
