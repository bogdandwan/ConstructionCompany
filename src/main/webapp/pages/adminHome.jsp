<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%
   		response.setHeader("Pragma", "no-cache");
   		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);   
   %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<link href="<%= request.getContextPath()%>/css/adminHome.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Home page</title>
<style>
	body{
		background-image: url(https://png.pngtree.com/thumb_back/fh260/background/20200731/pngtree-blue-carbon-background-with-sport-style-and-golden-light-image_371487.jpg);
	}
</style>
</head>
<body style="height:100;width: 100; ">
	<header>
		<nav class="navbar navbar-dark bg-dark">
			<div class="container-fluid">
				<div class="col-md-6 offset-md-3">
					<h1 style="font-family:Times;letter-spacing:10px;color:#00CCFF;">Polaris</h1>
				</div>
				<div>
					<a href="<%= request.getContextPath()%>/login?action=logout" style="margin-right:20px"><button type="button" class="btn btn-secondary">Izloguj se</button></a>
				</div>
			</div>
		</nav>
	</header>

	<main>

		<div class="container">
			<div class="row" style="margin-top: 80px">
				<div class="col-md-6 offset-md-6">
					<h1 style="color: #0fdff2">
						<span>Welcome</span> ${sessionScope.user.ime }
					</h1>
				</div>
			</div>
			<div class="row" style="margin-top: 150px">
				<div class="col-md-3 offset-md-2">
					<div style="margin-top: 50px">
						<a href="<%=request.getContextPath()%>/admin?action=pregled"><button
								type="button"  class="btn btn-warning btn-lg">Pregled</button></a>
					</div>
					<div style="margin-top: 120px">
						<a href="<%=request.getContextPath()%>/admin?action=dodaj"><button
								type="button" class="btn btn-warning btn-lg">Dodaj radnika</button></a>
					</div>
				</div>
				<div class="col-md-3 offset-md-2">
					<img alt="" style="border-radius: 10px;"
						src="https://w7.pngwing.com/pngs/306/70/png-transparent-computer-icons-management-admin-silhouette-black-and-white-neck-thumbnail.png">
				</div>
			</div>
		</div>
	</main>

</body>
</html>

