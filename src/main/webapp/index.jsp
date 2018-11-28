<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>OnlineShopping</title>
<link href="resources/css/custom.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<form class="well form-horizontal" action="saveUser" method="post"
			id="contact_form">
			<fieldset>
				<!-- Form Name -->
				<legend>
					<center>
						<h2>
							<b>Registration Form</b>
						</h2>
					</center>
				</legend>
				<br>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-sm-4 control-label">Name</label>
					<div class="col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="gu_name"
								placeholder="Name" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">E-mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="gu_email"
								placeholder="E-mail Address" class="form-control" type="text">
						</div>
					</div>
				</div>



				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Contact No.</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="gu_mobile" placeholder="Mobile" class="form-control"
								type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-4 control-label">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="gu_password"
								placeholder="Password" class="form-control" type="password">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group product_card">
					<label class="col-md-4 control-label">Confirm Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								name="gu_confirm_password" placeholder="Confirm Password"
								class="form-control" type="password">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="gu_usertype" class="col-md-4 control-label">Select User</label>
					<div class="col-md-4 inputGroupContainer">
						<select class="form-control" id="gu_usertype" name="gu_usertype">
							<option>Choose...</option>
							<option value="customer">Customer</option>
							<option value="retailer">Retailer</option>
							<option value="admin">Admin</option>
						</select>
					</div>
				</div>
				<!-- Select Basic -->

				<!-- <!-- Success message 
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.
				</div>-->

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<br>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<button type="submit" class="btn btn-primary">
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp SUBMIT <span
								class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	<div>
		<p>
			Already a user?&nbsp;<a href="redirectLogin">Click Here</a>
		</p>
		<p>
			Reroute to test<a href="redirectTest">Test</a>
		</p>
	</div>

</body>
</html>