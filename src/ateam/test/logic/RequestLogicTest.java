package ateam.test.logic;

import java.sql.Date;

import ateam.dao.BihinDAO;
import ateam.logic.RequestLogic;
import junit.framework.TestCase;

public class RequestLogicTest extends TestCase {
	private final String datestr = "2016-12-24";
	private final Date date = Date.valueOf(datestr);

	public void testRequestBihin1() {
		assertTrue(RequestLogic.requestBihin("B001", "U001", date));
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B001", "U001"));
	}

	public void testRequestBihin2() {
		assertFalse(RequestLogic.requestBihin("B004", "U001", date));
		assertFalse(RequestLogic.requestBihin("B004", "U002", date));
	}

	public void testRequestBihin3() {
		assertFalse(RequestLogic.requestBihin(null, "U001", date));
		assertFalse(RequestLogic.requestBihin("", "U001", date));
		assertFalse(RequestLogic.requestBihin("B001", null, date));
		assertFalse(RequestLogic.requestBihin("B001", "", date));
		assertFalse(RequestLogic.requestBihin("B001", "U001", null));
		assertFalse(RequestLogic.requestBihin("Z", "U001", date));
	}

}
