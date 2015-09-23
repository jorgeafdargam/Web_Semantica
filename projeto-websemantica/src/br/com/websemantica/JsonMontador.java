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
			
			// SUJEITO
			// a rotina abaixo captura somente o sujeito descartando a IRI
			int a = 0;
			int j = 0;
			String suj = tripla.getSujeito();
			for ( int i=0; i<suj.length(); i++ ) {
				char c = suj.charAt(i);
					if ( c == '/' ) {
						j++;
						if ( j == 4 ){
							a=i;
							break;
						}
					}
			}
			String suj2 = suj.substring(++a, suj.length());
			bE.write(suj2);
			bE.write(" -> ");
			
			// PREDICADO
			// esta rotina obtém a posição do caracter # com a finalidade de 
			// isolar a informação do predicado, descartando o restante da IRI
			int b = 0;
			String pred = tripla.getPredicado();
			for ( int i=0; i<pred.length(); i++ ) {
				char c = pred.charAt(i);
					if ( c=='#' ) {
						b=i;
						break;
					}
			}
			String pred2 = pred.substring(++b, pred.length());
			bE.write(pred2);
			bE.write("\\n");
			bE.write(pred2);
			bE.write(" -> ");
			
			// OBJETO
			int d = 0;
			int k = 0;
			String obj = tripla.getObjeto();
			for ( int i=0; i<obj.length(); i++ ) {
				char c = obj.charAt(i);
					if ( c == '/' ) {
						k++;
						if ( k == 3 ){
							d=i;
							break;
						}
					}
			}
			String obj2 = obj.substring(++d, (obj.length() - 1));
			bE.write(obj2);
			bE.write("\\n");
			
			// atribuição de cores
			bE.write(suj2);
			bE.write(" {color:" + configuracoes.getCor_sujeito() + "}\\n");
			bE.write(pred2);
			bE.write(" {color:" + configuracoes.getCor_predicado() + "}\\n");
			bE.write(obj2);
			bE.write(" {color:" + configuracoes.getCor_objeto() + "}\\n\\n");
		}
		// rodapé do arquivo json
		bE.write(configuracoes.getRodape());
		// encerra buffer de escrita do arquivo json de saída
		bE.close();
		// encerra o acesso ao arquivo json de saída
		escrita.close();
	}

}