<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enterprise-Project</title>
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
	<h1>Successfully saved application information into db</h1><br>
	
	<h3>Project Name: ${projectName}</h3>
	<h3>Project Team Manager Name: ${managerName}</h3>
	<h3>Project Team EmailId: ${teamEmailId}</h3>
	<h3>Project Developed Date: ${developedDate}</h3>
	<h3>Project Version: ${version}</h3>
	<h3>Project Last Released Date: ${lastRelease}</h3>
	<h3>Project Next Release Date: ${nextRelease}</h3>
	<h3>Is Project De-Commissined: ${deCommissined}</h3>
	
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