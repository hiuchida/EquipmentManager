package ateam.test.controller;

import java.lang.reflect.Method;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.ReturnBihinServlet;
import ateam.dao.BihinDAO;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class ReturnBihinServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		ReturnBihinServlet servlet = new ReturnBihinServlet();
		Method method = ReturnBihinServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
				HttpServletResponse.class);
		method.setAccessible(true);
		method.invoke(servlet, request, response);
	}

	public void testDoGet1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
	}

	public void testDoGet2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("MyPageServlet", response.getRedirect());
	}

	public void testDoGet3() throws Exception {
		String datestr = "2016-12-24";
		Date date = Date.valueOf(datestr);
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B002", "U002", date));
		User user = new User();
		user.setUserID("U002");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B002");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals(null, response.getRedirect());
		assertEquals("/returnSuccess.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet4() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B005");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals(null, response.getRedirect());
		assertEquals("/returnFail.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost1() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(false, null);
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("LoginServlet?timeout=true", response.getRedirect());
	}

	public void testDoPost2() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("MyPageServlet", response.getRedirect());
	}

	public void testDoPost3() throws Exception {
		String datestr = "2016-12-24";
		Date date = Date.valueOf(datestr);
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B002", "U002", date));
		User user = new User();
		user.setUserID("U002");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B002");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals(null, response.getRedirect());
		assertEquals("/returnSuccess.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost4() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B005");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals(null, response.getRedirect());
		assertEquals("/returnFail.jsp", request.getRequestDispatcherPath());
	}

}
