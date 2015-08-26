<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.HashSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7;IE=EmulateIE9" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta content='initial-scale=1.0' name='viewport' />
<title>Busca SPO</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<div id="centro">
		<div id="principal">
			<img src="IMAGEM/img-inicio.png" alt="" class="imagem" />

			<div class="secundario secundario1">
				<div class="secundario2">
					<span class="span span1">Entre com os dados da busca no dataset <%=request.getAttribute("arquivo") %> :</span>
				</div>
				<br> <br> <br> <br>
				<form action="busca">
					<p>Sujeito:</p>
					<select>
						<c:forEach var="sujeito" items="${requestScope.sujeito}">
							<option value="${sujeito}">${sujeito}</option>
						</c:forEach>
					</select> <br />
					<p>Predicado:</p>
					<select>
						<c:forEach var="predicado" items="${requestScope.predicado}">
							<option value="${predicado}">${predicado}</option>
						</c:forEach>
					</select> <br />
					<p>Objeto:</p>
					<select>
						<c:forEach var="objeto" items="${requestScope.objeto}">
							<option value="${objeto}">${objeto}</option>
						</c:forEach>
					</select> <br /> <br /> <input type="submit" class="btn btn1" value="BUSCAR" /> <input
						type="reset" class="btn btn1" value="LIMPAR" /> <input
						type="button" class="btn btn1"
						onClick="location.href='http://localhost:8080/projeto-websemantica/entradaBusca.jsp'"
						value="VOLTAR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>