<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page errorPage="error.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
</head>
<script type="text/javascript">
	history.pushState(null, null, location.href);
	window.onpopstate = function() {
		history.go(1);
	};
</script>
<body>
	<nav class="navbar navbar-dark bg-primary"
		style="background-color: #23476d !important;"> <a
		class="navbar-brand" href="#">Shopp-E</a> </nav>

	<div class="row" style="margin-top: 10%;">
		<div class="container col-sm-4 offset-sm-4">
			<form action="userLogin" method="post">
				<!-- Email -->
				<div class="form-group">
					<label for="inputEmail">Email</label> <input type="email"
						class="form-control" id="inputEmail" name="gu_email"
						placeholder="Email">
				</div>
				<!-- Password -->
				<div class="form-group">
					<label for="inputPassword">Password</label> <input type="password"
						class="form-control" id="inputPassword" name="gu_password"
						placeholder="Password" required>
				</div>
				<div class="form-group">
					<div class="form-check" style="padding-left: 0 !important">
						<p>
							Not registered with Shopp-E?&nbsp;<a href="index.jsp">Register</a>
						</p>

					</div>
				</div>
				<div class="col-sm-4 offset-sm-4" style="margin-top: 20px">
					<button type="submit" class="btn btn-primary btn-block"
						value="login">Login</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>