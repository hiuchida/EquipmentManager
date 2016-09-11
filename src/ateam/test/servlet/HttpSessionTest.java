package ateam.test.servlet;

import javax.servlet.http.HttpSession;

import ateam.model.User;
import junit.framework.TestCase;

public class HttpSessionTest extends TestCase {
	public void testInvalidate() {
		HttpServletRequestMock request = new HttpServletRequestMock(true, null);
		HttpSession session = request.getSession(false);
		assertNotNull(session);
		session.invalidate();
		session = request.getSession(false);
		assertNull(session);
	}

	public void testGetAttribute() {
		User user = new User();
		HttpServletRequestMock request = new HttpServletRequestMock(true, null);
		HttpSession session = request.getSession(false);
		session.setAttribute("user", user);
		assertEquals(user, session.getAttribute("user"));
	}

}
