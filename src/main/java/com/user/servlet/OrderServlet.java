package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookOrderImp;
import com.DAO.CartImp;
import com.DB.DBconnect;
import com.entity.Book_Order;
import com.entity.Cart;
@WebServlet("/order")
/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String City=request.getParameter("city");
		String state=request.getParameter("state");
		String paymentMethod=request.getParameter("paymentmethod");
		String fullAdd=address+","+City+","+state;
		CartImp cartImp= new CartImp(DBconnect.getConnection());
		List<Cart> list= cartImp.getBookByUser(id);
		if(list.isEmpty()) {
			session.setAttribute("failedMsg", "Add Item");
			response.sendRedirect("checkout.jsp");
		}
		else {
			BookOrderImp bookOrderImp= new BookOrderImp(DBconnect.getConnection());
			Book_Order o= null;
			ArrayList<Book_Order> orderList= new ArrayList<Book_Order>();
			Random rd= new Random();
			for(Cart c: list) {
				o=new Book_Order();
				o.setOrderid("BOOK-ORDER-00"+rd.nextInt(1000));
				o.setUserName(name);
				o.setEmail(email);
				o.setPhone_no(phone);
				o.setFullAddress(fullAdd);
				o.setBookName(c.getBookName());
				o.setAuthor(c.getAuthor());
				o.setPrice(c.getPrice()+"");
				o.setPaymentMethod(paymentMethod);
				orderList.add(o);
				
			}
			if(paymentMethod.equals("noselect")) {
				session.setAttribute("failedMsg", "please choose your payment method");
				response.sendRedirect("checkout.jsp");
			}
			else {
				boolean f=bookOrderImp.saveOrder(orderList);
				if(f) {
					response.sendRedirect("order_success.jsp");
				}
				else {
					session.setAttribute("failedMsg", "your order failed");
					response.sendRedirect("checkout.jsp");
				}
			}
			
		}
	}

}
