package ateam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ateam.logic.ReturnBihinLogic;
import ateam.model.User;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class ReturnBihinServlet
 */
@WebServlet("/ReturnBihinServlet")
public class ReturnBihinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnBihinServlet() {
		super();
	}

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
		HttpSession session = request.getSession(false);
		if (!LoginUtil.isLogined(request, response)) {
			return;
		}
		User user = (User) session.getAttribute("user");
		String bihinID = request.getParameter("bihinID");
		// 空文字判定
		if (bihinID == null || bihinID.isEmpty()) {
			response.sendRedirect("MyPageServlet");
			return;
		}
		if (ReturnBihinLogic.returnBihin(user.getUserID(), bihinID)) {
			request.getRequestDispatcher("/returnSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/returnFail.jsp").forward(request, response);
		}
	}

}
