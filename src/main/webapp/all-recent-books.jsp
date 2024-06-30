<%@page import="com.entity.User"%>
<%@page import="com.entity.Book_dtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookImp"%>
<%@page import="com.DAO.BookDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Admin: All Recent Book</title>
<%@include file="all_components/allCSS.jsp"%>
<style type="text/css">
.crd-ho:hover{
	background-color:#C6BEBE;
}
</style>
</head>
<body>
	<%@include file="all_components/navbar.jsp"%>
	<%
	User u= (User)session.getAttribute("userobj");
	%>
	<div class="container-fluid">
		<h3 class="text-center mt-2">Recent Book</h3>	
		<div class="row p-3">
			<%
			BookImp bookImp2=new BookImp(DBconnect.getConnection());
			List<Book_dtls> list2=bookImp2.getAllRecentBook();
			for(Book_dtls b:list2){%>
					<div class="col-md-3">
				<div class="card crd-ho mt-3">
					<div class="card-body text-center">
						<img alt="" src="all_components/book/<%=b.getPhotoName()%>" style="width:120px;height:170px" class="img-thumblin">
						<p><%=b.getBookName() %> </p>
						<p><%=b.getAuthor() %> </p>
						<%
						if(b.getBookCategory().equals("Old Book")){
						%>
						<p>Categories: <%=b.getBookCategory() %>
						<div class="row">
							<a href="book_detail.jsp?bid=<%=b.getBookID() %>" class="btn btn-sm btn-success col-md-6 ml-5 ">View Details</a>
							<a href="" class="btn btn-sm btn-danger col-md-6 ml-2 "><i class="fa-solid fa-dollar-sign"></i><%=b.getPrice() %></a>
						</div>
						<%
							}else{
						%>
							<p>Categories: <%=b.getBookCategory() %>
						<div class="row text-center">
							<%
							if(u==null){
							%>
								<a href="login.jsp" class="btn bnt-sm btn-danger col-md-4 ml-2 ">Add Cart</a>
							<%}else{%>
								<a href="cart?bid=<%=b.getBookID()%>&&uid=<%=u.getId() %>" class="btn bnt-sm btn-danger col-md-4 ml-2 ">Add Cart</a>
							<%} %>
							<a href="book_detail.jsp?bid=<%=b.getBookID() %>" class="btn btn-sm btn-success col-md-4 ml-1 ">View Details</a>
							<a href="" class="btn btn-sm btn-danger col-md-4 ml-1 "><i class="fa-solid fa-dollar-sign"></i><%=b.getPrice() %></a>
						</div>
						<%
						}%>
						
					</div>	
			</div>
		</div>
			<%}%>
		</div>
	</div>
</body>
</html>