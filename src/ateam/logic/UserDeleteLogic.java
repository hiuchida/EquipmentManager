package ateam.logic;

import ateam.dao.UserDAO;

public class UserDeleteLogic {
	public static boolean deleteUser(String userID) {
		if (userID == null || userID.isEmpty()) {
			return false;
		}
		UserDAO dao = UserDAO.getInstance();
		if (1 == dao.delete(userID)) {
			return true;
		}
		return false;
	}

}
