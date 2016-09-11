package ateam.test.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ateam.controller.LoginServlet;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class LoginServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		LoginServlet servlet = new LoginServlet();
		Method method = LoginServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
				HttpServletResponse.class);
		method.setAccessible(true);
		method.invoke(servlet, request, response);
	}

	public void testDoGet1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals(null, response.getRedirect());
		assertEquals("/login.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setParameter("timeout", "true");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ログインしてください", request.getAttribute("errorMessage"));
		assertEquals(null, response.getRedirect());
		assertEquals("/login.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setParameter("userID", "U001");
		request.setParameter("password", "A0000001");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		HttpSession session = request.getSession();
		assertNotNull(session);
		User user = (User)session.getAttribute("user");
		assertNotNull(user);
		assertEquals("", user.getPassword());
		assertEquals("MyPageServlet", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoPost2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		request.setParameter("userID", "U001");
		request.setParameter("password", "A000");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ログインに失敗しました。", request.getAttribute("errorMessage"));
		assertEquals(null, response.getRedirect());
		assertEquals("/login.jsp", request.getRequestDispatcherPath());
	}

}
