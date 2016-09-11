package ateam.test.controller.admin;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.controller.admin.UserManageServlet;
import ateam.model.User;
import ateam.test.servlet.HttpServletRequestMock;
import ateam.test.servlet.HttpServletResponseMock;
import junit.framework.TestCase;

public class UserManageServletTest extends TestCase {
	private void invoke(String name, HttpServletRequestMock request, HttpServletResponseMock response)
			throws Exception {
		UserManageServlet servlet = new UserManageServlet();
		Method method = UserManageServlet.class.getDeclaredMethod(name, HttpServletRequest.class,
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
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("add", "true");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの登録に成功しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet4() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("add", "false");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの登録に失敗しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet5() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("delete", "true");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの削除に成功しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoGet6() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("delete", "false");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doGet", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの削除に失敗しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
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
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost3() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("add", "true");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの登録に成功しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost4() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("add", "false");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの登録に失敗しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost5() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("delete", "true");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの削除に成功しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

	public void testDoPost6() throws Exception {
		HttpServletRequestMock request = new HttpServletRequestMock(true, new User());
		request.setParameter("delete", "false");
		HttpServletResponseMock response = new HttpServletResponseMock();
		invoke("doPost", request, response);
		assertEquals("UTF-8", request.getCharacterEncoding());
		assertEquals("ユーザの削除に失敗しました", request.getAttribute("errorMessage"));
		List<User> list = (List<User>)request.getAttribute("userList");
		assertEquals(8, list.size());
		assertEquals(null, response.getRedirect());
		assertEquals("/admin/userList.jsp", request.getRequestDispatcherPath());
	}

}
