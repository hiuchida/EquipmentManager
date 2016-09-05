package ateam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.BihinAddLogic;
import ateam.model.Bihin;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class BihinAddServlet
 */
@WebServlet("/BihinAddServlet")
public class BihinAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BihinAddServlet() {
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
		String bihinName = request.getParameter("bihinName");
		String bihinKana = request.getParameter("bihinKana");
		// 空文字判定
		if (bihinID == null || bihinID.isEmpty() || bihinName == null || bihinName.isEmpty() || bihinKana == null
				|| bihinKana.isEmpty()) {
			response.sendRedirect("BihinManageServlet?add=false");
			return;
		}
		Bihin bihin = new Bihin();
		bihin.setBihinID(bihinID);
		bihin.setBihinName(bihinName);
		bihin.setBihinKana(bihinKana);
		bihin.setStatus(Bihin.AVAILABLE);
		boolean rc = BihinAddLogic.addBihin(bihin);
		response.sendRedirect("BihinManageServlet?add=" + rc);
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
