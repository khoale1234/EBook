<%@page import="com.entity.Book_dtls"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.BookImp"%>
<%@page import="com.DAO.BookDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Search Book</title>
<%@include file="all_components/allCSS.jsp"%>
<style type="text/css">
.crd-ho:hover{
	background-color:#C6BEBE;
}
#toast{
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index:1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}
#toast.display{
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;	
}
@keyframes fadeIn{form{ bottom:0;
	opacity: 0;
}
}
to{
	bottom: 30px;
	opacity: 1;
}
@keyframes fadeOut{form{ bottom:30px;
	opacity: 1;
}
to{
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>
	<%
	User u= (User)session.getAttribute("userobj");
	%>
	<c:if test="${not empty addCart}">
	<div id="toast">${addCart }</div>
	<script type="text/javascript">
		showToast();
		function showToast(content)
		{
			$('#toast').addClass("display");
			$('#toast').html(content);
			setTimeout(() => {
				$("#toast").removeClass	("display");
			}, 2000);
		}
	</script>
</c:if>

	<%@include file="all_components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			String search=request.getParameter("search");
			BookImp bookImp2=new BookImp(DBconnect.getConnection());
			List<Book_dtls> list2=bookImp2.getBookSearch(search);
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