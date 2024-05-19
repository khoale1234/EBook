package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookImp;
import com.DB.DBconnect;
@WebServlet("/delete_old_books")
@MultipartConfig
/**
 * Servlet implementation class DeleteOldBook
 */
public class DeleteOldBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOldBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email=request.getParameter("email");
			int bid=Integer.parseInt(request.getParameter("bid"));
			BookImp bookImp= new BookImp(DBconnect.getConnection());
			boolean f=bookImp.oldBookDelete(email, "Old Book",bid);
			HttpSession session= request.getSession();
			if(f) {
				session.setAttribute("successMsg","Old book delete successfully");
				response.sendRedirect("old_books.jsp");
			}
			else {
				session.setAttribute("failedMsg","Something wrong");
				response.sendRedirect("old_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
