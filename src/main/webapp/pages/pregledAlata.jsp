<%@page import="model.Masina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%   List<Masina> tools = (List<Masina>)request.getAttribute("tools");   %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<title>Pregled alata</title>
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
					<a href="<%= request.getContextPath()%>/radnik?action=nazad" style="margin-right:20px"><button type="button" class="btn btn-secondary">Back</button></a>
				</div>
			</div>
		</nav>
	</header>
	
	<main>
		<div class="container">
			<div class="row" style="margin-top: 150px">
				<div class="col-md-6 offset-md-3">
					<table
						class="table table-bordered table-light">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Masina</th>
								<th scope="col"></th>
							</tr>
							</thead>
						<tbody>
						<% if(tools != null) for(Masina pom : tools){ %>
							<tr>
								<td><%= pom.getNaziv() %></td>
								<td><a href="<%= request.getContextPath()%>/radnik?action=odjavi&masinaId=<%=pom.getId() %>" style="margin-right:20px"><button type="button" class="btn btn-danger">Odjavi</button></a></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

</body>
</html>