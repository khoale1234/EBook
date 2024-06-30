<%@ page import="com.entity.User" %>
<%@ page import="com.entity.Book_dtls" %>
<%@ page import="java.util.List" %>
<%@ page import="com.DB.DBconnect" %>
<%@ page import="com.DAO.BookImp" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%@ include file="all_components/allCSS.jsp" %>
    <style type="text/css">
        .crd-ho:hover {
            background-color: #C6BEBE;
        }
    </style>
</head>

<body style="background-color:#D9D3D3">
    <% User us = (User) session.getAttribute("userobj"); %>
    <%@ include file="all_components/navbar.jsp" %>
    <div class="container-fluid back-img">
        <h1 class="text-center text-dark p-5">
            <i class="fa-solid fa-book"></i> Ebook management system
        </h1>
    </div>
    <div>
        <div class="container">
            <h3 class="text-center">Recent Book</h3>
            <div class="row">
                <%
                    BookImp bookImp2 = new BookImp(DBconnect.getConnection());
                    List<Book_dtls> list2 = bookImp2.getRecentBook();
                    for (Book_dtls b : list2) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="all_components/book/<%= b.getPhotoName() %>" style="width:120px;height:170px" class="img-thumblin">
                            <p><%= b.getBookName() %></p>
                            <p><%= b.getAuthor() %></p>
                            <% if (b.getBookCategory().equals("Old Book")) { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center p-1">
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-6 ml-5">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-6 ml-2">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } else { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center">
                                <% if (us == null) { %>
                                <a href="login.jsp" class="btn bnt-sm btn-danger col-md-4 ml-2">Add Cart</a>
                                <% } else { %>
                                <a href="cart?bid=<%= b.getBookID() %>&uid=<%= us.getId() %>" class="btn bnt-sm btn-danger col-md-4 ml-2">Add Cart</a>
                                <% } %>
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-4 ml-1">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-4 ml-1">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    <!-- end recent book -->
    <div class="text-center">
        <a href="all-recent-books.jsp" class="btn btn-danger btn-sm text-while mt-5">View all</a>
    </div>
    <hr class="mt-1">
    <div>
        <div class="container">
            <h3 class="text-center">New Book</h3>
            <div class="row">
                <%
                    BookImp bookImp = new BookImp(DBconnect.getConnection());
                    List<Book_dtls> list = bookImp.getNewBook();
                    for (Book_dtls b : list) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="all_components/book/<%= b.getPhotoName() %>" style="width:120px;height:170px" class="img-thumblin">
                            <p><%= b.getBookName() %></p>
                            <p><%= b.getAuthor() %></p>
                            <% if (b.getBookCategory().equals("Old Book")) { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center p-1">
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-6 ml-5">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-6 ml-2">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } else { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center">
                                <a href="" class="btn bnt-sm btn-danger col-md-4 ml-2">Add Cart</a>
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-4 ml-1">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-4 ml-1">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    <!-- end new book -->
    <div class="text-center">
        <a href="all-recent-books.jsp" class="btn btn-danger btn-sm text-while mt-5">View all</a>
    </div>
    <hr class="mt-1">
    <div>
        <div class="container">
            <h3 class="text-center">Old Book</h3>
            <div class="row">
                <%
                    BookImp bookImp3 = new BookImp(DBconnect.getConnection());
                    List<Book_dtls> list3 = bookImp3.getOldBook();
                    for (Book_dtls b : list3) {
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="all_components/book/<%= b.getPhotoName() %>" style="width:120px;height:170px" class="img-thumblin">
                            <p><%= b.getBookName() %></p>
                            <p><%= b.getAuthor() %></p>
                            <% if (b.getBookCategory().equals("Old Book")) { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center p-1">
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-6 ml-5">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-6 ml-2">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } else { %>
                            <p>Categories: <%= b.getBookCategory() %></p>
                            <div class="row text-center">
                                <a href="" class="btn bnt-sm btn-danger col-md-4 ml-2">Add Cart</a>
                                <a href="book_detail.jsp?bid=<%= b.getBookID() %>" class="btn btn-sm btn-success col-md-4 ml-1">View Details</a>
                                <a href="" class="btn btn-sm btn-danger col-md-4 ml-1">
                                    <i class="fa-solid fa-dollar-sign"></i><%= b.getPrice() %>
                                </a>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    <!-- end old book -->
    <div class="text-center">
        <a href="all-recent-books.jsp" class="btn btn-danger btn-sm text-while mt-5">View all</a>
    </div>
    <hr class="mt-1">
</body>
</html>
