package ateam.test.logic;

import java.sql.Date;

import ateam.dao.BihinDAO;
import ateam.logic.ReturnBihinLogic;
import junit.framework.TestCase;

public class ReturnBihinLogicTest extends TestCase {
	private final String datestr = "2016-12-24";
	private final Date date = Date.valueOf(datestr);

	public void testReturnBihin1() {
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B002", "U002", date));
		assertTrue(ReturnBihinLogic.returnBihin("B002", "U002"));
	}

	public void testReturnBihin2() {
		assertFalse(ReturnBihinLogic.returnBihin("B005", "U001"));
		assertFalse(ReturnBihinLogic.returnBihin("B004", "U002"));
	}

	public void testReturnBihin3() {
		assertFalse(ReturnBihinLogic.returnBihin(null, "U001"));
		assertFalse(ReturnBihinLogic.returnBihin("", "U001"));
		assertFalse(ReturnBihinLogic.returnBihin("B001", null));
		assertFalse(ReturnBihinLogic.returnBihin("B001", ""));
		assertFalse(ReturnBihinLogic.returnBihin("Z", "U001"));
	}

	public void testReturnBihinByAdmin1() {
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B002", "U002", date));
		assertTrue(ReturnBihinLogic.returnBihinByAdmin("B002", "U004"));
	}

	public void testReturnBihinByAdmin2() {
		assertFalse(ReturnBihinLogic.returnBihinByAdmin("B005", "U001"));
	}

	public void testReturnBihinByAdmin3() {
		assertFalse(ReturnBihinLogic.returnBihinByAdmin(null, "U001"));
		assertFalse(ReturnBihinLogic.returnBihinByAdmin("", "U001"));
		assertFalse(ReturnBihinLogic.returnBihinByAdmin("B001", null));
		assertFalse(ReturnBihinLogic.returnBihinByAdmin("B001", ""));
		assertFalse(ReturnBihinLogic.returnBihinByAdmin("Z", "U001"));
	}

}
