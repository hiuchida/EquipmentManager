package ateam.test.logic;

import ateam.dao.DepartmentDAO;
import ateam.logic.DepartmentDeleteLogic;
import ateam.model.Department;
import junit.framework.TestCase;

public class DepartmentDeleteLogicTest extends TestCase {
	public void testDeleteDepartment1() {
		Department dept = new Department();
		dept.setDeptID("XXX");
		dept.setDeptName("XXX");
		dept.setDeptKana("XXX");
		DepartmentDAO dao = DepartmentDAO.getInstance();
		assertEquals(1, dao.insert(dept));
		assertTrue(DepartmentDeleteLogic.deleteDepartment("XXX"));
	}

	public void testDeleteDepartment2() {
		assertFalse(DepartmentDeleteLogic.deleteDepartment(null));
		assertFalse(DepartmentDeleteLogic.deleteDepartment(""));
		assertFalse(DepartmentDeleteLogic.deleteDepartment("Z"));
	}

}
