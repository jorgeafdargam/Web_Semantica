package br.com.websemantica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMontador {
	// ArrayList virt é uma lista de objetos BuscaBean
	List<BuscaBean> virt;
	
	// obtem as configurações do sistema
	ConfiguracoesBeans configuracoes = LeituraController.getConfiguracoes();
	
	public JsonMontador(List<BuscaBean> virt) throws IOException {
		this.virt = virt;
		this.monta();
	}

	public void monta() throws IOException{		
	
	// gerar o arquivo json de saída
	// cria um arquivo JSON para escrita, o false indica que sobrescreve o arquivo existente
	String caminho = configuracoes.getCaminhoJson();
	String nomejson = configuracoes.getNomeJson();
	FileWriter escrita = new FileWriter(caminho + nomejson,false);
	// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
	BufferedWriter bE = new BufferedWriter(escrita);
	// cabeçalho do arquivo json
	bE.write("{\"_id\":\"semantic-search-web\",\"_rev\":\"1-b61c63c4e7e2c0fe911f89c1330491e2\",\"sys\":{\"repulsion\":" + configuracoes.getRepulsao() + ",\"friction\":" + configuracoes.getFriccao() + ",\"stiffness\":" + configuracoes.getTensao() + ",\"gravity\":true},\"src\":\";\\n; FAETERJ-Rio (2015)\\n; Search Semantic Web\\n; by Jorge Antonio F. Dargam\\n; by Marcio Pacheco de Lima\\n;\\n; Mecanismo de busca em dados\\n; dispostos em ontologia semântica \\n\\n; Código das cores:\\n; Sujeito: " + configuracoes.getCor_sujeito() + "\\n; Predicado: " + configuracoes.getCor_predicado() + "\\n; Objeto: " + configuracoes.getCor_objeto() + "\\n\\n");
	// escreve sujeito no arquivo JSON de saída
	for (BuscaBean tripla : virt) {
		// atribuição de relacionamentos
		bE.write(tripla.getSujeito());
		bE.write(" -> ");
		bE.write(tripla.getPredicado());
		bE.write("\\n");
		bE.write(tripla.getPredicado());
		bE.write(" -> ");
		bE.write(tripla.getObjeto());
		bE.write("\\n");
		// atribuição de cores
		bE.write(tripla.getSujeito());
		bE.write(" {color:" + configuracoes.getCor_sujeito() + "}\\n");
		bE.write(tripla.getPredicado());
		bE.write(" {color:" + configuracoes.getCor_predicado() + "}\\n");
		bE.write(tripla.getObjeto());
		bE.write(" {color:" + configuracoes.getCor_objeto() + "}\\n\\n");
	}
	// rodapé do arquivo json
	bE.write("\\n; endings\\n\"}");
	// encerra buffer de escrita do arquivo json de saída
	bE.close();
	// encerra o acesso ao arquivo json de saída
	escrita.close();
	}
	
}