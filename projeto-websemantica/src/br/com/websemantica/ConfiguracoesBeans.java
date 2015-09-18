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
}