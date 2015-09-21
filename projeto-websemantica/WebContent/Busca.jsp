<jsp:include page="Busca_header.inc" />
<div class="corpo">
			<div class="col_11"> 
				<p>SEARCH-SEMANTIC WEB</p>
			</div>
			<div class="col_1"> 
				<p>
				<%@ page import="java.util.Date, java.text.*" %>
				<% 
					long hora = session.getCreationTime();
					Date agora = new Date(hora); 
					Format formato = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ' - ' hh:mm:ss");
					String data_hora = formato.format(agora);
				%>
				<%=data_hora%>
				</p>
			</div>
			<div class="corpo">
			<div class="col_2">
				<div class="col_2111">
<form method="post" action="LeituraController" >

<p class="align_center">CONFIGURA��ES DO DATASET</p><br/>
<label>Especifique o caminho onde est� o arquivo dataset</label><br/>
<input type="text"  name="inputPath" value="/home/dell/Documentos/" size ="40"> <br/>
<label>Selecione o arquivo dataset no caminho acima</label><br/>
<input type="file"  name="inpuFile" accept=".nt"><br/>

<br/><p class="align_center">CONFIGURA��ES DO ARQUIVO JSON DE SA�DA</p><br/>
<label>Especifique o caminho do arquivo json de sa�da</label><br/>
<input type="text"  name="inputPathOut" value="/opt/lampp/htdocs/arbor/demos/halfviz/library/" size ="40"> <br/>
<label>Especifique o nome do arquivo json de sa�da</label><br/>
<input type="text"  name="inpuFileOut" value="third-planet-from-altair2.json" size ="40"> <br/>
<label>Especifique a cor exibida pelo sujeito:</label><br/>
<input type="text"  name="inputColorSuj" value="green" size ="40"> <br/>
<label>Especifique a cor exibida pelo predicado:</label><br/>
<input type="text"  name="inputColorPred" value="red" size ="40"> <br/>
<label>Especifique a cor exibida pelo objeto:</label><br/>
<input type="text"  name="inputColorObj" value="grey" size ="40"> <br/><br/>

<p class="align_center">CONFIGURA��ES DO BD VIRTUOSO</p><br/>
<label>Especifique a porta utilizada pelo BD Virtuoso</label><br/>
<input type="text"  name="inputPorta" value="1111" size ="40"> <br/>
<label>Especifique o usu�rio de acesso ao BD Virtuoso </label><br/>
<input type="text"  name="inputUser" value="dba" size ="40"> <br/>
<label>Especifique a senha de acesso ao BD Virtuoso </label><br/>
<input type="password"  name="inputPassword" value="dba" size ="40"> <br/><br/>

<p class="align_center"><input type="submit" value="ENVIAR"></p>
</form>
</div>
			</div>

			<div class="col_2">
				<div class="col_211">
				<p>Search-Semantic Web � um sistema open source de busca de informa��es organizadas em ontologia utilizada na web sem�ntica em arquivo dataset n-tripla (*.nt). Armazena as informa��es em um banco de dados n�o-relacional (NoSQL) Virtuoso. O framework Java Jena � utilizado para tratamento dos dados RDF. A exibi��o dos grafos resultantes � realizada no framework Arbor.js.</p><br/>
					<p class="align_center">AJUDA</p><br/>
					<p class="align_center">CONFIGURA��ES DO DATASET</p>
					<p>- Indique o caminho do seu arquivo dataset onde ser� realizada a busca. Exemplo em ambiente Linux: /home/jorge/Documentos/</p>
					<p>- Indique o nome do seu arquivo dataset. Exemplo: geonames_links.nt</p><br/>
					<p class="align_center">CONFIGURA��ES DO ARQUIVO JSON DE SA�DA</p>
					<p>- Indique o caminho do seu arquivo json que ir� gerar o gr�fico. O arquivo dever� estar na pasta /arbor/demos/halfviz/library/ do framework Arbor.js. Exemplo em ambiente Linux: /var/www/html/arbor/demos/halfviz/library/</p>
					<p>- Indique o nome do seu arquivo json. Exemplo: texto.json</p>
					<p>- Indique as cores, em formato texto ou hexadecimal, do sujeito, predicado e objeto a ser exibidas no gr�fico. Exemplo: red ou #F50824</p>
					<p>- Clique <a href="http://html-color-codes.info/Codigos-de-Cores-HTML/" target="_blank">aqui</a> para acessar um aplicativo que fornece o c�digo hexadecimal das cores.</p>
					<p class="align_center">CONFIGURA��ES DO BD VIRTUOSO</p>
					<p>- Clique <a href="http://localhost:8890/" target="_blank">aqui</a> para verificar se seu BD Virtuoso est� inicializado.</p>
					<p>- Indique a porta utilizada pelo BD Virtuoso. A porta padr�o � 1111.</p>
					<p>- Indique o nome de usu�rio para fazer acesso ao BD Virtuoso.</p>
					<p>- Indique a senha para fazer acesso ao BD Virtuoso.</p>
				</div>
			</div>
			</div>
		</div>
<jsp:include page="Busca_footer.inc" />