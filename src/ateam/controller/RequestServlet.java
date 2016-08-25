package ateam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String bihinName = request.getParameter("bihinName");
        System.out.println(bihinName);
        request.setAttribute("bihinName", bihinName);
        request.getRequestDispatcher("/request.jsp").forward(request, response);
        /*String bihinID = (String) request.getAttribute("BihinID");
        if (RequestLogic.requestBihin(bihinID)) {
            request.getRequestDispatcher("/requestSuccess.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/requestFail.jsp").forward(request, response);
        }*/
    }

}
