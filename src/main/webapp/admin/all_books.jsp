<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookImp"%>
<%@page import="com.entity.Book_dtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All books</title>
<%@include file="allCSS.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
		<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<h3 class="text-center p-2">hello Admin</h3>
					<c:if test="${not empty sucMsg }">
						<h5 class="text-center text-success">${sucMsg}</h5>
						<c:remove var="sucMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty failMsg }">
						<h5 class="text-center text-danger">${failMsg}</h5>
						<c:remove var="failMsg" scope="session"/>
					</c:if>
	<table class="table table-striped">
  <thead class="table-dark">
    <tr>
    	<th scope="col" >ID</th>
      <th scope="col">Image</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author Name</th>
      <th scope="col">Price</th>
      <th scope="col">Book Categories</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<%
  	BookImp bookimg= new BookImp(DBconnect.getConnection());
  	List<Book_dtls> list= bookimg.getAllBook();
  	for(Book_dtls b:list){
  	%>
  	<tr>
      <td><%=b.getBookID()%></td>
      <td><img alt="<%=b.getPhotoName()%>" src="../all_components/book/<%=b.getPhotoName() %>" style="width: 60px;height: 80px;"></td>
      <td><%=b.getBookName()%></td>
      <td><%=b.getAuthor()%></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getBookCategory()%></td>
      <td><%=b.getStatus() %></td>
      <td>
      	<a href="edit_books.jsp?id=<%=b.getBookID()%>" class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i>Edit</a>
      	<a href="../bookd?id=<%=b.getBookID() %>" class="btn btn-sm btn-danger" ><i class="fa-solid fa-trash"></i>Delete</a>
      </td>
    </tr>
    <%
    }
  	%>
  </tbody>
</table>
</body>
</html>