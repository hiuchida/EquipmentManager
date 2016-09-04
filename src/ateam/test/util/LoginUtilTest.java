package ateam.test.util;

import ateam.util.LoginUtil;
import junit.framework.TestCase;

public class LoginUtilTest extends TestCase {
	public void testIsLogined() throws Exception {
		assertFalse(LoginUtil.isLogined(null, null));
	}

}
