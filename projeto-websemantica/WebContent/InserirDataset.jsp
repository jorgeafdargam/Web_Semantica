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
					Format formato = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy ' - ' H:mm:ss z");
					String data_hora = formato.format(agora);
				%>
				<%=data_hora%>
				</p>
			</div>
			<div class="corpo">
			<div class="col_2">
				<div class="col_2111">
<form method="post" action="ImportaDataset" >

<p class="align_center">CONFIGURA��ES DO DATASET</p><br/>
<label>Especifique o caminho onde est� o arquivo dataset</label><br/>
<input type="text"  name="inputPath" value="/home/dell/Documentos/" size ="40"> <br/>
<label>Selecione o arquivo dataset no caminho acima</label><br/>
<input type="file"  name="inpuFile" accept=".nt">
<br/><br/>
<p class="align_center">CONFIGURA��ES DO BD VIRTUOSO</p><br/>
<label>Especifique a porta utilizada pelo BD Virtuoso: </label>
<input type="text"  name="inputPorta" value="1111" size ="10"> <br/>
<label>Especifique o usu�rio de acesso ao BD Virtuoso: </label>
<input type="text"  name="inputUser" value="dba" size ="10"> <br/>
<label>Especifique a senha de acesso ao BD Virtuoso: </label>
<input type="password"  name="inputPassword" value="dba" size ="10"> <br/>
<label>Especifique o nome do grafo a ser inserido no BD Virtuoso: </label>
<input type="text"  name="inputGrafo" value="geonames" size ="20"> <br/>
<br/>
<p class="align_center"><input type="submit" value="INSERIR GRAFO"></p>
<br/>
<hr>
</form>
<form action="Busca.jsp">
<br/>
<label>Se j� houver grafo inserido no BD Virtuoso, clique no bot�o abaixo para realizar a pesquisa. </label>
<br/>
<p class="align_center"><input type="submit" value="PESQUISAR" /></p>
</form>
</div>
			</div>

			<div class="col_2">
				<div class="col_211">
				<p>Search-Semantic Web � um sistema open source de busca de informa��es organizadas em ontologia utilizada na web sem�ntica em arquivo dataset n-tripla (*.nt). Armazena as informa��es em um banco de dados n�o-relacional (NoSQL) Virtuoso. O framework Java Jena � utilizado para tratamento dos dados RDF. A exibi��o dos grafos resultantes � realizada no framework Arbor.js.</p><br/>
					<p class="align_center">AJUDA</p>
					<br/>
					<p class="align_center">CONFIGURA��ES DO DATASET</p>
					<p>- Indique o caminho do seu arquivo dataset onde ser� realizada a busca. Exemplo em ambiente Linux: /home/jorge/Documentos/</p>
					<p>- Indique o nome do seu arquivo dataset. Exemplo: geonames_links.nt</p>
					<br/>
					<p class="align_center">CONFIGURA��ES DO BD VIRTUOSO</p>
					<p>- Clique <a href="http://localhost:8890/" target="_blank">aqui</a> para verificar se seu BD Virtuoso est� inicializado.</p>
					<p>- Indique a porta utilizada pelo BD Virtuoso. A porta padr�o � 1111.</p>
					<p>- Indique o nome de usu�rio para fazer acesso ao BD Virtuoso.</p>
					<p>- Indique a senha para fazer acesso ao BD Virtuoso.</p>
					<p>- Indique o nome do grafo no BD Virtuoso. No Conductor o caminho para visualizar o grafo inserido � Linked Data / Graphs.</p>
				</div>
			</div>
			</div>
		</div>
<jsp:include page="Busca_footer.inc" />