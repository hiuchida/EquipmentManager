package ateam.test.util;

import java.sql.Date;

import ateam.model.Bihin;
import ateam.util.BihinUtil;
import junit.framework.TestCase;

public class BihinUtilTest extends TestCase {
	public void testGetStatusStr() {
		assertEquals("利用可能", BihinUtil.getStatusStr(1));
		assertEquals("貸出中", BihinUtil.getStatusStr(2));
		assertEquals("返却済み", BihinUtil.getStatusStr(3));
		assertEquals("貸出申請中", BihinUtil.getStatusStr(4));
		assertEquals("???", BihinUtil.getStatusStr(0));
	}

	public void testGetReturnDayStr() {
		String datestr = "2016-12-24";
		Date date = Date.valueOf(datestr);
		assertEquals(datestr, BihinUtil.getReturnDayStr(date));
		assertEquals("---", BihinUtil.getReturnDayStr(null));
	}

	public void testIsOverdue() {
		Bihin bihin = new Bihin();
		Date today = new Date(System.currentTimeMillis());
		bihin.setReturnDay(today);
		assertFalse(BihinUtil.isOverdue(bihin));
		today = new Date(System.currentTimeMillis() - 1000 * 3600 * 24);
		bihin.setReturnDay(today);
		assertTrue(BihinUtil.isOverdue(bihin));
		bihin.setReturnDay(null);
		assertFalse(BihinUtil.isOverdue(bihin));
	}

}
