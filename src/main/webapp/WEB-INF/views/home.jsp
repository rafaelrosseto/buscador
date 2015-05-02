<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt_BR">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscador</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default text-right">
		<div class="container-fluid">
			<a class="glyphicon glyphicon-thumbs-up" href="<c:url value="/loginfacebook"/>">Login</a>
		</div>
	</nav>
	<div class="jumbotron vertical-center">
		<div class="container">
			<div class="center-block">
				<h1 class="text-center">Buscador</h1>
				<form action="resultado" method="post" class="form-inline text-center" role="form">
					<div class="form-group">
						<input type="text" name="nome" class="form-control input-lg" placeholder="Ex: iPhone 5s" />
						<input type="submit" class="btn btn-lg btn-success glyphicon glyphicon-search"/>
					</div>
				</form>
			</div>
		</div>
		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</div>
</body>
</html>