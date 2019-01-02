package com.prog32758;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RunHeuristic
 */
public class RunHeuristic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RunHeuristic() {
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
		
		String path = getServletContext().getRealPath("/");
		System.out.println(path);
		// Returning the results to the browser
		out.print(Heuristic.runGame(runTimes, startX, startY, path));
	}

}
