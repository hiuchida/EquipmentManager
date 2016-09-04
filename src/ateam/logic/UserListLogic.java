package ateam.logic;

import java.util.List;

import ateam.dao.UserDAO;
import ateam.model.User;

public class UserListLogic {
	public static List<User> getAllUserList() {
		UserDAO dao = UserDAO.getInstance();
		List<User> list = dao.getUserList();
		return list;
	}

}
