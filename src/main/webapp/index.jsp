<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>OnlineShopping</title>

	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

	<script type="text/javascript">
		function Validate() 
		{
			var mobile = document.contact_form.gu_mobile.value;
			var password = document.contact_form.gu_password.value;
			var confirmPassword = document.contact_form.gu_confirm_password.value;

			if (mobile.length < 10 || mobile.length > 10) {
				alert("Mobile number is not valid! Please Enter 10 Digit Mobile No.");
				return false;
			}
			if (password != confirmPassword) {
				alert("Passwords don't match! Try again.");
				return false;
			}
			return true;
		}
		</script>
	</head>
	<body>
		<nav class="navbar navbar-dark bg-primary" style="background-color: #23476d !important;">
			<a class="navbar-brand" href="admin">Shopp-E</a>
		</nav>
		<div class="col-sm-8 offset-sm-2" style="margin-top: 5%;">
			<form action="saveUser" method="post"
			name="contact_form" id="contact_form" onsubmit="return Validate()">

			<div class="form-row">
				<!-- Name-->	
				<div class="form-group col-md-6">
					<label for="gu_name">Name</label>
					<input name="gu_name"
					placeholder="Name" class="form-control" type="text" required>
				</div>

				<!-- Email -->
				<div class="form-group col-md-6">
					<label class="col-md-4 control-label">E-mail</label>
					<input name="gu_email"
					placeholder="E-mail Address" class="form-control"
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
					title="Must contain @ . " type="text" required>
				</div>
			</div>		

			<div class="form-row">
				<!-- Contact -->
				<div class="form-group col-md-6">
					<label class="control-label">Contact No.</label>
					<input
					name="gu_mobile" placeholder="Mobile" class="form-control"
					pattern="[6789][0-9]{9}"
					title="Must start with 6,7,8 or 9 and Must be 10 digit number"
					type="tel" minlength="10" maxlength="10" required>
				</div>
				<div class="form-group col-md-6">
				</div>
					<input type="hidden" id="gu_usertype" name="gu_usertype"> 
					<!-- <select class="form-control" id="gu_usertype" name="gu_usertype">
						<option>Choose...</option>
						<option value="customer">Customer</option>
						<option value="admin">Admin</option>
					</select> -->
			</div>

			<div class="form-row">
				<!-- Password -->
				<div class="form-group col-md-6">
					<label class="control-label">Password</label>
					<input name="gu_password"
					placeholder="Password" class="form-control"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Must contain at least one uppercase letter, one digit, one special character and lowercase letter and must be of 8 or more characters"
					type="password" required>
				</div>
				<!-- Confirm Password -->
				<div class="form-group col-md-6">
					<label class="control-label">Confirm Password</label>
					<input
					name="gu_confirm_password" placeholder="Confirm Password"
					class="form-control" type="password" required>
				</div>

			</div>
			<div class="form-group">
				<div class="form-check" style="padding-left: 0 !important">
					<p>Already a user?&nbsp;<a href="redirectLogin">Login</a></p>

				</div>
			</div>
			<button type="submit" class="btn btn-primary" style="background-color: #23476d !important;">
				SUBMIT <span class="glyphicon glyphicon-send"></span>
			</button>
		</form>
	</div>
</body>
</html>