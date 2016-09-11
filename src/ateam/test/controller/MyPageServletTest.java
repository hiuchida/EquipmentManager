package ateam.test.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.MyPageServlet;
import ateam.model.Bihin;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class MyPageServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		MyPageServlet servlet = new MyPageServlet();
		Method method = MyPageServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
				HttpServletResponse.class);
		method.setAccessible(true);
		method.invoke(servlet, request, response);
	}

	public void testDoGet1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoGet2() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(1, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/myPage.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoPost2() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(1, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/myPage.jsp", request.getRequestDispatcherPath());
	}

}
