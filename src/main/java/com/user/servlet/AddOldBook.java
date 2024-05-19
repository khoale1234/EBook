package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookImp;
import com.DB.DBconnect;
import com.entity.Book_dtls;
@WebServlet("/add_old_book")
@MultipartConfig
public class AddOldBook extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userEmail=request.getParameter("user");
			String bookName=request.getParameter("bname");
			String author=request.getParameter("Aname");
			String price=request.getParameter("bprice");
			Part part=request.getPart("bookimg");
			String fileName=part.getSubmittedFileName();
			Book_dtls b= new Book_dtls(bookName, author, price, "Old Book", "Active", fileName,userEmail);
			BookImp bookImp= new BookImp(DBconnect.getConnection());
			boolean f=bookImp.AddBook(b);
			HttpSession session = request.getSession();
			if(f) {
				String path=getServletContext().getRealPath("")+"all_components//book";
				java.io.File file = new java.io.File(path);
				part.write(path+java.io.File.separator+fileName);
				session.setAttribute("successMsg", "Book Add Successfully");
				response.sendRedirect("sell_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong on Server");
				response.sendRedirect("sell_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}