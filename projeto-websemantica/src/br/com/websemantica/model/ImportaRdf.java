package br.com.websemantica.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

@WebServlet("/ImportaDataset")
public class ImportaRdf extends HttpServlet {
	
	public ImportaRdf() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// configurações do dataset
			// recebe caminho do arquivo
			String path = request.getParameter("inputPath");
			System.out.println("Caminho do arquivo dataset recebido: " + path);
			// recebe nome do arquivo
			String nome_arq = request.getParameter("inpuFile");
			System.out.println("Caminho do arquivo dataset recebido: " + nome_arq);
			
			System.out.println("Lendo arquivo dataset.");
			/* inserir o caminho do arquivo dataset */
			FileReader leitura = new FileReader(path + nome_arq);
			System.out.println("Arquivo dataset lido.");
			System.out.println("Abrinfo buffer de memória para leitura do dataset.");
			BufferedReader bL = new BufferedReader(leitura);
			System.out.println("Buffer de memória criado.");
			System.out.println("Conectando ao Banco de Dados Virtuoso.");
			
			// configurações do BD Virtuoso
			// recebe porta do BD Virtuoso
			int door =  Integer.parseInt(request.getParameter("inputPorta"));
			// recebe usuario do BD Virtuoso
			String user = request.getParameter("inputUser");
			// recebe senha do BD Virtuoso
			String pass = request.getParameter("inputPassword");
			// recebe senha do BD Virtuoso
			String grafo = request.getParameter("inputGrafo");
			
			/* especificar nome do grafo a ser criado no Virtuoso (geonames). usuário (dba) e senha (dba). */
			/* não alterar a conexão do BD Virtuoso */
			VirtGraph set = new VirtGraph (grafo,"jdbc:virtuoso://localhost:" + door, user, pass);
			set.getTransactionHandler().begin();
			System.out.println("Banco de dados conectado. Iniciando transferência do dataset.");
			int cont=0;
			while (true) {
				String l = bL.readLine();
				if (l == null){
					break;
				}
				cont++;
				String str = "INSERT INTO GRAPH <" + grafo + "> {";
				VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str+l+"}", set);
                vur.exec(); 
				System.out.println(cont + " : " + str + l + "}");
			}
			System.out.println("Encerrada a transferência do dataset ao Banco de Dados Virtuoso.");
			System.out.println("Transferidas " + cont + " triplas RDF do dataset para o banco de dados.");
			set.getTransactionHandler().commit();
			bL.close();
			leitura.close();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Busca.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro no sistema. Exceção gerada.");
			e.printStackTrace();
		}
	}
}