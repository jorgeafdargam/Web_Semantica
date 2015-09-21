// realiza a leitura do arquivo enviado por Busca.jsp

package br.com.websemantica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeituraController")
public class LeituraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ConfiguracoesBeans configuracoes;
	
	// ponto de acesso àss configurações
	public static ConfiguracoesBeans getConfiguracoes(){
		return configuracoes;
	}

	public LeituraController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		configuracoes = new ConfiguracoesBeans();
		
		// configurações do dataset
		// recebe caminho do arquivo
		String path = request.getParameter("inputPath");
		configuracoes.setCaminhoDataset(path);
		// recebe nome do arquivo
		String nome_arq = request.getParameter("inpuFile");
		configuracoes.setNomeDataset(nome_arq);
		
		// configurações do BD Virtuoso
		// recebe porta do BD Virtuoso
		int door =  Integer.parseInt(request.getParameter("inputPorta"));
		configuracoes.setPortaVirtuoso(door);
		// recebe usuario do BD Virtuoso
		String user = request.getParameter("inputUser");
		configuracoes.setUserVirtuoso(user);
		// recebe senha do BD Virtuoso
		String pass = request.getParameter("inputPassword");
		configuracoes.setPasswordVirtuoso(pass);
		
		// Configurações do arquivo json de saída
		// recebe caminho do arquivo json de saída
		String jsonPath = request.getParameter("inputPathOut");
		configuracoes.setCaminhoJson(jsonPath);
		// recebe nome do arquivo json de saída
		String jsonArch = request.getParameter("inpuFileOut");
		configuracoes.setNomeJson(jsonArch);
		// recebe cor do sujeito
		String corsuj = request.getParameter("inputColorSuj");
		configuracoes.setCor_sujeito(corsuj);
		// recebe cor do predicado
		String corpred = request.getParameter("inputColorPred");
		configuracoes.setCor_predicado(corpred);
		// recebe cor do objeto
		String corobj = request.getParameter("inputColorObj");
		configuracoes.setCor_objeto(corobj);

		// le arquivo
		FileReader leitura = new FileReader(path + nome_arq);
		// insere o arquivo no buffer de memória
		BufferedReader bL = new BufferedReader(leitura);
		// cria um arquivo JSON para escrita, o false indica que sobrescreve o arquivo existente
		FileWriter escrita = new FileWriter(jsonPath + jsonArch,false);
		// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
		BufferedWriter bE = new BufferedWriter(escrita);
		
		// cria um HashSet de Strings, a diferença é performance e não permite elementos duplicados
		HashSet<String> listaNomes = new HashSet<String>(); // arquivo completo
		HashSet<String> listaNomes_suj = new HashSet<String>(); // só os sujeitos
		HashSet<String> listaNomes_pred = new HashSet<String>(); // só os predicados
		HashSet<String> listaNomes_obj = new HashSet<String>(); // só os objetos
		
		String sujeito = " ";
		String predicado = " ";
		String objeto = " ";
		
		listaNomes_suj.add(sujeito);
		listaNomes_pred.add(predicado);
		listaNomes_obj.add(objeto);
		
		// cabeçalho do arquivo json
		bE.write("{\"_id\":\"third-planet-from-altair\",\"_rev\":\"1-ee5599bcde8a1592f71eb00281360dd6\",\"sys\":{\"repulsion\":2600,\"friction\":0.5,\"stiffness\":512,\"gravity\":true},\"src\":\";\\n;\\n;\\n;\\n;\\n;\\n; FAETERJ-Rio (2015)\\n; Search Semantic Web\\n; Jorge Antonio F. Dargam\\n; Marcio Pacheco de Lima\\n\\n; Mecanismo de busca em dados \\n; dispostos em ontologia semântica\\n; \\n; Identificação das cores: \\n;  Vermelho: Sujeito \\n;  Amarelo: Predicado \\n;  Azul: Objeto \\n \\n; relacionamentos:\\n ");
		
		//while (true) {
		int y=0;
		while (y <= 20) {
			y++;
			// lê linha do arquivo no buffer de memória
			String l = bL.readLine();
			if (l == null){
				break;
			}
			listaNomes.add(l);
			sujeito = l.substring(1, l.indexOf(">"));
			l = l.replace("<" + sujeito + "> ", "");
			predicado = l.substring(1, l.indexOf(">"));
			l = l.replace("<" + predicado + "> ", "");
			objeto = l.substring(1, l.indexOf(">"));
			// adiciona sujeito, predicado e objeto aos respectivos HashSet
			listaNomes_suj.add(sujeito);
			listaNomes_pred.add(predicado);
			listaNomes_obj.add(objeto);
			// adiciona no arquivo o sujeito, predicado e objeto
			bE.write(sujeito);
			bE.write(" -> ");
			bE.write(predicado);
			bE.write("\\n");
			bE.write(predicado);
			bE.write(" -> ");
			bE.write(objeto);
			bE.write("\\n");
		}
		// rodapé do arquivo JSON
		bE.write("\",\"example\":\"cyoa\",\"title\":\"Third Planet from Altair\"}");
		// encerra buffer de memória
		bL.close();
		// encerra o acesso ao arquivo
		leitura.close();
		// encerra buffer de escrita
		bE.close();
		// encerra o acesso ao arquivo
		escrita.close();
		// imprime o array
		System.out.println(listaNomes_suj);
		System.out.println(listaNomes_pred);
		System.out.println(listaNomes_obj);
		
		request.setAttribute("sujeito", listaNomes_suj);
		request.setAttribute("predicado", listaNomes_pred);
		request.setAttribute("objeto", listaNomes_obj);
		request.setAttribute("arquivo", nome_arq);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("entradaSPO.jsp");  
		dispatcher.forward(request, response); 
	}
}