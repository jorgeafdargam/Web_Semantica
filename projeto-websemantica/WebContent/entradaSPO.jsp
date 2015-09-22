<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.HashSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Busca SPO</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
	<div id="centro">
		<div id="principal">
			<img src="IMAGEM/img-inicio.png" alt="" class="imagem" />

			<div class="secundario secundario1">
				<div class="secundario2">
					<p class="align_center"><span class="span">Escolha abaixo as combinações de busca no dataset:</span></p>
					<p class="align_center"><span class="span"><%=request.getAttribute("arquivo") %></span></p>
					<p class="align_center"><span class="span">Existem até <%=request.getAttribute("contador") %> opções de buscas exclusivas em cada campo.</span></p>
				</div>
				<div class="formulario">
				<form action="busca">
					<br><p>Sujeito:</p>
					<select name="sujeito" id="sujeito" >
						<c:forEach var="sujeito" items="${requestScope.sujeito}">
							<option value="${sujeito}" >${sujeito}</option>
						</c:forEach>
					</select> <br />
					<p>Predicado:</p>
					<select name="predicado" id="predicado">
						<c:forEach var="predicado" items="${requestScope.predicado}">
							<option value="${predicado}">${predicado}</option>
						</c:forEach>
					</select> <br />
					<p>Objeto:</p>
					<select name="objeto" id="objeto">
						<c:forEach var="objeto" items="${requestScope.objeto}">
							<option value="${objeto}">${objeto}</option>
						</c:forEach>
					</select> 
					<input type="hidden" name="uri" value="">
					<br /> <br /> 
					<p class="align_center">
					<input type="submit" class="btn btn1" value="BUSCAR" /> <input
						type="reset" class="btn btn1" value="LIMPAR" /> <input
						type="button" class="btn btn1"
						onClick="location.href='http://localhost:8080/projeto-websemantica/Busca.jsp'"
						value="VOLTAR" />
					</p>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>