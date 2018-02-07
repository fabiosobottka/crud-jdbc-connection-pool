<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de veiculos</title>

<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="assets/js/jquery-ui.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="margin-top: 55px;">Exportar Veiculos</h1>

		<header>

			<div class="cabecalho row">
				<div class="col-lg-6">
					<nav class="menu-principal">
						<ul class="nav nav-pills margin-menu">
							<li role="presentation"><a href="index.jsp">Incluir</a></li>
							<li role="presentation"><a href="excluir.jsp">Excluir</a></li>
							<li role="presentation"><a href="alterar.jsp">Alterar</a></li>
							<li role="presentation"><a href="cadastro-veiculo">Listar</a></li>
							<li role="presentation"><a href="exportar.jsp">Exportar</a></li>
							<li role="presentation"><a href="http://www.fiap.com.br">Sair</a></li>
						</ul>
					</nav>
				</div>
			</div>
			
		</header>
		
			
			<form action="cadastro-veiculo" method="post">
				<input type="hidden" name="option" value="exportarVeiculos"> 
				<div class="form-field">
					<input class="submit-personalizado btn btn-default" type="submit" name="exportar" value="EXPORTAR VEICULOS DO ANO">
				</div>
			</form>
		

	</div>
</body>
</html>