package controllers;

import userDAO.UserDao;
import userModel.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
		System.out.println("In the server code");
		 String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        User user = new User(username, email, password);
	        
	        try {
				if(userDao.registerUser(user)) {
					System.out.println("Registration successful");
					out.print("success");
			        
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("failure");
			}


	        
	        out.close();
	}
}
