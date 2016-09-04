package ateam.logic;

import ateam.dao.UserDAO;
import ateam.model.User;

public class UserAddLogic {
	public static boolean addUser(User user) {
		if (user == null) {
			return false;
		}
		UserDAO dao = UserDAO.getInstance();
		if (1 == dao.insert(user)) {
			return true;
		}
		return false;
	}

}
