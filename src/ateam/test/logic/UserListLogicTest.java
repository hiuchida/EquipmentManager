package ateam.test.logic;

import java.util.List;

import ateam.logic.UserListLogic;
import ateam.model.User;
import junit.framework.TestCase;

public class UserListLogicTest extends TestCase {
	public void testGetAllUserList() {
		List<User> list = UserListLogic.getAllUserList();
		assertEquals(8, list.size());
		assertEquals("U001", list.get(0).getUserID());
		assertEquals("U002", list.get(1).getUserID());
		assertEquals("U003", list.get(2).getUserID());
	}

}
