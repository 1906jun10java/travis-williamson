package com.revature.p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.revature.p1.services.*;
import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;


public class EmployeeSubmitRequestServlet extends HttpServlet {
	

    public EmployeeSubmitRequestServlet() {
        super();
    }

    private EmployeeRequestServices employeeRequestServices = new EmployeeRequestServices();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/employeesubmitrequest.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int currentUserID = Integer.parseInt(session.getAttribute("userid").toString());
		
		Double amountRequested = Double.parseDouble(request.getParameter("amountrequested"));
		
		String briefDescription = request.getParameter("briefdescription");
		
		employeeRequestServices.submitRequest(currentUserID, amountRequested, 0, briefDescription);
		
		String nextPage = "/employeepersonalpendingrequests.html";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
