package ateam.test.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.RequestServlet;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class RequestServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		RequestServlet servlet = new RequestServlet();
		Method method = RequestServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
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
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("BihinListServlet", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoGet3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("bihinName", "ホワイトボード");
		request.setParameter("bihinID", "B001");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ホワイトボード", request.getAttribute("bihinName"));
		assertEquals("B001", request.getAttribute("bihinID"));
		assertEquals(null, response.getRedirect());
		assertEquals("/request.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoPost2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("BihinListServlet", response.getRedirect());
		assertEquals(null, request.getRequestDispatcherPath());
	}

	public void testDoPost3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("bihinName", "ホワイトボード");
		request.setParameter("bihinID", "B001");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ホワイトボード", request.getAttribute("bihinName"));
		assertEquals("B001", request.getAttribute("bihinID"));
		assertEquals(null, response.getRedirect());
		assertEquals("/request.jsp", request.getRequestDispatcherPath());
	}

}
