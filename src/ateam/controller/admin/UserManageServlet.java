package ateam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.UserListLogic;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManageServlet() {
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
		String add = request.getParameter("add");
		String delete = request.getParameter("delete");
		if ("true".equals(add)) {
			request.setAttribute("errorMessage", "ユーザの登録に成功しました");
		} else if ("false".equals(add)) {
			request.setAttribute("errorMessage", "ユーザの登録に失敗しました");
		} else if ("true".equals(delete)) {
			request.setAttribute("errorMessage", "ユーザの削除に成功しました");
		} else if ("false".equals(delete)) {
			request.setAttribute("errorMessage", "ユーザの削除に失敗しました");
		}
		request.setAttribute("userList", UserListLogic.getAllUserList());
		request.getRequestDispatcher("/admin/userList.jsp").forward(request, response);
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
