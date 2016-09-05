package ateam.test.logic;

import ateam.dao.DepartmentDAO;
import ateam.logic.DepartmentAddLogic;
import ateam.model.Department;
import junit.framework.TestCase;

public class DepartmentAddLogicTest extends TestCase {
	public void testAddDepartment1() {
		Department dept = new Department();
		dept.setDeptID("XXX");
		dept.setDeptName("XXX");
		dept.setDeptKana("XXX");
		assertTrue(DepartmentAddLogic.addDepartment(dept));
		DepartmentDAO dao = DepartmentDAO.getInstance();
		assertEquals(1, dao.delete("XXX"));
	}

	public void testAddDepartment2() {
		assertFalse(DepartmentAddLogic.addDepartment(null));
	}

}
