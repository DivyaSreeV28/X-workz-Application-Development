<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding App Info</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$('#exampleModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var modal = $(this)
		modal.find('.modal-title').text('New message to ' + recipient)
		modal.find('.modal-body input').val(recipient)
	})
</script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">X-workz</a>
	</nav>
	<br>

	<form id="saveModal" action="sendModal" method="post"></form>
	<form id="saveAppInfo" action="sendAppInfo" method="post"></form>

	<div class="card text-center"
		style="width: 50rem; margin-top: 20px; margin-left: 200px;">
		<div class="card-header">AddAppInfo</div>
		<div class="card-body">

			<div class="form-row">

				<div class="form-group col-md-6">
					<label>Project Name</label> <input type="text" class="form-control"
						form="saveAppInfo" name="projectName" required>
				</div>

				<div class="form-group col-md-6">
					<label>Project Team Manager</label> <input type="text" class="form-control"
						form="saveAppInfo" name="teamManagerName">
				</div>

				<div class="form-group col-md-6">
					<label>Project Team Contact Email</label> <input type="email"
						class="form-control" form="saveAppInfo" name="teamContactEmail"
						required>
				</div>
			
				<div class="form-group col-md-6">
					<label>Project Version</label> <input type="text" class="form-control"
						form="saveAppInfo" name="version">
				</div>
				
				<div class="form-group col-md-6">
					<label>Project Developed Date</label> <input type="date"
						class="form-control" form="saveAppInfo" name="developedDate">
				</div>

				<div class="form-group col-md-6">
					<label>De-Commissioned</label> <select class="form-control"
						form="saveAppInfo" name="deCommissined" required>
						<option value="1">YES</option>
						<option value="0">NO</option>
					</select>
				</div>

				<div class="form-group col-md-6">
					<label>Project Last Release</label> <input type="date" class="form-control"
						form="saveAppInfo" name="lastRelease">
				</div>

				<div class="form-group col-md-6">
					<label>Project Next Release</label> <input type="date" class="form-control"
						form="saveAppInfo" name="nextRelease">
				</div>

			</div>
			<br>
			<div class="form-group col-md-6">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#exampleModal" data-whatever="@mdo"
					style="margin-right: 350px;">EnvSetup</button>
				<br>
			</div>
			<div class="form-group col-md-6">
				<table border="1">
					<thead>
						<tr>
							<th>#</th>
							<th>ENVIRONMENT</th>
							<th>URL</th>
							<th>ACCESSIBILITY</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="i" value="1" />
						<c:forEach items="${modalList}" var="lists">
							<tr>
								<td>${i}</td>
								<td>${lists.environment}</td>
								<td>${lists.url}</td>
								<td>${lists.accessibility}</td>
							</tr>
							<c:set var="i" value="${i+1}" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" name="save" value="Add"
			form="saveAppInfo" />
	</div>
	<br>
	<br>
	<div class="card-footer text-muted">Copy right x-workz</div>
</body>
<!-- Modal HTML -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Environment
					Setup</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Environment:</label> <select class="form-control"
						form="saveModal" class="col-form-label" name="environment" required>
						<option value="dev">Development</option>
						<option value="uat">Uat</option>
						<option value="sit">Sit</option>
						<option value="prod">Production</option>
						<option value="others">Others</option>
					</select>
				</div>
				<div class="form-group">
					<label for="recipient-name" class="col-form-label">URL:</label> <input
						type="text" class="form-control" form="saveModal" name="url" />
				</div>
				<div class="form-group">
					<label>Accessibility</label> <select class="form-control"
						form="saveModal" class="col-form-label" name="accessibility"
						required>
						<option value="1">YES</option>
						<option value="0">NO</option>
					</select>
				</div>
			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

				<input type="submit" class="btn btn-primary" value="Save"
					form="saveModal" />
			</div>
		</div>
	</div>
</div>
</html>