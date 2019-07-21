package com.revature.p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    	
    	if(u == null) {
    		response.getWriter().write("invalid credentials, nerd");
    	}
    	else {
    		response.getWriter().write(u.toString());
    	}
    	
	}

}
