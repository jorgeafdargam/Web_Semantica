package br.com.websemantica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMontador {
	// obtem as configurações do sistema
	ConfiguracoesBeans configuracoes = LeituraController.getConfiguracoes();

	private JsonBean json;
	// ArrayList virt é uma lista de objetos BuscaBean
	List<BuscaBean> virt;
	
	public JsonMontador(JsonBean json, List<BuscaBean> virt) throws IOException {
		this.json = json;
		this.virt = virt;
		this.monta();
	}

	public void monta() throws IOException{		
		
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
	
	// gerar o arquivo json de saída
	// cria um arquivo JSON para escrita, o false indica que sobrescreve o arquivo existente
	String caminho = configuracoes.getCaminhoJson();
	String nomejson = configuracoes.getNomeJson();
	FileWriter escrita = new FileWriter(caminho + nomejson,false);
	// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
	BufferedWriter bE = new BufferedWriter(escrita);
	// cabeçalho do arquivo json
	bE.write("{\"_id\":\"semantic-search-web\",\"_rev\":\"1-b61c63c4e7e2c0fe911f89c1330491e2\",\"sys\":{\"repulsion\":2600,\"friction\":0.5,\"stiffness\":512,\"gravity\":true},\"src\":\";\\n; FAETERJ-Rio (2015)\\n; Search Semantic Web\\n; by Jorge Antonio F. Dargam\\n;by Marcio Pacheco de Lima\\n;\\n; Mecanismo de busca em dados\\n; dispostos em ontologia semântica \\n\\n");
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
	}
	
}