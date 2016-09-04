package ateam.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ateam.logic.RequestLogic;
import ateam.model.User;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class RequestChoiceServlet
 */
@WebServlet("/RequestChoiceServlet")
public class RequestChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestChoiceServlet() {
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
		HttpSession session = request.getSession(false);
		if (!LoginUtil.isLogined(request, response)) {
			return;
		}
		request.setCharacterEncoding("UTF-8");
		User user = (User) session.getAttribute("user");
		String userID = user.getUserID();
		String bihinID = request.getParameter("bihinID");
		String bihinName = request.getParameter("bihinName");
		String returnDayStr = request.getParameter("returnDate");
		// 空文字判定
		if (bihinID == null || bihinID.isEmpty() || bihinName == null || bihinName.isEmpty() || returnDayStr == null
				|| returnDayStr.isEmpty()) {
			response.sendRedirect("BihinListServlet");
			return;
		}
		request.setAttribute("bihinID", bihinID);
		request.setAttribute("bihinName", bihinName);
		request.setAttribute("returnDay", returnDayStr);
		// 日付が正しいか判定
		Date returnDay = null;
		try {
			returnDay = Date.valueOf(returnDayStr);
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", "正しい日付を入力してください");
			request.getRequestDispatcher("/request.jsp").forward(request, response);
			return;
		}
		if (RequestLogic.requestBihin(bihinID, userID, returnDay)) {
			request.getRequestDispatcher("/requestSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/requestFail.jsp").forward(request, response);
		}
	}
}
