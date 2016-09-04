package ateam.test.util;

import ateam.util.LogUtil;
import junit.framework.TestCase;

public class LogUtilTest extends TestCase {
	public void testCreateLogDate() {
		LogUtil.createLogDate("B001", "U001");
		LogUtil.createLogDate("B004", "U001");
		LogUtil.createLogDate(null, "U001");
		LogUtil.createLogDate("", "U001");
		LogUtil.createLogDate("B001", null);
		LogUtil.createLogDate("B001", "");
	}

}
