package br.com.websemantica;

import java.io.BufferedReader;
import java.io.FileReader;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

public class ImportaRdf {

	public static void main(String[] args) {
		
		try {
			System.out.println("Lendo arquivo dataset.");
			/* inserir o caminho do arquivo dataset */
			FileReader leitura = new FileReader("/home/dell/Documentos/geonames_links_reduzido.nt");
			System.out.println("Arquivo dataset lido.");
			System.out.println("Abrinfo buffer de memória para leitura do dataset.");
			BufferedReader bL = new BufferedReader(leitura);
			System.out.println("Buffer de memória criado.");
			System.out.println("Conectando ao Banco de Dados Virtuoso.");
			/* especificar nome do grafo a ser criado no Virtuoso (geonames). usuário (dba) e senha (dba). */
			/* não alterar a conexão do BD Virtuoso */
			VirtGraph set = new VirtGraph ("geonames","jdbc:virtuoso://localhost:1111", "dba", "dba");
			set.getTransactionHandler().begin();
			System.out.println("Banco de dados conectado. Iniciando transferência do dataset.");
			int cont=0;
			while (true) {
				String l = bL.readLine();
				if (l == null){
					break;
				}
				cont++;
				String str = "INSERT INTO GRAPH <geonames> {";
				VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str+l+"}", set);
                vur.exec(); 
				System.out.println(cont + " : " + str + l + "}");
			}
			System.out.println("Encerrada a transferência do dataset ao Banco de Dados Virtuoso.");
			System.out.println("Transferidas " + cont + " triplas RDF do dataset para o banco de dados.");
			set.getTransactionHandler().commit();
			bL.close();
			leitura.close();
		} catch (Exception e) {
			System.out.println("Erro no sistema. Exceção gerada.");
			e.printStackTrace();
		}
	}
}