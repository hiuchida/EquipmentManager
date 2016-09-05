package ateam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.DepartmentAddLogic;
import ateam.model.Department;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class DepartmentAddServlet
 */
@WebServlet("/DepartmentAddServlet")
public class DepartmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentAddServlet() {
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
		String deptName = request.getParameter("deptName");
		String deptKana = request.getParameter("deptKana");
		// 空文字判定
		if (deptID == null || deptID.isEmpty() || deptName == null || deptName.isEmpty() || deptKana == null
				|| deptKana.isEmpty()) {
			response.sendRedirect("DepartmentManageServlet?add=false");
			return;
		}
		Department dept = new Department();
		dept.setDeptID(deptID);
		dept.setDeptName(deptName);
		dept.setDeptKana(deptKana);
		boolean rc = DepartmentAddLogic.addDepartment(dept);
		response.sendRedirect("DepartmentManageServlet?add=" + rc);
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
