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


public class ManagerSubmitRequestServlet extends HttpServlet {
	

    public ManagerSubmitRequestServlet() {
        super();
    }

    private ManagerRequestServices managerRequestServices = new ManagerRequestServices();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/managersubmitrequest.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int currentUserID = Integer.parseInt(session.getAttribute("userid").toString());
		
		Double amountRequested = Double.parseDouble(request.getParameter("amountrequested"));
		
		String briefDescription = request.getParameter("briefdescription");
		
		managerRequestServices.submitRequest(currentUserID, amountRequested, 0, briefDescription);
		
		String nextPage = "/managerpersonalpendingrequests.html";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
