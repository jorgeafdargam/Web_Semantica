package br.com.websemantica;

import virtuoso.jena.driver.VirtGraph;

public class VirtuosoConn {
	
	// Variável estática que conterá a instância do método
	private static VirtuosoConn conn;
	
	VirtGraph set = new VirtGraph ("jdbc:virtuoso://localhost:1111", "dba", "dba");;
	
	// Construtor privado. Suprime o construtor público padrão
	private VirtuosoConn(){}
	
	// Método público estático de acesso único ao objeto
		public static VirtuosoConn getInstance(){
			if(conn == null) 
			{
				// O valor é retornado para quem está pedindo
				inicializaInstancia();
			}
			// Retorna a instância do objeto
			return conn;
		}
	
		/*
		 * Este metodo é sincronizado para evitar que devido a concorrencia sejam criados mais de
		 * uma instancia.
		 */
		private static synchronized void inicializaInstancia() 
		{
			if (conn == null) 
			{
				conn = new VirtuosoConn();
			}
		}	
		
		public VirtGraph getConn(){
			return set;
		}
}
