package ateam.test.logic;

import java.util.List;

import ateam.logic.DepartmentListLogic;
import ateam.model.Department;
import junit.framework.TestCase;

public class DepartmentListLogicTest extends TestCase {
	public void testGetAllDepartmentList() {
		List<Department> list = DepartmentListLogic.getAllDepartmentList();
		assertEquals(5, list.size());
		assertEquals("D001", list.get(0).getDeptID());
		assertEquals("D002", list.get(1).getDeptID());
		assertEquals("D003", list.get(2).getDeptID());
	}

}
