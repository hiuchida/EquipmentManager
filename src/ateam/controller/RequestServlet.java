package ateam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.util.LoginUtil;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!LoginUtil.isLogined(request, response)) {
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String bihinName = request.getParameter("bihinName");
		String bihinID = request.getParameter("bihinID");
		// 空文字判定
		if (bihinName == null || bihinName.isEmpty() || bihinID == null || bihinID.isEmpty()) {
			response.sendRedirect("BihinListServlet");
			return;
		}
		request.setAttribute("bihinName", bihinName);
		request.setAttribute("bihinID", bihinID);
		request.getRequestDispatcher("/request.jsp").forward(request, response);
	}

}
