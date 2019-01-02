package com.prog32758;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunNonIntelligent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunNonIntelligent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting all the values submitted from the index.html form
		int runTimes = Integer.parseInt(request.getParameter("runTimes"));
		int startX = Integer.parseInt(request.getParameter("startX"));
		int startY = Integer.parseInt(request.getParameter("startY"));
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// Returning the results to the browser
		out.print(NonIntelligent.runGame(runTimes, startX, startY));
	}

}
