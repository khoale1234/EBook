package com.admin.servlet;

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
@WebServlet("/booka")
@MultipartConfig
/**
 * Servlet implementation class BookAdd
 */
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdd() {
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
			String author=request.getParameter("Aname");
			String price=request.getParameter("bprice");
			String categories=request.getParameter("btype");
			String status=request.getParameter("bstatus");
			Part part=request.getPart("bookimg");
			String fileName=part.getSubmittedFileName();
			Book_dtls b= new Book_dtls(bookName, author, price, categories, status, fileName,"admin");
			BookImp bookImp= new BookImp(DBconnect.getConnection());
			boolean f=bookImp.AddBook(b);
			HttpSession session = request.getSession();
			if(f) {
				String path=getServletContext().getRealPath("")+"all_components//book";
				java.io.File file = new java.io.File(path);
				part.write(path+java.io.File.separator+fileName);
				session.setAttribute("successMsg", "Book Add Successfully");
				response.sendRedirect("admin/book_add.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong on Server");
				response.sendRedirect("admin/book_add.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
