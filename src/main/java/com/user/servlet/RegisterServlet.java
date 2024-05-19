package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserImp;
import com.DB.DBconnect;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
    public RegisterServlet() {
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
			String name=request.getParameter("fname");
			String email=request.getParameter("femail");
			String password=request.getParameter("fpassword");
			String phone_no=request.getParameter("fphone");
			String check=request.getParameter("fcheck");
//			System.out.println(name+" "+email+" "+password+" "+phone_no);
			User user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setPhone_no(phone_no);
			HttpSession session=request.getSession();
			if(check!=null) {
				UserImp userimp=new UserImp(DBconnect.getConnection());
				boolean f2=userimp.checkUser(email);
				if(f2) {
					boolean f=userimp.UserRegister(user);
					if(f) {
						session.setAttribute("successMsg", "Registration successfully");
						response.sendRedirect("register.jsp");
					}
					else {
						session.setAttribute("failedMsg", "Something wrong on server");
						response.sendRedirect("register.jsp");
					}
				}
				else {
					session.setAttribute("failedMsg", "User already exist, try another email");
					response.sendRedirect("register.jsp");
				}
			}
			else {
				session.setAttribute("failedMsg", "Please check agree Terms & Conditions");
				response.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
