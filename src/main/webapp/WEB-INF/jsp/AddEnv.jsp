<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<title>Environment Setup</title>
</head>
<body>

	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal" data-whatever="@mdo">Open modal
		for @mdo</button>
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
					<form id="saveModal" action="sendModal" method="post"></form>
					<div class="form-group">
						<label>Environment:</label> <select class="form-control"
							form="saveModal" class="col-form-label" name="environment"
							required>
							<option value="dev">Development</option>
							<option value="uat">Uat</option>
							<option value="sit">Sit</option>
							<option value="prod">Production</option>
							<option value="others">Others</option>
						</select>
					</div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">URL: </label>
						<textarea class="form-control" form="saveModal" name="url"></textarea>
					</div>
					<div class="form-group">
						<label>Accessibility: </label> <select class="form-control"
							form="saveModal" class="col-form-label" name="accessibility"
							required>
							<option value="1">YES</option>
							<option value="0">NO</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<input type="button" class="btn btn-primary" name="save"
						value="Save" form="saveModal" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>