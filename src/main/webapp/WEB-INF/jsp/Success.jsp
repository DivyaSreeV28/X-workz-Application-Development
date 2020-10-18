<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link href="css/welcomestyle.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-black">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#" >X-Workz</a>
    </li>
  </ul>
</nav>
<div>
	<h2>${status}</h2><br>
	
	<h5>${projectName}</h5>
	<h5>${managerName}</h5>
	<h5>${teamEmailId}</h5>
	<h5>${developedDate}</h5>
	<h5>${version}</h5>
	<h5>${lastRelease}</h5>
	<h5>${nextRelease}</h5>
	<h5>${deCommissined}</h5>
	
</div>
<div>
		<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
			<div class="container text-center">
				<small>@ 2020 Copyright &copy; xworkz.com</small>
			</div>
		</footer>
	</div>
</body>
</html>