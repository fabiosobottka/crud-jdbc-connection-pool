<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		<h1 style="margin-top: 55px;">Veiculos cadastrados</h1>

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
			<table border="2" style="border-radius: 5px; width: 100%; margin: 10px auto;">
				<tr>
					<th style="padding: 5px 10px; text-align: center;">PLACA</th>
					<th style="padding: 5px 10px; text-align: center;">MODELO</th>
					<th style="padding: 5px 10px; text-align: center;">ANO</th>
					<th style="padding: 5px 10px; text-align: center;">MOTOR</th>

				</tr>
				<c:forEach items="${listaVeiculos}" var="veiculo">
					<tr>
						<td style="padding: 5px 10px; text-align: center;">${veiculo.placa}</td>
						<td style="padding: 5px 10px; text-align: center;">${veiculo.modelo}</td>
						<td style="padding: 5px 10px; text-align: center;">${veiculo.ano}</td>
						<td style="padding: 5px 10px; text-align: center;">
							<c:set var="motor">
								<fmt:formatNumber type="number" minFractionDigits="1" maxFractionDigits="1" value="${veiculo.motor}" />
							</c:set>
							${fn:replace(motor, ",", ".")}
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>


</body>
</html>