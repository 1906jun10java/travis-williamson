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


public class EmployeeUpdateInfoServlet extends HttpServlet {
	

    public EmployeeUpdateInfoServlet() {
        super();
    }

    private EmployeeUserServices employeeUserServices = new EmployeeUserServices();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/employeeupdatepersonalinfo.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int currentUserID = Integer.parseInt(session.getAttribute("userid").toString());
		
		String typedAddressLine1 = request.getParameter("addressline1");
		String typedAddressLine2 = request.getParameter("addressline2");
		String typedCity = request.getParameter("city");
		String typedState = request.getParameter("state");
		String typedZipCode = request.getParameter("zipcode");
		String typedEmail = request.getParameter("email");
		String typedPhone = request.getParameter("phone");
		
		employeeUserServices.updatePersonalInformation(typedAddressLine1, typedAddressLine2, typedCity, typedState,
				typedZipCode, typedEmail, typedPhone, currentUserID);
		
		session.setAttribute("addressline1", typedAddressLine1);
		session.setAttribute("addressline2", typedAddressLine2);
		session.setAttribute("city", typedCity);
		session.setAttribute("state", typedState);
		session.setAttribute("zipcode", typedZipCode);
		session.setAttribute("email", typedEmail);
		session.setAttribute("phone", typedPhone);
		
		String nextPage = "/employeeviewpersonalinfo.html";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}
