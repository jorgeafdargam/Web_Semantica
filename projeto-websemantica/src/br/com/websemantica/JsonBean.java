package br.com.websemantica;

public class JsonBean {
	
	private String caminho;
	private String nome;
	private String cabecalho1 = "{\"_id\":\"third-planet-from-altair\",\"_rev\":\"1-ee5599bcde8a1592f71eb00281360dd6\",\"sys\":{";
	private String cabecalho;
	private String cor_sujeito;
	private String cor_predicado;
	private String cor_objeto;
	private int tensao = 512;
	private int repulsao = 2600;
	private double friccao = 0.5;
	private boolean gravidade = true;
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
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
	public boolean isGravidade() {
		return gravidade;
	}
	public void setGravidade(boolean gravidade) {
		this.gravidade = gravidade;
	}

}