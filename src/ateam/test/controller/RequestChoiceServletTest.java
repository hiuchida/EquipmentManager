package ateam.test.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.RequestChoiceServlet;
import ateam.dao.BihinDAO;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class RequestChoiceServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		RequestChoiceServlet servlet = new RequestChoiceServlet();
		Method method = RequestChoiceServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
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
		assertEquals("BihinListServlet", response.getRedirect());
	}

	public void testDoGet3() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B001");
		request.setParameter("bihinName", "ホワイトボード");
		request.setParameter("returnDate", "2016-12-24");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B001", request.getAttribute("bihinID"));
		assertEquals("ホワイトボード", request.getAttribute("bihinName"));
		assertEquals("2016-12-24", request.getAttribute("returnDay"));
		assertEquals(null, response.getRedirect());
		assertEquals("/requestSuccess.jsp", request.getRequestDispatcherPath());
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B001", "U001"));
	}

	public void testDoGet4() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B004");
		request.setParameter("bihinName", "付箋Y");
		request.setParameter("returnDate", "2016-12-24");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B004", request.getAttribute("bihinID"));
		assertEquals("付箋Y", request.getAttribute("bihinName"));
		assertEquals("2016-12-24", request.getAttribute("returnDay"));
		assertEquals(null, response.getRedirect());
		assertEquals("/requestFail.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet5() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B004");
		request.setParameter("bihinName", "付箋Y");
		request.setParameter("returnDate", "yyyy");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B004", request.getAttribute("bihinID"));
		assertEquals("付箋Y", request.getAttribute("bihinName"));
		assertEquals("yyyy", request.getAttribute("returnDay"));
		assertEquals("正しい日付を入力してください", request.getAttribute("errorMessage"));
		assertEquals(null, response.getRedirect());
		assertEquals("/request.jsp", request.getRequestDispatcherPath());
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
		assertEquals("BihinListServlet", response.getRedirect());
	}

	public void testDoPost3() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B001");
		request.setParameter("bihinName", "ホワイトボード");
		request.setParameter("returnDate", "2016-12-24");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B001", request.getAttribute("bihinID"));
		assertEquals("ホワイトボード", request.getAttribute("bihinName"));
		assertEquals("2016-12-24", request.getAttribute("returnDay"));
		assertEquals(null, response.getRedirect());
		assertEquals("/requestSuccess.jsp", request.getRequestDispatcherPath());
		BihinDAO dao = BihinDAO.getInstance();
		assertEquals(1, dao.update("B001", "U001"));
	}

	public void testDoPost4() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B004");
		request.setParameter("bihinName", "付箋Y");
		request.setParameter("returnDate", "2016-12-24");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B004", request.getAttribute("bihinID"));
		assertEquals("付箋Y", request.getAttribute("bihinName"));
		assertEquals("2016-12-24", request.getAttribute("returnDay"));
		assertEquals(null, response.getRedirect());
		assertEquals("/requestFail.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost5() throws Exception {
		User user = new User();
		user.setUserID("U001");
		HttpServletRequestMock request = new HttpServletRequestMock(true, user);
		request.setParameter("bihinID", "B004");
		request.setParameter("bihinName", "付箋Y");
		request.setParameter("returnDate", "yyyy");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("B004", request.getAttribute("bihinID"));
		assertEquals("付箋Y", request.getAttribute("bihinName"));
		assertEquals("yyyy", request.getAttribute("returnDay"));
		assertEquals("正しい日付を入力してください", request.getAttribute("errorMessage"));
		assertEquals(null, response.getRedirect());
		assertEquals("/request.jsp", request.getRequestDispatcherPath());
	}

}
