package ateam.test.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.BihinSearchServlet;
import ateam.model.Bihin;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class BihinSearchServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		BihinSearchServlet servlet = new BihinSearchServlet();
		Method method = BihinSearchServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
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
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(15, list.size());
		assertNull(request.getAttribute("bihinKana"));
		assertNull(request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("status", "success");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(14, list.size());
		assertNull(request.getAttribute("bihinKana"));
		assertEquals("success", request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet4() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("search", "フセン");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(3, list.size());
		assertEquals("フセン", request.getAttribute("bihinKana"));
		assertNull(request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet5() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("search", "フセン");
		request.setParameter("status", "success");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(2, list.size());
		assertEquals("フセン", request.getAttribute("bihinKana"));
		assertEquals("success", request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
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
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(15, list.size());
		assertNull(request.getAttribute("bihinKana"));
		assertNull(request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("status", "success");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(14, list.size());
		assertNull(request.getAttribute("bihinKana"));
		assertEquals("success", request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost4() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("search", "フセン");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(3, list.size());
		assertEquals("フセン", request.getAttribute("bihinKana"));
		assertNull(request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost5() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("search", "フセン");
		request.setParameter("status", "success");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals(null, response.getRedirect());
		assertEquals("UTF-8", request.getCharacterEncoding());
		List<Bihin> list = (List<Bihin>)request.getAttribute("bihinList");
		assertEquals(2, list.size());
		assertEquals("フセン", request.getAttribute("bihinKana"));
		assertEquals("success", request.getAttribute("statusName"));
		assertEquals("/bihinList.jsp", request.getRequestDispatcherPath());
	}

}
