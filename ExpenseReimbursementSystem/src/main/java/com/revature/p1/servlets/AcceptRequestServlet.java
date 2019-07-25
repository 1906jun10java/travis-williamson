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


public class AcceptRequestServlet extends HttpServlet {
       
   
    public AcceptRequestServlet() {
        super();
    }
    
    private ManagerRequestServices managerRequestServices = new ManagerRequestServices();

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("/managerviewallpendingrequestsforemployees.html").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int requestID = Integer.parseInt(request.getParameter("acceptrequest"));
		
    	managerRequestServices.approveRequest(requestID);
    	
    	String nextPage = "/managerviewallpendingrequestsforemployees.html";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
