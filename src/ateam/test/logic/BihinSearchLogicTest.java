package ateam.test.logic;

import java.util.List;

import ateam.logic.BihinSearchLogic;
import ateam.model.Bihin;
import junit.framework.TestCase;;

public class BihinSearchLogicTest extends TestCase {
	public void testGetBihinSearchList1_1() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList(1);
		assertEquals(14, list.size());
		assertEquals("B001", list.get(0).getBihinID());
		assertEquals("B002", list.get(1).getBihinID());
		assertEquals("B003", list.get(2).getBihinID());
	}

	public void testGetBihinSearchList1_2() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList(2);
		assertEquals(1, list.size());
		assertEquals("B004", list.get(0).getBihinID());
	}

	public void testGetBihinSearchList2_1_1() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("フセン", "フセン", 1);
		assertEquals(2, list.size());
		assertEquals("B007", list.get(0).getBihinID());
		assertEquals("B008", list.get(1).getBihinID());
	}

	public void testGetBihinSearchList2_1_2() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("ふせん", "ふせん", 1);
		assertEquals(2, list.size());
		assertEquals("B007", list.get(0).getBihinID());
		assertEquals("B008", list.get(1).getBihinID());
	}

	public void testGetBihinSearchList2_1_3() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("付箋", "付箋", 1);
		assertEquals(2, list.size());
		assertEquals("B007", list.get(0).getBihinID());
		assertEquals("B008", list.get(1).getBihinID());
	}

	public void testGetBihinSearchList2_1_4() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("z", "z", 1);
		assertEquals(0, list.size());
	}

	public void testGetBihinSearchList2_2_1() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("フセン", "フセン", 2);
		assertEquals(1, list.size());
		assertEquals("B004", list.get(0).getBihinID());
	}

	public void testGetBihinSearchList2_2_2() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("ふせん", "ふせん", 2);
		assertEquals(1, list.size());
		assertEquals("B004", list.get(0).getBihinID());
	}

	public void testGetBihinSearchList2_2_3() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("付箋", "付箋", 2);
		assertEquals(1, list.size());
		assertEquals("B004", list.get(0).getBihinID());
	}

	public void testGetBihinSearchList2_2_4() {
		List<Bihin> list = BihinSearchLogic.getBihinSearchList("z", "z", 2);
		assertEquals(0, list.size());
	}

	public void testGetBihinSearchList3_1() {
		List<Bihin> list = BihinSearchLogic.getBihinSeachList("フセン", "フセン");
		assertEquals(3, list.size());
		assertEquals("B004", list.get(0).getBihinID());
		assertEquals("B007", list.get(1).getBihinID());
		assertEquals("B008", list.get(2).getBihinID());
	}

	public void testGetBihinSearchList3_2() {
		List<Bihin> list = BihinSearchLogic.getBihinSeachList("ふせん", "ふせん");
		assertEquals(3, list.size());
		assertEquals("B004", list.get(0).getBihinID());
		assertEquals("B007", list.get(1).getBihinID());
		assertEquals("B008", list.get(2).getBihinID());
	}

	public void testGetBihinSearchList3_3() {
		List<Bihin> list = BihinSearchLogic.getBihinSeachList("付箋", "付箋");
		assertEquals(3, list.size());
		assertEquals("B004", list.get(0).getBihinID());
		assertEquals("B007", list.get(1).getBihinID());
		assertEquals("B008", list.get(2).getBihinID());
	}

	public void testGetBihinSearchList3_4() {
		List<Bihin> list = BihinSearchLogic.getBihinSeachList("z", "z");
		assertEquals(0, list.size());
	}

	public void testGetStatusSearch() {
		assertEquals(1, BihinSearchLogic.getStatusSearch("success"));
		assertEquals(2, BihinSearchLogic.getStatusSearch("fail"));
		assertEquals(0, BihinSearchLogic.getStatusSearch(""));
		assertEquals(0, BihinSearchLogic.getStatusSearch(null));
	}

}
