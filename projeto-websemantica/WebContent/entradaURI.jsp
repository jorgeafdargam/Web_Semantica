<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>    
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7;IE=EmulateIE9" />
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<meta content='initial-scale=1.0' name='viewport' />
		<title>Busca URI</title>
		<meta name="keywords" content=""/>
		<meta name="description" content=""/>
		<link rel="stylesheet"	href="estilo.css">
	<body>
		<div id="centro">
			<div id="principal">
				<img src="IMAGEM/img-inicio.png" alt="" class="imagem"/>
				<div class="secundario secundario1">
					<div class="secundario2">
						<span class="span span1">Entre com os dados da busca:</span>
					</div>
					<br><br><br><br>
					<form action="busca">
						<table>
							<tr>
								<td width = "2%"><font size="3" face="arial">URI</font></td>
								<td><input type="text" required name="uri" value="" size ="70"></td>
								<td><input type="submit"  value="Buscar"></td>
								<td><input type="hidden" name="sujeito" value=""></td>
								<td><input type="hidden" name="predicado" value=""></td>
								<td><input type="hidden" name="objeto" value=""></td> 
							</tr>
							<tr>
								<td align="center" colspan="2">
									<br>
									<input type="submit"  class="btn btn1" value="BUSCAR">
									<input type="reset" class="btn btn1" value="LIMPAR">
									<input type="button" class="btn btn1" onClick="location.href=
									'http://localhost:8080/projeto-websemantica/entradaBusca.jsp'" value="VOLTAR">
								</td>
							</tr>
						</table>
					</form>
				</div>		
			</div>
		</div>  
	</body>
</html>