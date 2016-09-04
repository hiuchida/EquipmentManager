package ateam.test.logic;

import ateam.dao.UserDAO;
import ateam.logic.UserDeleteLogic;
import ateam.model.User;
import junit.framework.TestCase;

public class UserDeleteLogicTest extends TestCase {
	public void testDeleteUser1() {
		User user = new User();
		user.setUserID("XXX");
		user.setPassword("XXX");
		user.setUserName("XXX");
		user.setUserKana("XXX");
		user.setDeptID("D001");
		user.setAuthority(User.GENERAL);
		UserDAO dao = UserDAO.getInstance();
		assertEquals(1, dao.insert(user));
		assertTrue(UserDeleteLogic.deleteUser("XXX"));
	}

	public void testDeleteUser2() {
		assertFalse(UserDeleteLogic.deleteUser(null));
		assertFalse(UserDeleteLogic.deleteUser(""));
		assertFalse(UserDeleteLogic.deleteUser("Z"));
	}

}
