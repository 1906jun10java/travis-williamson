package com.revature.p1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.p1.services.CredentialsServices;
import com.revature.p1.beans.*;

public class SessionServlet extends HttpServlet {
	
    public SessionServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("userid") != null) {
			try {
				int userid = Integer.parseInt(session.getAttribute("userid").toString());
				int usertype = Integer.parseInt(session.getAttribute("usertype").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String username = session.getAttribute("username").toString();
				String addressline1 = session.getAttribute("addressline1").toString();
				String addressline2 = session.getAttribute("addressline2").toString();
				String city = session.getAttribute("city").toString();
				String state = session.getAttribute("state").toString();
				String zipcode = session.getAttribute("zipcode").toString();
				String email = session.getAttribute("email").toString();
				String phone = session.getAttribute("phone").toString();
				int managerid = Integer.parseInt(session.getAttribute("managerid").toString());
				
				User u = new User(userid, usertype, firstname, lastname, username, addressline1, addressline2,
						city, state, zipcode, email, phone, managerid);
				
				response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
