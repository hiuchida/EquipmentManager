package ateam.logic;

import ateam.dao.BihinDAO;

public class BihinDeleteLogic {
	public static boolean deleteBihin(String bihinID) {
		if (bihinID == null || bihinID.isEmpty()) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		if (1 == dao.delete(bihinID)) {
			return true;
		}
		return false;
	}

}
