<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Environment Setup</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="css/envstyle.css" rel="stylesheet">

<script type="text/javascript">
	function envSetup() {
		alert("Form Submitted");
	}
</script>
</head>
<body>
	<h3>Welcome to Environment Setup</h3>
	<div id="sel">
		<div id="sel1">
			<form action="envSetup" method="post" onSubmit="envSetup()">
				<div class="form-group">
					<label>Select Environment : </label> <select name="environment"
						class="form-control">
						<option value="DEV">Development</option>
						<option value="SIT">SIT</option>
						<option value="UAT">UAT</option>
						<option value="PROD">Production</option>
					</select>
				</div>
				<div class="form-group">
					<label>URL : </label> <input type="text" name="url"
						class="form-control" />
				</div>
				<div class="form-group">
					<label>Accessibility: </label> 
					<input type="checkbox" class="form-check-input" id="exampleCheck1" name="accessibility"> 
						<label class="form-check-label" for="exampleCheck1">Yes</label>
					<label class="form-check-label" for="exampleCheck1">No</label>
				</div>
				<div>
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-danger">Cancel</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>