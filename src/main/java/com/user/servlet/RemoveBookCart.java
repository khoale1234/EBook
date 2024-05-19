package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartImp;
import com.DB.DBconnect;
@WebServlet("/remove_book")
/**
 * Servlet implementation class RemoveBookCart
 */
public class RemoveBookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBookCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid=Integer.parseInt(request.getParameter("bid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		CartImp cartImp= new CartImp(DBconnect.getConnection());
		boolean f= cartImp.deleteBook(bid,uid,cid);
		HttpSession session= request.getSession();
		if(f) {
			session.setAttribute("successMsg", "Book removed from Cart");
			response.sendRedirect("checkout.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something wrong on Server");
			response.sendRedirect("checkout.jsp");
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
