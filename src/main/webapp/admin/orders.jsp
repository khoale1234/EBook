<%@page import="com.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookOrderImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Orders</title>
<%@include file="allCSS.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
		<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<h3 class="text-center p-2">hello Admin</h3>
	<table class="table table-striped">
  <thead class="table-dark">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Address</th>
      <th scope="col">Phone No</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Payment method</th>
    </tr>
  </thead>
  <tbody>
  <%
  	BookOrderImp bookOrderImp= new BookOrderImp(DBconnect.getConnection());
  	List<Book_Order> list= bookOrderImp.getAllOrder();
  	for(Book_Order b: list){
  %>
    <tr>
      <th scope="row"><%=b.getOrderid() %></th>
      <td><%=b.getUserName() %></td>
      <td><%=b.getEmail() %></td>
      <td><%=b.getFullAddress() %></td>
      <td><%=b.getPhone_no() %></td>
      <td><%=b.getBookName() %></td>
  		<td><%=b.getAuthor()%></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getPaymentMethod() %></td>
      
    </tr>
    <%} %>
  </tbody>
</table>
<footer style="margin-top:310px">
	<%@include file="footer.jsp"%>
</footer>
</body>
</html>