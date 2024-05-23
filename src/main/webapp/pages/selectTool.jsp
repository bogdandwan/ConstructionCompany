<%@page import="model.Masina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Masina> masine = (List<Masina>) request.getAttribute("masine");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Select tool</title>
<style>
body {
	background-image:
		url(https://www.yuradiostanice.com/slike/blog/velike/35/visoke_zgade.jpg);
}
</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-dark bg-dark">
			<div class="container-fluid">
				<div class="col-md-6 offset-md-3">
					<h1
						style="font-family: Times; letter-spacing: 10px; color: #00CCFF;">Polaris</h1>
				</div>
				<div>
					<a href="<%=request.getContextPath()%>/radnik?action=nazad"
						style="margin-right: 20px"><button type="button"
							class="btn btn-secondary">Back</button></a>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<div class="container">
			<div class="row" style="margin-top: 150px">
				<div class="col-md-4 offset-md-4">
					<form action="<%=request.getContextPath()%>/radnik" method="post">
						<div class="form-group">
							<label for="exampleInputName"></label> <select required name="masinaId"
								class="form-select">
								
								<%if (masine != null)
							for (Masina pom : masine) {%>
							<option value="<%= pom.getId()%>"><%= pom.getNaziv()%></option>
							<%}%>
							</select>
						</div>
						<br>
						<div style="text-align: center;">
							<button type="submit" name="action" class="btn btn-success"
								value="dodajNajam">Dodaj</button>
						</div>
					</form>
					<br>
					<div style="background: yellow">${msg }</div>
				</div>
			</div>
		</div>
	</main>

</body>
</html>