package ateam.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ateam.model.Bihin;

public class BihinDAO {
	private static BihinDAO instance = new BihinDAO();
	private static BihinBeansMapping mapping = new BihinBeansMapping();

	private BihinDAO() {
	}

	public static BihinDAO getInstance() {
		return instance;
	}

	// 一行の情報を取得
	public Bihin getBihin(String bihinID) {
		String sql = "SELECT * FROM BihinKanri WHERE bihinID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(bihinID);
		try {
			return DBManager.getObject(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// 全件操作
	public List<Bihin> getBihinList() {
		String sql = "SELECT * FROM BihinKanri ORDER BY bihinID ASC";
		List<Object> params = new ArrayList<Object>();
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// 自身の借りているものを表示
	public List<Bihin> getBihinList(String userID) {
		String sql = "SELECT * FROM BihinKanri WHERE userID = ? ORDER BY bihinID ASC";
		List<Object> params = new ArrayList<Object>();
		params.add(userID);
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// サーチ（ステータスのみ）
	public List<Bihin> searchBihin(int status) {
		String sql = "SELECT * FROM BihinKanri WHERE status = ? ORDER BY bihinID ASC";
		List<Object> params = new ArrayList<Object>();
		params.add(status);
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// サーチ(全件表示)
	public List<Bihin> searchBihin(String bihinKana, String bihinName) {
		String sql = "SELECT * FROM BihinKanri WHERE bihinKana LIKE ? OR bihinName LIKE ? ORDER BY bihinID ASC";
		List<Object> params = new ArrayList<Object>();
		params.add("%" + bihinKana + "%");
		params.add("%" + bihinName + "%");
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// サーチ（ステータス＋名前)
	public List<Bihin> searchBihin(String bihinKana, String bihinName, int status) {
		String sql = "SELECT * FROM BihinKanri where status = ? and (bihinKana LIKE ? OR bihinName LIKE ?) ORDER BY bihinID ASC";
		List<Object> params = new ArrayList<Object>();
		params.add(status);
		params.add("%" + bihinKana + "%");
		params.add("%" + bihinName + "%");
		try {
			return DBManager.getList(sql, params, mapping);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// ステータス変更(返却)
	public int update(String bihinID, String userID) {
		String sql = "UPDATE BihinKanri SET status = ?, userID = NULL, returnDay = NULL WHERE userID = ? and bihinID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(Bihin.AVAILABLE);
		params.add(userID);
		params.add(bihinID);
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	// ステータス変更(貸出)
	public int update(String bihinID, String userID, Date returnDay) {
		String sql = "UPDATE BihinKanri SET status = ?, userID = ?, returnDay = ? WHERE bihinID = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(Bihin.USED);
		params.add(userID);
		params.add(returnDay);
		params.add(bihinID);
		try {
			return DBManager.doUpdate(sql, params);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
