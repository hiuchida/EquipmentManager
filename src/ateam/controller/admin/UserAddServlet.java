package ateam.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.UserAddLogic;
import ateam.model.User;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!LoginUtil.isLogined(request, response)) {
			return;
		}
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String userKana = request.getParameter("userKana");
		String deptID = request.getParameter("deptID");
		String authStr = request.getParameter("authority");
		// 空文字判定
		if (userID == null || userID.isEmpty() || password == null || password.isEmpty() || userName == null
				|| userName.isEmpty() || userKana == null || userKana.isEmpty() || deptID == null || deptID.isEmpty()
				|| authStr == null || authStr.isEmpty()) {
			response.sendRedirect("UserManageServlet?add=false");
			return;
		}
		int auth = User.GENERAL;
		try {
			auth = Integer.parseInt(authStr);
		} catch (Exception e) {
		}
		User user = new User();
		user.setUserID(userID);
		user.setPassword(password);
		user.setUserName(userName);
		user.setUserKana(userKana);
		user.setDeptID(deptID);
		user.setAuthority(auth);
		boolean rc = UserAddLogic.addUser(user);
		response.sendRedirect("UserManageServlet?add=" + rc);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
