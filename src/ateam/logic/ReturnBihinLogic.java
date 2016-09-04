package ateam.logic;

import ateam.dao.BihinDAO;
import ateam.model.Bihin;
import ateam.util.LogUtil;

public class ReturnBihinLogic {
	synchronized public static boolean returnBihin(String userID, String bihinID) {
		if (userID == null || userID.isEmpty() || bihinID == null || bihinID.isEmpty()) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		Bihin bihin = dao.getBihin(bihinID);
		if (bihin != null && bihin.getStatus() == Bihin.USED && userID.equals(bihin.getUserID())) {
			dao.update(userID, bihinID);
			LogUtil.createLogDate(userID, bihinID);
			return true;
		}
		return false;
	}
}
