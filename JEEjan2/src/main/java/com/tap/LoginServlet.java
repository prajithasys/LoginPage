package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.dao.EmployeeDAO;
import com.tap.daoimpl.EmployeeDAOImpl;
import com.tap.models.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Simulating a database check
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee e = employeeDAO.getEmployeeByName(name);
		
	
		PrintWriter out = resp.getWriter();
		
		if(e != null && password.equals(e.getPassword()) && name.equals(e.getName())) {
			// Login successful
			out.println("Welcome, " + name + "! You have successfully logged in.");
		} else {
			// Login failed
			out.println("Invalid username or password. Please try again.");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		
		
	}

}
