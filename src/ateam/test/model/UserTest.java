package ateam.test.model;

import ateam.model.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {
	private final String str10 = "1234567890";
	private final String str20 = str10 + str10;
	private final String str21 = str20 + "1";
	private final String str50 = str20 + str20 + str10;
	private final String str51 = str50 + "1";
	private final String str100 = str50 + str50;
	private final String str101 = str100 + "1";

	public void testConst() {
		assertEquals(1, User.GENERAL);
		assertEquals(2, User.ADMINISTRATOR);
	}

	public void testDefault() {
		User user = new User();
		assertEquals("", user.getUserID());
		assertEquals("", user.getPassword());
		assertEquals("", user.getUserName());
		assertEquals("", user.getUserKana());
		assertEquals("", user.getDeptID());
		assertEquals(1, user.getAuthority());
	}

	public void testGetUserID() {
		User user = new User();
		user.setUserID("XXX");
		assertEquals("XXX", user.getUserID());
	}

	public void testSetUserID() {
		User user = new User();
		user.setUserID(null);
		assertEquals("", user.getUserID());
		user.setUserID(str21);
		assertEquals(str20, user.getUserID());
	}

	public void testGetPassword() {
		User user = new User();
		user.setPassword("XXX");
		assertEquals("XXX", user.getPassword());
	}

	public void testSetPassword() {
		User user = new User();
		user.setPassword(null);
		assertEquals("", user.getPassword());
		user.setPassword(str51);
		assertEquals(str50, user.getPassword());
	}

	public void testGetUserName() {
		User user = new User();
		user.setUserName("XXX");
		assertEquals("XXX", user.getUserName());
	}

	public void testSetUserName() {
		User user = new User();
		user.setUserName(null);
		assertEquals("", user.getUserName());
		user.setUserName(str51);
		assertEquals(str50, user.getUserName());
	}

	public void testGetKana() {
		User user = new User();
		user.setUserKana("XXX");
		assertEquals("XXX", user.getUserKana());
	}

	public void testSetKana() {
		User user = new User();
		user.setUserKana(null);
		assertEquals("", user.getUserKana());
		user.setUserKana(str101);
		assertEquals(str100, user.getUserKana());
	}

	public void testGetDeptID() {
		User user = new User();
		user.setDeptID("XXX");
		assertEquals("XXX", user.getDeptID());
	}

	public void testSetDeptID() {
		User user = new User();
		user.setDeptID(null);
		assertEquals("", user.getDeptID());
		user.setDeptID(str21);
		assertEquals(str20, user.getDeptID());
	}

	public void testGetAuthority() {
		User user = new User();
		user.setAuthority(1);
		assertEquals(1, user.getAuthority());
	}

	public void testSetAuthority() {
		User user = new User();
		user.setAuthority(0);
		assertEquals(1, user.getAuthority());
		user.setAuthority(3);
		assertEquals(1, user.getAuthority());
	}

}
