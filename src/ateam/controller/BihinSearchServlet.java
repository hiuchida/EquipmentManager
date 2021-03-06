package ateam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.BihinListLogic;
import ateam.logic.BihinSearchLogic;
import ateam.model.Bihin;
import ateam.util.LoginUtil;

/**
 * Servlet implementation class BihinSearchServlet
 */
@WebServlet("/BihinSearchServlet")
public class BihinSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BihinSearchServlet() {
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
		List<Bihin> list = null;
		String bihinKana = request.getParameter("search");
		String bihinName = bihinKana;
		String statusName = request.getParameter("status");
		int status = BihinSearchLogic.getStatusSearch(statusName);
		if (bihinKana == null || bihinKana.isEmpty()) {
			if (status == Bihin.OTHER) {
				list = BihinListLogic.getAllBihinList();
			} else {
				list = BihinSearchLogic.getBihinSearchList(status);
			}
		} else {
			/* 備品名の検索 */
			if (status == Bihin.OTHER) {
				list = BihinSearchLogic.getBihinSeachList(bihinKana, bihinName);
			} else {
				list = BihinSearchLogic.getBihinSearchList(bihinKana, bihinName, status);
			}
		}
		request.setAttribute("bihinList", list);
		request.setAttribute("bihinKana", bihinKana);
		request.setAttribute("statusName", statusName);
		request.getRequestDispatcher("/bihinList.jsp").forward(request, response);
	}

}
