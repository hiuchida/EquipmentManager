package ateam.logic;

import ateam.dao.BihinDAO;
import ateam.model.Bihin;

public class BihinAddLogic {
	public static boolean addBihin(Bihin bihin) {
		if (bihin == null) {
			return false;
		}
		BihinDAO dao = BihinDAO.getInstance();
		try {
			if (1 == dao.insert(bihin)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
