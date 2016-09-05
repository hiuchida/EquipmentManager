package ateam.test.logic;

import ateam.dao.BihinDAO;
import ateam.logic.BihinAddLogic;
import ateam.model.Bihin;
import junit.framework.TestCase;

public class BihinAddLogicTest extends TestCase {
	public void testAddBihin1() {
		Bihin bihin = new Bihin();
		bihin.setBihinID("XXX");
		bihin.setBihinName("XXX");
		bihin.setBihinKana("XXX");
		bihin.setStatus(Bihin.AVAILABLE);
		assertTrue(BihinAddLogic.addBihin(bihin));
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.delete("XXX"));
	}

	public void testAddBihin2() {
		assertFalse(BihinAddLogic.addBihin(null));
	}

}
