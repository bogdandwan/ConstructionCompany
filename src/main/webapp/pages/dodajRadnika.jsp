<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<meta charset="UTF-8">
<title>Dodavanje</title>
<style>
	body{
		background-image: url(https://png.pngtree.com/thumb_back/fh260/background/20200731/pngtree-blue-carbon-background-with-sport-style-and-golden-light-image_371487.jpg);
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
					<a href="<%= request.getContextPath()%>/admin?action=nazad" style="margin-right:20px"><button type="button" class="btn btn-secondary">Back</button></a>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<div class="container">
			<div class="row" style="margin-top:150px">
				<div class="col-md-4 offset-md-4">
					<form action="<%= request.getContextPath()%>/admin" method="post">
						<div class="form-group">
							<label for="exampleInputName"></label> <input type="text"
								name="ime" class="form-control" id="exampleInputName"
								placeholder="Ime i prezime" style="text-align:center">
						</div>
						<br>
						
						<div class="form-group">
							<label for="exampleInputPassword1"></label> <input
								type="password" name="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password" style="text-align:center">
						</div>
						<br>
						<div class="form-check">
							<input class="form-check-input" type="radio" 
								id="exampleRadios1" value="admin" name="userType" checked> <label
								class="form-check-label" for="exampleRadios1" style="color:yellow;">Admin</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio"
								id="exampleRadios2" name="userType" value="user"> <label
								class="form-check-label" for="exampleRadios2" style="color:yellow;">User</label>
						</div>
						<div style="text-align:center;">
							<button type="submit" name="action" class="btn btn-success"
								value="dodaj">Dodaj</button>
						</div>
					</form>
					<br>
					<div style="background:yellow">${msg }</div>
				</div>
			</div>
		</div>
	</main>

</body>
</html>