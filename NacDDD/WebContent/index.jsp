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
		<h1 style="margin-top: 55px;">Cadastro de Veiculos</h1>

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
		<div class="secao-principal">
			
			<form class="cadastro" action="cadastro-veiculo" method="post">
				<input type="hidden" name="option" value="incluirVeiculo"> 
					<label for="iModelo">Modelo:</label> 
					<input placeholder="Corsa" class="form-controler" type="text" id="iModelo" name="iModelo" /><br> 
				<div class="form-field">
					<label for="iPlaca">Placa:</label> 
					<input placeholder="ECL 4323" class="form-controler" type="text" id="iPlaca" name="iPlaca" /><br> 
				</div>
				<div class="form-field">
					<label for="iAno">Ano:</label> 
					<input placeholder="2014" class="form-controler" type="text" id="iAno" name="iAno" /><br>
				</div>
				<div class="form-field">
					<label for="iMotor">Motor:</label>
					<input placeholder="2.0" class="form-controler" type="text" id="iMotor" name="iMotor" /><br> 
				</div>
				<div class="form-field">
					<input class="submit-personalizado btn btn-default" type="submit" name="incluir" value="CADASTRAR VEICULO">
				</div>
			</form>
		
		</div>

	</div>
	
</body>
</html>