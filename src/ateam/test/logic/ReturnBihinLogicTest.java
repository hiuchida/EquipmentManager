package ateam.test.logic;

import java.sql.Date;

import ateam.logic.RequestLogic;
import ateam.logic.ReturnBihinLogic;
import junit.framework.TestCase;

public class ReturnBihinLogicTest extends TestCase {
	private final String datestr = "2016-12-24";
	private final Date date = Date.valueOf(datestr);

	public void testReturnBihin1() {
		RequestLogic.requestBihin("B002", "U002", date);
		assertTrue(ReturnBihinLogic.returnBihin("U002", "B002"));
	}

	public void testReturnBihin2() {
		assertFalse(ReturnBihinLogic.returnBihin("U001", "B005"));
		assertFalse(ReturnBihinLogic.returnBihin("U002", "B004"));
	}

	public void testReturnBihin3() {
		assertFalse(ReturnBihinLogic.returnBihin(null, "B001"));
		assertFalse(ReturnBihinLogic.returnBihin("", "B001"));
		assertFalse(ReturnBihinLogic.returnBihin("U001", null));
		assertFalse(ReturnBihinLogic.returnBihin("U001", ""));
		assertFalse(ReturnBihinLogic.returnBihin("U001", "Z"));
	}

}
