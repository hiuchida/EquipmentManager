package ateam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.DepartmentDeleteLogic;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class DepartmentDeleteServlet
 */
@WebServlet("/DepartmentDeleteServlet")
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentDeleteServlet() {
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
		String deptID = request.getParameter("deptID");
		// 空文字判定
		if (deptID == null || deptID.isEmpty()) {
			response.sendRedirect("DepartmentManageServlet?delete=false");
			return;
		}
		boolean rc = DepartmentDeleteLogic.deleteDepartment(deptID);
		response.sendRedirect("DepartmentManageServlet?delete=" + rc);
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
