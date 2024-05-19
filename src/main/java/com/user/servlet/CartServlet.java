package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookImp;
import com.DAO.CartImp;
import com.DB.DBconnect;
import com.entity.Book_dtls;
import com.entity.Cart;
@WebServlet("/cart")
/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int bid=Integer.parseInt(request.getParameter("bid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			BookImp bookImp=new BookImp(DBconnect.getConnection());
			Book_dtls b= bookImp.getBookbyId(bid);
			Cart cart= new Cart();
			cart.setBid(bid);
			cart.setUid(uid);
			cart.setBookName(b.getBookName());
			cart.setAuthor(b.getAuthor());
			cart.setPrice(Double.parseDouble(b.getPrice()));
			cart.setTotal_price(Double.parseDouble(b.getPrice()));
			CartImp cardImp=new CartImp(DBconnect.getConnection());
			boolean f= cardImp.CartAdd(cart);
			HttpSession session=request.getSession();
			if(f) {
				session.setAttribute("addCart", "Book Added to Cart");
				response.sendRedirect("all_new_books.jsp");
			}
			else {
				session.setAttribute("failed", "Something wrong on Server");
				response.sendRedirect("all_new_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
