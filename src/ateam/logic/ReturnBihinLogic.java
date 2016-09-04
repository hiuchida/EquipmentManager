package ateam.logic;

import ateam.dao.BihinDAO;
import ateam.model.Bihin;
import ateam.util.LogUtil;

public class ReturnBihinLogic {
	synchronized public static boolean returnBihin(String bihinID, String userID) {
		if (bihinID == null || bihinID.isEmpty() || userID == null || userID.isEmpty()) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		Bihin bihin = dao.getBihin(bihinID);
		if (bihin != null && bihin.getStatus() == Bihin.USED && userID.equals(bihin.getUserID())) {
			if (1 == dao.update(bihinID, userID)) {
				LogUtil.createLogDate(bihinID, userID);
				return true;
			}
		}
		return false;
	}
}
