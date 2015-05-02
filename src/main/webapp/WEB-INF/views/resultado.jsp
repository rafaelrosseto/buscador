<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<h1>Resultado:</h1>
		</div>
		<table>
			<tr>
				<th>Produto</th>
			</tr>
			<tr>
				<td>${produto.nome}</td>
			</tr>
		</table>
		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</div>
</body>
</html>