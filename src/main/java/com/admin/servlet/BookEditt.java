package com.admin.servlet;

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
import com.entity.Book_dtls;
@WebServlet("/bookeditt")
@MultipartConfig
/**
 * Servlet implementation class BookEditt
 */
public class BookEditt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEditt() {
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
			String bookName=request.getParameter("bname");
			int id = Integer.parseInt(request.getParameter("bid"));
			String author=request.getParameter("Aname");
			String price=request.getParameter("bprice");
			String status=request.getParameter("bstatus");
			Book_dtls b = new Book_dtls();
			b.setBookID(id);
			b.setBookName(bookName);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			BookImp bookImp = new BookImp(DBconnect.getConnection());
			boolean f= bookImp.UpdateEditBook(b);
			HttpSession session= request.getSession();
			if(f) {
				session.setAttribute("sucMsg", "Book Edit Successfully");
				response.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("failMsg", "Something wrong on Server");
				response.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
