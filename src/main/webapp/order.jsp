<%@page import="com.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookOrderImp"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<%@include file="all_components/allCSS.jsp" %>
</head>
<body>
	<c:if test="${ empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
<%@include file="all_components/navbar.jsp" %>
<div class="container">
<h3 class="text-center text-primary">Your order</h3>
	<table class="table table-striped mt-5">
  <thead class="table-dark">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Name</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Payment type</th>
    </tr>
  </thead>
  <tbody>
  <%
  	User user=(User)session.getAttribute("userobj");
  	BookOrderImp bookOrderImp= new BookOrderImp(DBconnect.getConnection());
  	List<Book_Order> list= bookOrderImp.getBook(user.getEmail());
  	for(Book_Order o:list){
  %>
    <tr>
      <th scope="row"><%=o.getOrderid() %></th>
      <td><%=o.getUserName() %></td>
      <td><%=o.getBookName() %></td>
      <td><%=o.getAuthor() %></td>
      <td><%=o.getPrice() %></td>
      <td><%=o.getPaymentMethod() %></td>
    </tr>
    <%} %>
  </tbody>
</table>
</div>
</body>
</html>