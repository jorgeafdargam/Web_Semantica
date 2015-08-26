<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; UTF8">
		<title>Busca Semântica</title>
		<script>
			function EnviaForm(sujeito) {
				console.log("entrei no enviaForm "+sujeito +" value: " + sujeito.value +" id: " + sujeito.id);
				document.getElementById("sujeito").value = sujeito.id;
				document.getElementById("f1").submit();
			}
		</script>
		
		<script>
			function EnviaForm1(predicado) {
				console.log("entrei no enviaForm "+predicado +" value: " + predicado.value +" id: " + predicado.id);
				document.getElementById("predicado").value = predicado.id;
				document.getElementById("f2").submit();
			}
		</script>
		
		<script>
			function EnviaForm2(objeto) {
				console.log("entrei no enviaForm "+objeto +" value: " + objeto.value +" id: " + objeto.id);
				document.getElementById("objeto").value = objeto.id;
				document.getElementById("f3").submit();
			}
		</script>
		<link rel="stylesheet"	href="estilo.css">
	</head>
	<body>
		<h1>Resultado da Busca</h1>
		<br>
		 <table border="1">
 			<tr>
  				<th width="450">Sujeito</th>
  				<th width="450">Predicado</th>
  				<th width="450">Objeto</th>
 			</tr> 
 		<c:forEach var="tripla" items="${lista}">
			  <tr>
  				<td><span class="span2" onclick="EnviaForm(this)" id="${tripla.sujeito}"><c:out value="${tripla.sujeito}"></c:out></span></td>
  				<td><span class="span2" onclick="EnviaForm1(this)" id="${tripla.predicado}"><c:out value="${tripla.predicado}"></c:out></span></td>
  				<td><span class="span2" onclick="EnviaForm2(this)" id='${tripla.objeto}'><c:out value="${tripla.objeto}"></c:out></span></td>
 			</tr> 	
 		</c:forEach>
	 </table>
	<form method="post" action="busca" Id="f1">
	<input type="hidden" name="sujeito" id="sujeito">
	<input type="hidden" name="predicado" value="">
	<input type="hidden" name="objeto" value="">
	<input type="hidden" name="uri" value="">
	</form>
	
	<form method="post" action="busca" Id="f2">
	<input type="hidden" name="predicado" id="predicado">
	<input type="hidden" name="sujeito" value="">
	<input type="hidden" name="objeto" value="">
	<input type="hidden" name="uri" value="">
	</form>
	
	<form method="post" action="busca" Id="f3">
	<input type="hidden" name="objeto" id="objeto">
	<input type="hidden" name="sujeito" value="">
	<input type="hidden" name="predicado" value="">
	<input type="hidden" name="uri" value="">
	</form>
	</body>
</html>