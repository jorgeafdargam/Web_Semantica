package br.com.websemantica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/busca")
public class BuscaController extends HttpServlet{
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		// Buscando os par�metros no request
		String sujeito = request.getParameter("sujeito");
		String predicado = request.getParameter("predicado");
		String objeto = request.getParameter("objeto");
		String uri = request.getParameter("uri");
		
		if (sujeito.equals(" ")) sujeito = "";
		if (predicado.equals(" ")) predicado = "";
		if (objeto.equals(" ")) objeto = "";
		
		System.out.println("Dentro da classe BuscaController " );
		System.out.println("Sujeito: " + sujeito );
		System.out.println("Predicado: " + predicado );
		System.out.println("Objeto: " + objeto );
		
		// Busca no Virtuoso
		BuscaModel dao = new BuscaModel();
		// ArrayList virt é uma lista de objetos BuscaBean
		List<BuscaBean> virt = new ArrayList<BuscaBean>();
		
		//Busca por sujeito, predicado e objeto
		if(!sujeito.equals("") && !predicado.equals("") && !objeto.equals("") && uri.equals("")){
		virt = dao.consulta(sujeito, predicado, objeto);
		}
		
		//Busca por sujeito
		if(!sujeito.equals("") && predicado.equals("") && objeto.equals("") && uri.equals("") ){
			virt = dao.consulta1(sujeito);
		}
		
		
		//Busca por predicado
		if(sujeito.equals("") && !predicado.equals("") && objeto.equals("") && uri.equals("")){
			virt = dao.consulta2(predicado);
		}
		
		//Busca por objeto
		if(sujeito.equals("") && predicado.equals("") && !objeto.equals("") && uri.equals("")){
			String obj = objeto;
			if(!obj.equals("")){
				if(objeto.length() <= 7){
					obj = objeto;
				}else{
					obj = objeto.substring(0, 7);
				}
			}
			
			if(obj.equals("http://")){
				virt = dao.consulta3(objeto);
			}else{
				virt = dao.consulta31(objeto);
			}
		}
		
		//Busca por sujeito e predicado
			if(!sujeito.equals("") && !predicado.equals("") && objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		
		//Busca por sujeito e objeto
			if(!sujeito.equals("") && predicado.equals("") && !objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		//Busca por predicado e objeto
			if(sujeito.equals("") && !predicado.equals("") && !objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		//Busca por uri
				if(sujeito.equals("") && predicado.equals("") && objeto.equals("") && !uri.equals("")){
				virt = dao.consultaUri(uri);
				}
		
		/* TESTE
		// virt contém o resultado da busca
				System.out.println( "Número de objetos BuscaBean no arraylist (virt) do resultado da busca: " + virt.size() );
				System.out.println( "Triplas contidas no objeto BuscaBean" );
				for (BuscaBean tripla : virt) {
					System.out.println( "Sujeito: " + tripla.getSujeito() );
					System.out.println( "Predicado: " + tripla.getPredicado() );
					System.out.println( "Objeto: " + tripla.getObjeto() );
				}
		*/
		
		ConfiguracoesBeans configuracoes = LeituraController.getConfiguracoes();
		String caminho = configuracoes.getCaminhoJson();
		String arquivo = configuracoes.getNomeJson();
		// gerar o arquivo json de saída
		// cria um arquivo JSON para escrita, o false indica que sobrescreve o arquivo existente
		FileWriter escrita = new FileWriter(caminho + arquivo,false);
		// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
		BufferedWriter bE = new BufferedWriter(escrita);
		// cabeçalho do arquivo json
		bE.write("{\"_id\":\"semantic-search-web\",\"_rev\":\"1-b61c63c4e7e2c0fe911f89c1330491e2\",\"sys\":{\"repulsion\":1467,\"friction\":0.5,\"stiffness\":74,\"gravity\":true},\"src\":\";\\n; FAETERJ-Rio (2015)\\n; Search Semantic Web\\n; by Jorge Antonio F. Dargam\\n;by Marcio Pacheco de Lima\\n;\\n; Mecanismo de busca em dados\\n; dispostos em ontologia semântica \\n\\n");
		// escreve sujeito no arquivo JSON de saída
		for (BuscaBean tripla : virt) {
			bE.write(tripla.getSujeito());
			bE.write(" -> ");
			bE.write(tripla.getPredicado());
			bE.write("\\n");
			bE.write(tripla.getPredicado());
			bE.write(" -> ");
			bE.write(tripla.getObjeto());
			bE.write("\\n");
		}
		// rodapé do arquivo json
		bE.write("\\n; endings\\n\"}");
		// encerra buffer de escrita do arquivo json de saída
		bE.close();
		// encerra o acesso ao arquivo json de saída
		escrita.close();
		
		request.setAttribute("lista", virt);
		RequestDispatcher rd = request.getRequestDispatcher("/saida.jsp");  
		rd.forward(request, response); 
		
	}
}