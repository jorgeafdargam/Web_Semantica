package br.com.websemantica;

import java.util.ArrayList;
import java.util.Random;

public class CoresBean {
	
	private ArrayList<String> cor = new ArrayList();
	private String corHex = ""; 
	private Random gerador = new Random();
	
	public CoresBean(){
		cor.add("00");
		cor.add("33");
		cor.add("66");
		cor.add("99");
		cor.add("AA");
		cor.add("CC");
		cor.add("FF");
	}
		
	public String getCor (){
		corHex = cor.get(gerador.nextInt(7)) + cor.get(gerador.nextInt(7)) + cor.get(gerador.nextInt(7));
		return corHex;
	}
}
