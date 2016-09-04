package ateam.test.util;

import ateam.util.UserUtil;
import junit.framework.TestCase;

public class UserUtilTest extends TestCase {
	public void testGetUserName() {
		assertEquals("田中", UserUtil.getUserName("U001"));
		assertEquals("---", UserUtil.getUserName("Z"));
		assertEquals("---", UserUtil.getUserName(""));
		assertEquals("---", UserUtil.getUserName(null));
	}

}
