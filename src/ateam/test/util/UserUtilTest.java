package ateam.test.util;

import ateam.model.User;
import ateam.util.UserUtil;
import junit.framework.TestCase;

public class UserUtilTest extends TestCase {
	public void testGetAuthorityStr() {
		assertEquals("一般", UserUtil.getAuthorityStr(1));
		assertEquals("管理者", UserUtil.getAuthorityStr(2));
		assertEquals("???", UserUtil.getAuthorityStr(0));
	}

	public void testGetUserName() {
		assertEquals("田中", UserUtil.getUserName("U001"));
		assertEquals("---", UserUtil.getUserName("Z"));
		assertEquals("---", UserUtil.getUserName(""));
		assertEquals("---", UserUtil.getUserName(null));
	}

	public void testIsAdministrator() {
		User user = new User();
		user.setAuthority(User.ADMINISTRATOR);
		assertTrue(UserUtil.isAdministrator(user));
		user.setAuthority(User.GENERAL);
		assertFalse(UserUtil.isAdministrator(user));
		assertFalse(UserUtil.isAdministrator(null));
	}

}
