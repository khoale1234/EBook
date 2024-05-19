package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.User;
import com.DAO.UserImp;
import com.DB.DBconnect;
@WebServlet("/login")
@MultipartConfig
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		UserImp userimp=new UserImp(DBconnect.getConnection());
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		if("admin@gmail.com".equals(email)&& "adminpassword".equals(password)) {
			com.entity.User user=new com.entity.User();
			user.setName("Admin");
			session.setAttribute("userobj", user);
			response.sendRedirect("admin/home.jsp");
		}
		else {
			
			User user=userimp.UserLogin(email, password);
			if(user!=null) {
				session.setAttribute("userobj", user);
				response.sendRedirect("index.jsp");
			}
			else {
				session.setAttribute("failed","email or password invalid");
				response.sendRedirect("login.jsp");
			}
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
