package ateam.test.model;

import ateam.model.Department;
import junit.framework.TestCase;

public class DepartmetTest extends TestCase {
	private final String str10 = "1234567890";
	private final String str20 = str10 + str10;
	private final String str21 = str20 + "1";
	private final String str50 = str20 + str20 + str10;
	private final String str51 = str50 + "1";
	private final String str100 = str50 + str50;
	private final String str101 = str100 + "1";

	public void testDefault() {
		Department department = new Department();
		assertEquals("", department.getDeptID());
		assertEquals("", department.getDeptName());
		assertEquals("", department.getDeptKana());
	}

	public void testGetDeptID() {
		Department department = new Department();
		department.setDeptID("XXX");
		assertEquals("XXX", department.getDeptID());
	}

	public void testSetDeptID() {
		Department department = new Department();
		department.setDeptID(null);
		assertEquals("", department.getDeptID());
		department.setDeptID(str21);
		assertEquals(str20, department.getDeptID());
	}

	public void testGetDeptName() {
		Department department = new Department();
		department.setDeptName("XXX");
		assertEquals("XXX", department.getDeptName());
	}

	public void testSetDeptName() {
		Department department = new Department();
		department.setDeptName(null);
		assertEquals("", department.getDeptName());
		department.setDeptName(str51);
		assertEquals(str50, department.getDeptName());
	}

	public void testGetDeptKana() {
		Department department = new Department();
		department.setDeptKana("XXX");
		assertEquals("XXX", department.getDeptKana());
	}

	public void testSetDeptKana() {
		Department department = new Department();
		department.setDeptKana(null);
		assertEquals("", department.getDeptKana());
		department.setDeptKana(str101);
		assertEquals(str100, department.getDeptKana());
	}

}
