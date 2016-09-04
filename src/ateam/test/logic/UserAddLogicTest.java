package ateam.test.logic;

import ateam.dao.UserDAO;
import ateam.logic.UserAddLogic;
import ateam.model.User;
import junit.framework.TestCase;

public class UserAddLogicTest extends TestCase {
	public void testAddUser1() {
		User user = new User();
		user.setUserID("XXX");
		user.setPassword("XXX");
		user.setUserName("XXX");
		user.setUserKana("XXX");
		user.setDeptID("D001");
		user.setAuthority(User.GENERAL);
		assertTrue(UserAddLogic.addUser(user));
		UserDAO dao = UserDAO.getInstance();
		assertEquals(1, dao.delete("XXX"));
	}

	public void testAddUser2() {
		assertFalse(UserAddLogic.addUser(null));
	}

}
