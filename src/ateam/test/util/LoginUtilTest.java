package ateam.test.util;

import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import ateam.util.LoginUtil;
import junit.framework.TestCase;

public class LoginUtilTest extends TestCase {
	public void testIsLogined1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		assertFalse(LoginUtil.isLogined(request, response));
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
	}

	public void testIsLogined2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		assertFalse(LoginUtil.isLogined(request, response));
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
	}

	public void testIsLogined3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		HttpServletResponseMock response = new HttpServletResponseMock();
		assertTrue(LoginUtil.isLogined(request, response));
		assertEquals(null, response.getRedirect());
	}

	public void testIsLogined4() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		assertFalse(LoginUtil.isLogined(request, null));
		assertFalse(LoginUtil.isLogined(null, response));
		assertFalse(LoginUtil.isLogined(null, null));
	}

}
