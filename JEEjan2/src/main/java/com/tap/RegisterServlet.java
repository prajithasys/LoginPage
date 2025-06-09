package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.daoimpl.EmployeeDAOImpl;
import com.tap.models.Employee;
import com.tap.dao.EmployeeDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        
        Employee e = new Employee(name,email,password,phone,address);
        
        EmployeeDAO employeeDAOImpl = new EmployeeDAOImpl();
        
 
		employeeDAOImpl.addEmployee(e);
        
        
        PrintWriter out = resp.getWriter();
        out.println("Hi, "+name+" Registration Successful");
        
        RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, resp);
		
	}

}
