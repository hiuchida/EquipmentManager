package ateam.test.servlet;

import junit.framework.TestCase;

public class HttpServletResponseTest extends TestCase {
	public void testSendRedirect() throws Exception {
		HttpServletResponseMock response = new HttpServletResponseMock();
		response.sendRedirect("LoginServlet");
		assertEquals("LoginServlet", response.getRedirect());
	}

}
