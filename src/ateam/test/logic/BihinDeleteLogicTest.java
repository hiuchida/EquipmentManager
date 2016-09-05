package ateam.test.logic;

import ateam.dao.BihinDAO;
import ateam.logic.BihinDeleteLogic;
import ateam.model.Bihin;
import junit.framework.TestCase;

public class BihinDeleteLogicTest extends TestCase {
	public void testDeleteBihin1() {
		Bihin bihin = new Bihin();
		bihin.setBihinID("XXX");
		bihin.setBihinName("XXX");
		bihin.setBihinKana("XXX");
		bihin.setStatus(Bihin.AVAILABLE);
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.insert(bihin));
		assertTrue(BihinDeleteLogic.deleteBihin("XXX"));
	}

	public void testDeleteBihin2() {
		assertFalse(BihinDeleteLogic.deleteBihin(null));
		assertFalse(BihinDeleteLogic.deleteBihin(""));
		assertFalse(BihinDeleteLogic.deleteBihin("Z"));
	}

}
