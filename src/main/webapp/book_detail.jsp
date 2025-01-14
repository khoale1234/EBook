<%@page import="com.entity.User"%>
<%@page import="com.entity.Book_dtls"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Detail</title>
<%@include file="all_components/allCSS.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="all_components/navbar.jsp" %>
<%
		User u= (User)session.getAttribute("userobj");
	%>
<%
	int bid=Integer.parseInt(request.getParameter("bid"));
	BookImp bookImg=new BookImp(DBconnect.getConnection());
	Book_dtls b=bookImg.getBookbyId(bid);
%>
<div class="container">
	<div class="row">
		<div class="col-md-6 text-center p-5 border bg-white">
			<img alt="" src="all_components/book/<%=b.getPhotoName() %>" style="height: 190px;width: 150px"><br>
			<h4 class="mt-3">Book Name:<span class="text-success"> <%=b.getBookName() %></span></h4>
			<h4>Author Name:<span class="text-success"> <%=b.getAuthor() %></span></h4>
			<h4>Category:<span class="text-success"> <%=b.getBookCategory() %></span></h4>
		</div>
		<div class="col-md-6 text-center p-5 border bg-white">
			<h2><%=b.getBookName() %></h2>
			<%
			if("Old Book".equals(b.getBookCategory())){%>
				<h5 class="text-primary">Contact To Seller</h5>
				<h5 class="text-primary"><i class="far fa-envelope"></i> Email: <%=b.getEmail() %></h5>
			<%
			}
			%>
			<div class="row mt-2">
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-money-bill-wave fa-3x"></i><br>
						<p>Cash On Delivery
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-undo-alt fa-3x"></i><br>
						<p>Return Available
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-truck-moving fa-3x"></i>
						<p>Free Delivery
					</div>

			</div>
			<div class="mt-4">
				<%
				if("Old Book".equals(b.getBookCategory())){%>
					<a href="index.jsp" class="btn btn-sm btn-success col-md-4"><i class="fas fa-cart-plus"></i> Continue Shopping</a>
					<a href="" class="btn btn-sm btn-danger col-md-2"><i class="fa-solid fa-dollar-sign"></i> 5</a>
				<%
				}else{
					if(u!=null){
				%>
					<a href="cart?bid=<%= b.getBookID() %>&uid=<%= u.getId() %>" class="btn btn-sm btn-primary col-md-3"><i class="fas fa-cart-plus"></i> Add Cart</a>
					<a href="" class="btn btn-sm btn-danger col-md-2"><i class="fa-solid fa-dollar-sign"></i> 5</a>
					<%}else{ %>
						<a href="" class="btn btn-sm btn-danger col-md-2"><i class="fa-solid fa-dollar-sign"></i> 5</a>
					<%}%>
				<%}%>
			</div>
		</div>
	</div>
</div>
</body>
</html>