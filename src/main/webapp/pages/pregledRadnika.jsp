<%@page import="dto.WorkersTools"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<WorkersTools> workerTools = (List<WorkersTools>)request.getAttribute("workerTools");
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"rel="stylesheet">
<meta charset="UTF-8">
<title>Pregled</title>
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
			<div class="row" style="margin-top: 150px">
				<div class="col-md-6 offset-md-3">
					<table
						class="table table-bordered table-light">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Radnik</th>
								<th scope="col">Masina</th>
							</tr>
							</thead>
						<tbody>
						<%if (workerTools != null)
							for (WorkersTools pom : workerTools) {%>
							<tr>
								<td><%=pom.getImeRadnika()%></td>
								<td><%=pom.getNazivMasine()%></td>
							</tr>
							<%}%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>


</body>
</html>