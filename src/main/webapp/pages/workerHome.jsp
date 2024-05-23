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
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<title>Home page</title>
<style>
	body{
		background-image: url(https://www.yuradiostanice.com/slike/blog/velike/35/visoke_zgade.jpg);
	}
</style>
</head>
<body>

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
					<h1 style="color: #e0dfdc">
						<span>Welcome</span> ${sessionScope.user.ime }
					</h1>
				</div>
			</div>
			<div class="row" style="margin-top: 150px">
				<div class="col-md-3 offset-md-2">
					<div style="margin-top: 50px">
						<a href="<%=request.getContextPath()%>/radnik?action=najam"><button
								type="button"  class="btn btn-light btn-lg">Najam</button></a>
					</div>
					<div style="margin-top: 120px">
						<a href="<%=request.getContextPath()%>/radnik?action=pregled"><button
								type="button" class="btn btn-light btn-lg">Pregled</button></a>
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