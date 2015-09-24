<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCH-SEMANTIC WEB</title>
<link rel="stylesheet" type="text/css" href="css/style-eco.css">
<link rel="stylesheet" href="css/estilo.css">
<script>
	function EnviaForm(sujeito) {
		console.log("entrei no enviaForm " + sujeito + " value: "
				+ sujeito.value + " id: " + sujeito.id);
		document.getElementById("sujeito").value = sujeito.id;
		document.getElementById("f1").submit();
	}
</script>

<script>
	function EnviaForm1(predicado) {
		console.log("entrei no enviaForm " + predicado + " value: "
				+ predicado.value + " id: " + predicado.id);
		document.getElementById("predicado").value = predicado.id;
		document.getElementById("f2").submit();
	}
</script>

<script>
	function EnviaForm2(objeto) {
		console.log("entrei no enviaForm " + objeto + " value: " + objeto.value
				+ " id: " + objeto.id);
		document.getElementById("objeto").value = objeto.id;
		document.getElementById("f3").submit();
	}
</script>

</head>
<body>

	<div class="conteudo">
		<!-- div de conteiner -->

		<div class="header">
			<div class="cabeca">
				<img src="IMAGEM/searchsemanticweb.jpg" alt="universo"
					class="img_cabeca">
			</div>
		</div>
		<div class="corpo">
			<h1>Resultado da Busca</h1>
			<br>
			<table class="tabela">
				<tr>
					<th width="450">Sujeito</th>
					<th width="450">Predicado</th>
					<th width="450">Objeto</th>
				</tr>
				<c:forEach var="tripla" items="${lista}">
					<tr>
						<td><span class="span2" onclick="EnviaForm(this)"
							id="${tripla.sujeito}"><c:out value="${tripla.sujeito}"></c:out></span></td>
						<td><span class="span2" onclick="EnviaForm1(this)"
							id="${tripla.predicado}"><c:out
									value="${tripla.predicado}"></c:out></span></td>
						<td><span class="span2" onclick="EnviaForm2(this)"
							id='${tripla.objeto}'><c:out value="${tripla.objeto}"></c:out></span></td>
					</tr>
				</c:forEach>
			</table>
			<div class="botao botaoSPO">
				<p class="align_center">
				<a><input type="button" class="btn btn1"
					onClick="location.href='http://localhost:8080/projeto-websemantica/Busca.jsp'"
					value="Nova Busca"></input> </a>
				</p>
			</div>
			<form method="post" action="busca" Id="f1">
				<input type="hidden" name="sujeito" id="sujeito"> <input
					type="hidden" name="predicado" value=""> <input
					type="hidden" name="objeto" value=""> <input type="hidden"
					name="uri" value="">
			</form>

			<form method="post" action="busca" Id="f2">
				<input type="hidden" name="predicado" id="predicado"> <input
					type="hidden" name="sujeito" value=""> <input type="hidden"
					name="objeto" value=""> <input type="hidden" name="uri"
					value="">
			</form>

			<form method="post" action="busca" Id="f3">
				<input type="hidden" name="objeto" id="objeto"> 
				<input type="hidden" name="sujeito" value=""> 
				<input type="hidden" name="predicado" value=""> 
				<input type="hidden" name="uri" value="">
			</form>
		</div>
		<br />
		<jsp:include page="Busca_footer.inc" />