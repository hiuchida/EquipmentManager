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

	synchronized public static boolean returnBihinByAdmin(String bihinID, String adminID) {
		if (bihinID == null || bihinID.isEmpty() || adminID == null || adminID.isEmpty()) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		Bihin bihin = dao.getBihin(bihinID);
		if (bihin != null && bihin.getStatus() == Bihin.USED && bihin.getUserID() != null) {
			if (1 == dao.update(bihinID, bihin.getUserID())) {
				LogUtil.createLogDate(bihinID, adminID);
				return true;
			}
		}
		return false;
	}

}
