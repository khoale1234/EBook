<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<div class=container-fluid style="height:20px; background-color:#303f9f;"><br>
<div class="bg-light">
	<div class="row">
		<div class="col-md-3">
			<h3><i class="fa-solid fa-book"></i> Ebook</h3>
		</div>
		<div class="col-md-3 offset-md-6">
		<c:if test="${ not empty userobj }">
			<div class="mr-auto">
				<a  class="btn btn-success"><i class="fas fa-user"></i> ${userobj.name }</a> 
			 	<a data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Log out</a>
			</div>
			 
		</c:if>
		<c:if test="${ empty userobj }">
			<div class="mr-auto">
				 <a href="../login.jsp" class="btn btn-success"><i class="fa-solid fa-right-to-bracket"></i> Login</a> 
				 <a href="../register.jsp" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Sign in</a>
			</div>
		</c:if>	
		</div>
	</div>
	<!-- modal log out -->
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel"></h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	       	<div class="text-center">
	       		 <h4>Do you want logout</h4>
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <a href="../logout" type="button" class="btn btn-primary">Logout</a>
	       	</div>
	      </div>
	      </div>
	      <div class="modal-footer">
	        
	    </div>
	  </div>
	</div>
		<!--  -->
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
						aria-current="page" href="../admin/home.jsp">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>