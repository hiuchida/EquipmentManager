package ateam.util;

import ateam.dao.UserDAO;
import ateam.model.User;

public class UserUtil {
	public static String getAuthorityStr(int auth) {
		String authName = null;
		switch (auth) {
		case User.GENERAL:
			authName = "一般";
			break;
		case User.ADMINISTRATOR:
			authName = "管理者";
			break;
		default:
			authName = "???";
			break;
		}
		return authName;
	}

	// nullのときは---を返す
	public static String getUserName(String userID) {
		if (userID == null || userID.isEmpty()) {
			return "---";
		}
		UserDAO dao = UserDAO.getInstance();
		User user = dao.getUser(userID);
		if (user != null) {
			return user.getUserName();
		} else {
			return "---";
		}
	}

	public static boolean isAdministrator(User user) {
		if (user == null) {
			return false;
		}
		return user.getAuthority() == User.ADMINISTRATOR;
	}

}
