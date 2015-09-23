package br.com.websemantica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMontadorPredicado {
	
	CoresBean corHex = new CoresBean();
	
	// ArrayList virt é uma lista de objetos BuscaBean
	List<BuscaBean> virt;

	// obtem as configurações do sistema
	ConfiguracoesBeans configuracoes = LeituraController.getConfiguracoes();

	public JsonMontadorPredicado(List<BuscaBean> virt) throws IOException {
		this.virt = virt;
		this.monta();
	}

	public void monta() throws IOException{	
		
		String caminho = configuracoes.getCaminhoJson();
		String nomejson = configuracoes.getNomeJson();

		// gerar o arquivo json de saída
		// cria um arquivo JSON para escrita, o false indica que sobrescreve o arquivo existente
		FileWriter escrita = new FileWriter(caminho + nomejson,false);
		// abre buffer de memória para escrita que será transferido direto para o arquivo criado acima
		BufferedWriter bE = new BufferedWriter(escrita);
		// cabeçalho do arquivo json
		bE.write(configuracoes.getCabecalho());
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
			String corSO = corHex.getCor();
			bE.write(tripla.getSujeito());
			bE.write(" {color:#" + corSO + "}\\n");
			bE.write(tripla.getPredicado());
			bE.write(" {color:red}\\n");
			bE.write(tripla.getObjeto());
			bE.write(" {color:#" + corSO + "}\\n\\n");
		}
		// rodapé do arquivo json
		bE.write(configuracoes.getRodape());
		// encerra buffer de escrita do arquivo json de saída
		bE.close();
		// encerra o acesso ao arquivo json de saída
		escrita.close();
	}

}