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

<p class="align_center">CONFIGURAÇÕES DO DATASET</p><br/>
<label>Especifique o caminho onde está o arquivo dataset</label><br/>
<input type="text"  name="inputPath" value="/home/dell/Documentos/" size ="40"> <br/>
<label>Selecione o arquivo dataset no caminho acima</label><br/>
<input type="file"  name="inpuFile" accept=".nt">
<br/><br/>
<p class="align_center">CONFIGURAÇÕES DO BD VIRTUOSO</p><br/>
<label>Especifique a porta utilizada pelo BD Virtuoso: </label>
<input type="text"  name="inputPorta" value="1111" size ="10"> <br/>
<label>Especifique o usuário de acesso ao BD Virtuoso: </label>
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
<label>Se já houver grafo inserido no BD Virtuoso, clique no botão abaixo para realizar a pesquisa. </label>
<br/>
<p class="align_center"><input type="submit" value="PESQUISAR" /></p>
</form>
</div>
			</div>

			<div class="col_2">
				<div class="col_211">
				<p>Search-Semantic Web é um sistema open source de busca de informações organizadas em ontologia utilizada na web semântica em arquivo dataset n-tripla (*.nt). Armazena as informações em um banco de dados não-relacional (NoSQL) Virtuoso. O framework Java Jena é utilizado para tratamento dos dados RDF. A exibição dos grafos resultantes é realizada no framework Arbor.js.</p><br/>
					<p class="align_center">AJUDA</p>
					<br/>
					<p class="align_center">CONFIGURAÇÕES DO DATASET</p>
					<p>- Indique o caminho do seu arquivo dataset onde será realizada a busca. Exemplo em ambiente Linux: /home/jorge/Documentos/</p>
					<p>- Indique o nome do seu arquivo dataset. Exemplo: geonames_links.nt</p>
					<br/>
					<p class="align_center">CONFIGURAÇÕES DO BD VIRTUOSO</p>
					<p>- Clique <a href="http://localhost:8890/" target="_blank">aqui</a> para verificar se seu BD Virtuoso está inicializado.</p>
					<p>- Indique a porta utilizada pelo BD Virtuoso. A porta padrão é 1111.</p>
					<p>- Indique o nome de usuário para fazer acesso ao BD Virtuoso.</p>
					<p>- Indique a senha para fazer acesso ao BD Virtuoso.</p>
					<p>- Indique o nome do grafo no BD Virtuoso. No Conductor o caminho para visualizar o grafo inserido é Linked Data / Graphs.</p>
				</div>
			</div>
			</div>
		</div>
<jsp:include page="Busca_footer.inc" />