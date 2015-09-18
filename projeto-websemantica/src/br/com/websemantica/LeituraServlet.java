package br.com.websemantica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeituraServlet")
public class LeituraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LeituraServlet() {
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
		// cria um HashSet de Strings, a diferença é performance e não permite elementos duplicados
		HashSet<String> listaNomes = new HashSet<String>(); // arquivo completo
		HashSet<String> listaNomes_suj = new HashSet<String>(); // só os sujeitos
		HashSet<String> listaNomes_pred = new HashSet<String>(); // só os predicados
		HashSet<String> listaNomes_obj = new HashSet<String>(); // só os objetos
		// cria uma array de Strings, a desvantagem é que permite elementos duplicados
		//ArrayList<String> listaNomes = new ArrayList<String>();
		String sujeito = null;
		String predicado = null;
		String objeto = null;
		//while (true) {
		int y=0;
		while (y <= 20) {
			y++;
			// lê linha do arquivo no buffer de memória
			String l = bL.readLine();
			if (l == null){
				break;
			}
			sujeito = l.substring(1, l.indexOf(">"));
			predicado = l.substring(l.indexOf(">"), l.indexOf("> <h"));
			//objeto = l.substring(l.indexOf("> <h"), l.indexOf("> ."));
			// exibe linha de arquivo no console
			//System.out.println(l);
			// exibe sujeito no console
			//System.out.println(sujeito);
			// adiciona linha de arquivo no array
			listaNomes.add(l);
			listaNomes_suj.add(sujeito);
			listaNomes_pred.add(predicado);
			//listaNomes_obj.add(objeto);
		}
		// encerra buffer de memória
		bL.close();
		// encerra o acesso ao arquivo
		leitura.close();
		// ordena o array
		//Collections.sort(listaNomes);
		// imprime o array
		System.out.println(listaNomes_suj);
		System.out.println(listaNomes_pred);
		//System.out.println(listaNomes_obj);
	}

}
