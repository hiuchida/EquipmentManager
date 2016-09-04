package ateam.logic;

import java.sql.Date;

import ateam.dao.BihinDAO;
import ateam.model.Bihin;
import ateam.util.LogUtil;

public class RequestLogic {
	synchronized public static boolean requestBihin(String bihinID, String userID, Date returnDay) {
		if (bihinID == null || bihinID.isEmpty() || userID == null || userID.isEmpty() || returnDay == null) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		Bihin bihin = dao.getBihin(bihinID);
		if (bihin != null && bihin.getStatus() == Bihin.AVAILABLE) {
			if (1 == dao.update(bihinID, userID, returnDay)) {
				LogUtil.createLogDate(bihinID, userID);
				// ステータスが貸出可の場合にのみtrueを返す
				return true;
			}
		}
		return false;
	}
}
