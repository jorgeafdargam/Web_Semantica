package br.com.websemantica;

public class ConfiguracoesBeans {
	
	private String nomeDataset;
	private String caminhoDataset;
	
	private String nomeJson;
	private String caminhoJson;
	
	private String userVirtuoso;
	private int portaVirtuoso;
	private String passwordVirtuoso;
	private String grafoVirtuoso = "<geonames>";
	
	private String cabecalho;
	private String rodape;
	private String cor_sujeito = "green";
	private String cor_predicado = "red";
	private String cor_objeto = "gray";
	private int tensao = 512;
	private int repulsao = 2600;
	private double friccao = 0.5;
	private String gravidade = "false";
	private int limitador;
	
	public String getNomeDataset() {
		return nomeDataset;
	}
	public void setNomeDataset(String nomeDataset) {
		this.nomeDataset = nomeDataset;
	}
	public String getCaminhoDataset() {
		return caminhoDataset;
	}
	public void setCaminhoDataset(String caminhoDataset) {
		this.caminhoDataset = caminhoDataset;
	}
	public String getNomeJson() {
		return nomeJson;
	}
	public void setNomeJson(String nomeJson) {
		this.nomeJson = nomeJson;
	}
	public String getCaminhoJson() {
		return caminhoJson;
	}
	public void setCaminhoJson(String caminhoJson) {
		this.caminhoJson = caminhoJson;
	}
	public String getUserVirtuoso() {
		return userVirtuoso;
	}
	public void setUserVirtuoso(String userVirtuoso) {
		this.userVirtuoso = userVirtuoso;
	}
	public int getPortaVirtuoso() {
		return portaVirtuoso;
	}
	public void setPortaVirtuoso(int portaVirtuoso) {
		this.portaVirtuoso = portaVirtuoso;
	}
	public String getPasswordVirtuoso() {
		return passwordVirtuoso;
	}
	public void setPasswordVirtuoso(String passwordVirtuoso) {
		this.passwordVirtuoso = passwordVirtuoso;
	}
	public String getGrafoVirtuoso() {
		return grafoVirtuoso;
	}
	public void setGrafoVirtuoso(String grafoVirtuoso) {
		this.grafoVirtuoso = grafoVirtuoso;
	}
	public String getCabecalho() {
		cabecalho = "{\"_id\":\"semantic-search-web\",\"_rev\":\"1-b61c63c4e7e2c0fe911f89c1330491e2\",\"sys\":{\"repulsion\":" + repulsao + ",\"friction\":" + friccao + ",\"stiffness\":" + tensao + ",\"gravity\":" + gravidade + "},\"src\":\";\\n; FAETERJ-Rio (2015)\\n; Search Semantic Web\\n; by Jorge Antonio F. Dargam\\n; by Marcio Pacheco de Lima\\n;\\n; Mecanismo de busca em dados\\n; dispostos em ontologia semântica \\n\\n; Código das cores:\\n; Sujeito: " + cor_sujeito + "\\n; Predicado: " + cor_predicado + "\\n; Objeto: " + cor_objeto + "\\n\\n";
		return cabecalho;
	}
	public String getCor_sujeito() {
		return cor_sujeito;
	}
	public void setCor_sujeito(String cor_sujeito) {
		this.cor_sujeito = cor_sujeito;
	}
	public String getCor_predicado() {
		return cor_predicado;
	}
	public void setCor_predicado(String cor_predicado) {
		this.cor_predicado = cor_predicado;
	}
	public String getCor_objeto() {
		return cor_objeto;
	}
	public void setCor_objeto(String cor_objeto) {
		this.cor_objeto = cor_objeto;
	}
	public int getTensao() {
		return tensao;
	}
	public void setTensao(int tensao) {
		this.tensao = tensao;
	}
	public int getRepulsao() {
		return repulsao;
	}
	public void setRepulsao(int repulsao) {
		this.repulsao = repulsao;
	}
	public double getFriccao() {
		return friccao;
	}
	public void setFriccao(double friccao) {
		this.friccao = friccao;
	}
	public String getGravidade() {
		return gravidade;
	}
	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}
	public String getRodape() {
		rodape = "\\n; endings\\n\"}";
		return rodape;
	}
	public void setRodape(String rodape) {
		this.rodape = rodape;
	}
	public int getLimitador() {
		return limitador;
	}
	public void setLimitador(int limitador) {
		this.limitador = limitador;
	}
}