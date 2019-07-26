package com.revature.p1.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.revature.p1.services.*;
import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;


public class ManagerPersonalPendingRequestsServlet extends HttpServlet {
	
	private ManagerRequestServices managerRequestServices;
	private ObjectMapper om;
	
    public ManagerPersonalPendingRequestsServlet() {
        super();
        managerRequestServices = new ManagerRequestServices();
        om = new ObjectMapper();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		
		response.getWriter().write(om.writeValueAsString(managerRequestServices.viewPendingRequests(userid)));
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
