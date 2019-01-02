package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChooseMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseMethod() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Getting the method type from the index.html form
		String methodType = request.getParameter("methodType");
		
		// Getting inputed values from the main page
		int runTimes = Integer.parseInt(request.getParameter("runTimes"));
		int startX = Integer.parseInt(request.getParameter("startX"));
		int startY = Integer.parseInt(request.getParameter("startY"));
		
		// Checking if the non-intelligent way was selected
		if (methodType.equals("nonIntelligent")) {
			// Making sure that the program runs at least once
			if(runTimes > 0) {
				// Creating the request dispatcher for the non-intelligent method.
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("RunNonIntelligent");
				rd.forward(request, response);
			// If the number is less than 1, an exception is thrown
			} else {
				throw new ServletException();
			}
		// Checking if the heuristic method was selected
		} else if (methodType.equals("heuristic")) {
			// Making sure there is at least one run time selected before doing the sendRedirect
			if(runTimes > 0) {
				response.sendRedirect("RunHeuristic?runTimes=" + runTimes + "&startX=" + startX + "&startY=" + startY);
			// Throwing an exception if the run times is less than 1.
			} else {
				throw new ServletException();
			}
		}
	}
}
