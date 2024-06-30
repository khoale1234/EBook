<div class=container-fluid style="height:20px; background-color:#303f9f;"><br>
<div class="container-fluid p-3 bg-light">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
	<div class="row">
		<div class="col-md-3">
			<h3><i class="fa-solid fa-book"></i> Ebook</h3>
		</div>
		<div class="col-md-6">
			<div class=col-md-6>
				<form action="search.jsp" class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Type book'name or author to search"
						aria-label="Search" name="search">
					<button class="btn btn-primary" type="submit" >Search</button>
				</form>
			</div>
		</div>
		<c:if test="${not empty userobj }">
			<div class="col-md-3">
			<div class=mr-auto>
				<a href="checkout.jsp"><i class="fas fa-cart-plus fa-2x text-primary"></i></a>
				 <a href="login.jsp" class="btn btn-success mb-3"><i class="fas fa-user"></i> ${userobj.name }</a> 
				 <a href="logout" class="btn btn-primary mb-3"><i class="fa-solid fa-plus"></i> Log out</a>
				 
			</div>
		</div>
		
		</c:if>
		<c:if test="${ empty userobj }">
			<div class="col-md-3">
			<div class=mr-auto>
				 <a href="login.jsp" class="btn btn-success"><i class="fa-solid fa-right-to-bracket"></i> Login</a> 
				 <a href="register.jsp" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Sign in</a>
			</div>
		</div>
		
		</c:if>
		
	</div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item active"><a class="nav-link active" href="all-recent-books.jsp"><i class="fa-solid fa-book-open-reader"></i> Recent Book</a></li>
					<li class="nav-item active"><a class="nav-link active" href="all_new_books.jsp"><i class="fa-solid fa-book-open"></i></i> New Book</a></li>
					<li class="nav-item active"><a class="nav-link active" href="all_old_books.jsp"><i class="fa-solid fa-bookmark"></i> Old Book</a></li>
				</ul>
				<form class="d-flex">
					<a href="setting.jsp" class="btn btn-light my-2 my-sm-0 p-2" type="submit" style="border-radius:15px "><i class="fa-solid fa-gear"></i> Setting</a> 
					<a href="helpline.jsp" class="btn btn-light my-2 my-sm-0 p-2" type="submit" style="border-radius:15px "><i class="fa-brands fa-rocketchat"></i> Contact us</a> 
				</form>
			</div>
		</div>
	</nav>