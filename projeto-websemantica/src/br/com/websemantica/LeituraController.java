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

	public LeituraController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recebe nome do arquivo
		String nome_arq = request.getParameter("inpuFile");
		// le arquivo
		FileReader leitura = new FileReader("/home/dell/Documentos/" + nome_arq);
		// insere o arquivo no buffer de memória
		BufferedReader bL = new BufferedReader(leitura);
		// cria um arquivo para escrita, o false indica que sobrescreve o arquivo existente
		FileWriter escrita = new FileWriter("/home/dell/Documentos/texto.json",false);
		// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
		BufferedWriter bE = new BufferedWriter(escrita);

		// cria um HashSet de Strings, a diferença é performance e não permite elementos duplicados
		HashSet<String> listaNomes = new HashSet<String>(); // arquivo completo
		HashSet<String> listaNomes_suj = new HashSet<String>(); // só os sujeitos
		HashSet<String> listaNomes_pred = new HashSet<String>(); // só os predicados
		HashSet<String> listaNomes_obj = new HashSet<String>(); // só os objetos

		String sujeito = null;
		String predicado = null;
		String objeto = null;

		// cabeçalho do arquivo json
		bE.write("{\"_id\":\"python-grammar\",\"_rev\":\"1-b51a39ec5ab3eb1fe22191f07fd08afb\",\"sys\":{\"repulsion\":2600,\"friction\":0.5,\"stiffness\":512,\"gravity\":false},\"src\":\";\\n; Grammar of the Python language\\n; transcribed from nick siegler's diagram:\\n; flickr.com/photos/nicksieger/281055485\\n;\\n\\n");

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
			bE.write(sujeito + " -> ");
			bE.write(predicado + "\\n");
			bE.write(predicado + " -> ");
			bE.write(objeto + "\\n");
		}
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