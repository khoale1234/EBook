package com.admin.servlet;

import java.io.IOException;
import java.nio.file.Paths;

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
		    // Get parameters from the request
		    String bookName = request.getParameter("bname");
		    String author = request.getParameter("Aname");
		    String price = request.getParameter("bprice");
		    String categories = request.getParameter("btype");
		    String status = request.getParameter("bstatus");
		    Part part = request.getPart("bookimg");
		    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // Ensure only file name

		    // Debug: Print out all parameters
		    System.out.println("Book Name: " + bookName);
		    System.out.println("Author: " + author);
		    System.out.println("Price: " + price);
		    System.out.println("Categories: " + categories);
		    System.out.println("Status: " + status);
		    System.out.println("File Name: " + fileName);

		    // Create a Book_dtls object
		    Book_dtls b = new Book_dtls(bookName, author, price, categories, status, fileName, "admin");

		    // Create an instance of BookImp
		    BookImp bookImp = new BookImp(DBconnect.getConnection());

		    // Add the book to the database
		    boolean f = bookImp.AddBook(b);

		    // Get the session
		    HttpSession session = request.getSession();

		    // Check if the book was added successfully
		    if (f) {
		        // Construct the path where the file will be saved
		        String path = getServletContext().getRealPath("") + "all_components" + java.io.File.separator + "book";
		        
		        // Debug: Print out the path
		        System.out.println("File Path: " + path);

		        // Create the directory if it does not exist
		        java.io.File fileDir = new java.io.File(path);
		        if (!fileDir.exists()) {
		            fileDir.mkdirs();
		        }

		        // Write the file to the constructed path
		        part.write(path + java.io.File.separator + fileName);

		        // Debug: Confirm file write
		        System.out.println("File written to: " + path + java.io.File.separator + fileName);

		        // Set success message and redirect
		        session.setAttribute("successMsg", "Book Add Successfully");
		        response.sendRedirect("admin/book_add.jsp");
		    } else {
		        // Set failure message and redirect
		        session.setAttribute("failedMsg", "Something Wrong on Server");
		        response.sendRedirect("admin/book_add.jsp");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    HttpSession session = request.getSession();
		    session.setAttribute("failedMsg", "Exception: " + e.getMessage());
		    response.sendRedirect("admin/book_add.jsp");
		}


	}

}
