package ateam.test.util;

import ateam.util.DepartmentUtil;
import junit.framework.TestCase;

public class DepartmentUtilTest extends TestCase {
	public void testGetDeptName() {
		assertEquals("経理部", DepartmentUtil.getDeptName("D001"));
		assertEquals("未所属", DepartmentUtil.getDeptName("Z"));
		assertEquals("未所属", DepartmentUtil.getDeptName(""));
		assertEquals("未所属", DepartmentUtil.getDeptName(null));
	}

}
