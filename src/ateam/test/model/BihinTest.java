package ateam.test.model;

import java.sql.Date;

import ateam.model.Bihin;
import junit.framework.TestCase;

public class BihinTest extends TestCase {
	private final String str10 = "1234567890";
	private final String str20 = str10 + str10;
	private final String str21 = str20 + "1";
	private final String str50 = str20 + str20 + str10;
	private final String str51 = str50 + "1";
	private final String str100 = str50 + str50;
	private final String str101 = str100 + "1";

	public void testConst() {
		assertEquals(1, Bihin.AVAILABLE);
		assertEquals(2, Bihin.USED);
		assertEquals(3, Bihin.RETURNED);
		assertEquals(4, Bihin.PENDING);
		assertEquals(0, Bihin.OTHER);
	}

	public void testDefault() {
		Bihin bihin = new Bihin();
		assertEquals("", bihin.getBihinID());
		assertEquals("", bihin.getBihinName());
		assertEquals("", bihin.getBihinKana());
		assertEquals(1, bihin.getStatus());
		assertNull(bihin.getUserID());
		assertNull(bihin.getReturnDay());
	}

	public void testGetBihinID() {
		Bihin bihin = new Bihin();
		bihin.setBihinID("XXX");
		assertEquals("XXX", bihin.getBihinID());
	}

	public void testSetBihinID() {
		Bihin bihin = new Bihin();
		bihin.setBihinID(null);
		assertEquals("", bihin.getBihinID());
		bihin.setBihinID(str21);
		assertEquals(str20, bihin.getBihinID());
	}

	public void testGetBihinName() {
		Bihin bihin = new Bihin();
		bihin.setBihinName("XXX");
		assertEquals("XXX", bihin.getBihinName());
	}

	public void testSetBihinName() {
		Bihin bihin = new Bihin();
		bihin.setBihinName(null);
		assertEquals("", bihin.getBihinName());
		bihin.setBihinName(str51);
		assertEquals(str50, bihin.getBihinName());
	}

	public void testGetBihinKana() {
		Bihin bihin = new Bihin();
		bihin.setBihinKana("XXX");
		assertEquals("XXX", bihin.getBihinKana());
	}

	public void testSetBihinKana() {
		Bihin bihin = new Bihin();
		bihin.setBihinKana(null);
		assertEquals("", bihin.getBihinKana());
		bihin.setBihinKana(str101);
		assertEquals(str100, bihin.getBihinKana());
	}

	public void testGetStatus() {
		Bihin bihin = new Bihin();
		bihin.setStatus(1);
		assertEquals(1, bihin.getStatus());
	}

	public void testSetStatus() {
		Bihin bihin = new Bihin();
		bihin.setStatus(0);
		assertEquals(1, bihin.getStatus());
		bihin.setStatus(5);
		assertEquals(1, bihin.getStatus());
	}

	public void testGetUserID() {
		Bihin bihin = new Bihin();
		bihin.setUserID("XXX");
		assertEquals("XXX", bihin.getUserID());
	}

	public void testSetUserID() {
		Bihin bihin = new Bihin();
		bihin.setUserID(str21);
		assertEquals(str20, bihin.getUserID());
		bihin.setUserID(null);
		assertNull(bihin.getUserID());
	}

	public void testGetReturnDay() {
		Bihin bihin = new Bihin();
		String datestr = "2016-12-24";
		Date date = Date.valueOf(datestr);
		bihin.setReturnDay(date);
		assertEquals(date, bihin.getReturnDay());
	}

	public void testSetReturnDay() {
		Bihin bihin = new Bihin();
		String datestr = "2016-12-24";
		Date date = Date.valueOf(datestr);
		bihin.setReturnDay(date);
		assertEquals(date, bihin.getReturnDay());
		bihin.setReturnDay(null);
		assertNull(bihin.getReturnDay());
	}

}
