<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bulk upload</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">X-workz</a> <a class="nav-link"
			href="AddAppInfo.jsp">Add App Info</a>
	</nav>
	<form action="onbulkadd" method="post" enctype="multipart/form-data">
		<div class="form-row">


			<div class="form-group col-md-4">
				<label>Choose file to upload:</label> <input type="file" class="form-control"
					name="excelfile">
			</div>
			
		</div>
		<button type="submit" class="btn btn-success">SaveBulkAppInfo</button>
		<br>
	</form>
	<div>
		<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
			<div class="container text-center">
				<small>@ 2020 Copyright &copy; xworkz.com</small>
			</div>
		</footer>
	</div>
</body>
</html>