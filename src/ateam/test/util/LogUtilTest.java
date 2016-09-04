package ateam.test.util;

import ateam.util.LogUtil;
import junit.framework.TestCase;

public class LogUtilTest extends TestCase {
	public void testCreateLogDate() {
		LogUtil.createLogDate("U001", "B001");
		LogUtil.createLogDate("U001", "B004");
		LogUtil.createLogDate(null, "B001");
		LogUtil.createLogDate("", "B001");
		LogUtil.createLogDate("U001", null);
		LogUtil.createLogDate("U001", "");
	}

}
