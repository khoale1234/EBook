<%@page import="com.entity.Book_dtls"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Edit books</title>
<%@include file="allCSS.jsp"%>
</head>
<body style="background-color: #f0f2f2">
	<%@include file="navbar.jsp"%>
		<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<h3 class="text-center mt-2">Book Edit</h3>
					<%
					String id=request.getParameter("id");
					int idb=Integer.parseInt(id);
					BookImp bookimp=new BookImp(DBconnect.getConnection());
					Book_dtls b=bookimp.getBookbyId(idb);
					
					%>
					<div class="card-body">
						<form action="../bookeditt" method="post" enctype="multipart/form-data">
							<input type="hidden" name="bid" value="<%=b.getBookID()%>">
							<div class="form-group">
								<label for="exampleInputBookName">Book Name:</label><input
									type="text" class="form-control" id="exampleInputBookName"
									placeholder="Enter Book Name" required name="bname" value="<%=b.getBookName()%>">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputAuthorName">Author Name:</label><input
									type="text" class="form-control" id="exampleInputAuthorName"
									placeholder="Enter Author Name" required name="Aname" value="<%=b.getAuthor()%>">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPrice">Price:</label><input type="text"
									class="form-control" id="exampleInputPrice"
									aria-describeby="emailHelp" placeholder="Enter Price" required
									name="bprice" value="<%=b.getPrice()%>">
							</div>
							<div class="form-group mt-4 mb-4">
								<label for="inputState">Book Status:</label><select
									id="inputState" name="bstatus" class="form-control">
									<%if ("Active".equals(b.getStatus())){ %>
									<option value="Active">Active
									<option value="Inactive">Inactive
									<%
									}else{
									%>
									<option value="Inactive">Inactive
									<option value="Active">Active
									<%} %>
								</select>
							</div>
							<div class="d-flex justify-content-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>