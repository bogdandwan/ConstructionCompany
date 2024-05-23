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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.6.2/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<link href="<%= request.getContextPath()%>/css/style.css" rel="stylesheet">
<title>Polaris</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-dark bg-dark">
			<div class="container-fluid">
				<div class="col-md-6 offset-md-3">
					<h1 style="font-family:Times;letter-spacing:10px;color:#00CCFF;">Polaris</h1>
				</div>
			<section class="mb-4" style="margin-right:50px;margin-top:10px">
				<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
					style="background-color: #3b5998;" href="#!" role="button"><i
					class="fab fa-facebook-f"></i></a>

				<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
					style="background-color: #55acee;" href="#!" role="button"><i
					class="fab fa-twitter"></i></a>

				<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
					style="background-color: #dd4b39;" href="#!" role="button"><i
					class="fab fa-google"></i></a>

				<a data-mdb-ripple-init class="btn text-white btn-floating m-1"
					style="background-color: #ac2bac;" href="#!" role="button"><i
					class="fab fa-instagram"></i></a>
			</section>
			</div>
		</nav>
	</header>

	<main>
		<div class="container">
			<div class="row" style="text-align:center">
				<div class="col-md-3 offset-md-4" style="margin-top: 200px">
					<form action="login" method="post">
						<div class="form-group">
							<label for="exampleInputUsername" style="color:#fafa0f;font-size: 30px;font-weight: bold;">Ime</label> <input
								type="text" class="form-control" name="ime"
								id="exampleInputUsername" placeholder="Ime">
						</div>
						<br>
						<div class="form-group">
							<label for="exampleInputPassword1" style="color:#fafa0f;font-size: 30px;font-weight: bold;">Password</label> <input
								type="password" class="form-control" name="password"
								id="exampleInputPassword1" placeholder="Password">
						</div>
						<br>
						<br>
						<button type="submit" name="action" class="btn btn-secondary btn-lg" value="login">Uloguj se</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>