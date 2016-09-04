package ateam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setAttribute("bihinName", bihinName);
		request.setAttribute("bihinID", bihinID);
		if (bihinName != null) {
			request.getRequestDispatcher("/request.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/MyPageServlet").forward(request, response);
		}
	}

}
