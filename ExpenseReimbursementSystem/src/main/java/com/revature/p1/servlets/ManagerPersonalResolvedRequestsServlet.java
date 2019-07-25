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


public class ManagerPersonalResolvedRequestsServlet extends HttpServlet {
	
	private ManagerRequestServices managerRequestServices;
	private ObjectMapper om;
	
    public ManagerPersonalResolvedRequestsServlet() {
        super();
        managerRequestServices = new ManagerRequestServices();
        om = new ObjectMapper();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().write(om.writeValueAsString(managerRequestServices.viewPendingRequests(1007)));
		
		
		HttpSession session = request.getSession();
		
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		
		response.getWriter().write(om.writeValueAsString(managerRequestServices.viewResolvedRequests(userid)));
		
		
		/*
		HttpSession session = request.getSession();
		
		if (session != null && session.getAttribute("userid") != null) {
			try {
				int userid = Integer.parseInt(session.getAttribute("userid").toString());
				
				response.getWriter().write(om.writeValueAsString(managerRequestServices.viewPendingRequests(userid)));
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
		*/
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		//HttpSession session = request.getSession();
		
		/*
		String nextPage = "/viewmanagedemployeerequests.html";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		*/
	}

}
