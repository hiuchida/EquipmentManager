package ateam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.BihinDeleteLogic;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class BihinDeleteServlet
 */
@WebServlet("/BihinDeleteServlet")
public class BihinDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BihinDeleteServlet() {
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
		String bihinID = request.getParameter("bihinID");
		// 空文字判定
		if (bihinID == null || bihinID.isEmpty()) {
			response.sendRedirect("BihinManageServlet?delete=false");
			return;
		}
		boolean rc = BihinDeleteLogic.deleteBihin(bihinID);
		response.sendRedirect("BihinManageServlet?delete=" + rc);
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
