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

import com.revature.p1.services.CredentialsServices;
import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.CredentialsDAOImpl;

public class LoginServlet extends HttpServlet {
	
    public LoginServlet() {
        super();
    }

    private CredentialsServices credServices = new CredentialsServices();
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.getRequestDispatcher("login.html").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	
    	Credentials creds = new Credentials(request.getParameter("username"), request.getParameter("password"));
    	
    	User u = credServices.authenticateUser(creds);
    	
    	if(u != null) {
    		//response.getWriter().write(u.toString());
    		session.setAttribute("userid", u.getUserID());
    		session.setAttribute("usertype", u.getUserType());
    		session.setAttribute("firstname", u.getFirstName());
    		session.setAttribute("lastname", u.getLastName());
    		session.setAttribute("username", u.getUsername());
    		session.setAttribute("addressline1", u.getAddressLine1());
    		session.setAttribute("addressline2", u.getAddressLine2());
    		session.setAttribute("city", u.getCity());
    		session.setAttribute("state", u.getState());
    		session.setAttribute("zipcode", u.getZipCode());
    		session.setAttribute("email", u.getEmailAddress());
    		session.setAttribute("phone", u.getPhoneNumber());
    		session.setAttribute("managerid", u.getManagerID());
    		
    		String nextPage;
    		
    		if(u.getUserType() == 1) {
    			nextPage = "/managerhome.html";
    		} else if (u.getUserType() == 2) {
    			nextPage = "/employeehome.html";
    		} else {
    			nextPage = "/login.html";
    		}
    		
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
    		dispatcher.forward(request, response);
    	}
    	else {
    		//response.getWriter().write("invalid credentials, nerd");
    		session.setAttribute("problem", "invalid credentials");
    		response.sendRedirect("login");
    		//response.sendError(403, "invalid credentials");
    	}
    	
	}

}
