package controllers;
import userDAO.UserDao;
import userModel.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao(); 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		User user = userDao.authenticateUser(userEmail, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("dashboardCustomer.jsp");
		}
		else {
			out.println("No login done");
		}
	}

}
