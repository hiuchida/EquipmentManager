package ateam.controller.admin;

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
 * Servlet implementation class BihinReturnServlet
 */
@WebServlet("/BihinReturnServlet")
public class BihinReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BihinReturnServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (!LoginUtil.isLogined(request, response)) {
			return;
		}
		User user = (User) session.getAttribute("user");
		String bihinID = request.getParameter("bihinID");
		// 空文字判定
		if (bihinID == null || bihinID.isEmpty()) {
			response.sendRedirect("BihinManageServlet?return=false");
			return;
		}
		boolean rc = ReturnBihinLogic.returnBihinByAdmin(bihinID, user.getUserID());
		response.sendRedirect("BihinManageServlet?return=" + rc);
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
