<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7;IE=EmulateIE9" />
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		
		<meta content='initial-scale=1.0' name='viewport' />
		<title>Busca Entrada</title>
		<meta name="keywords" content=""/>
		<meta name="description" content=""/>
		<link rel="stylesheet"	href="estilo.css">
	</head>
	<body>
		<div id="centro">
			<div id="principal">
				<img src="IMAGEM/img-inicio.png" alt="" class="imagem"/>
				
				<div class="secundario">
					<div class="secundario2">
						<span>Selecione aqui o seu tipo de busca sem&#226;ntica:</span>
					</div>
				</div>
				<div class="botao botaoSPO">
					<input type="button" class="btn btn1" onClick="location.href=
								'http://localhost:8080/projeto-websemantica/entradaSPO.jsp'" value="S/P/O"></input>
				</div>
				<div class="botao botaoURI">
					<input type="button" class="btn btn1" onClick="location.href=
								'http://localhost:8080/projeto-websemantica/entradaURI.jsp'" value="URI"></input>
				</div>
			</div>
		</div>  
	</body>
</html>