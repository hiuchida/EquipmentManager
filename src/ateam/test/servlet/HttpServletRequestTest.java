package ateam.test.servlet;

import javax.servlet.http.HttpSession;

import ateam.model.User;
import junit.framework.TestCase;

public class HttpServletRequestTest extends TestCase {
	public void testGetSession1() {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpSession session = request.getSession(false);
		assertNull(session);
		session = request.getSession(true);
		assertNotNull(session);
	}

	public void testGetSession2() {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpSession session = request.getSession();
		assertNotNull(session);
	}

	public void testGetSession3() {
		HttpServletRequestMock request = new HttpServletRequestMock(true, null);
		HttpSession session = request.getSession(false);
		assertNotNull(session);
	}

	public void testGetSession4() {
		User user = new User();
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		HttpSession session = request.getSession(false);
		assertNotNull(session);
		assertEquals(user, session.getAttribute("user"));
	}

	public void testGetCharacterEncoding() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setCharacterEncoding("UTF-8");
		assertEquals("UTF-8", request.getCharacterEncoding());
	}

	public void testGetAttribute() {
		User user = new User();
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setAttribute("user", user);
		assertEquals(user, request.getAttribute("user"));
	}

	public void testGetRequestDispatcher() {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		assertNotNull(request.getRequestDispatcher("/login.jsp"));
		assertEquals("/login.jsp", request.getRequestDispatcherPath());
	}

	public void testGetParameter() {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setParameter("userID", "U001");
		assertEquals("U001", request.getParameter("userID"));
	}

}
