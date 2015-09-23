// Gerador aleatório de cor hexadecimal

package br.com.websemantica;

import java.util.ArrayList;
import java.util.Random;

public class CoresBean {
	
	private ArrayList<String> cor = new ArrayList();
	private String corHex = ""; 
	private Random gerador = new Random();
	
	public CoresBean(){
		cor.add("0");
		cor.add("1");
		cor.add("2");
		cor.add("3");
		cor.add("4");
		cor.add("5");
		cor.add("6");
		cor.add("7");
		cor.add("8");
		cor.add("9");
		cor.add("A");
		cor.add("B");
		cor.add("C");
		cor.add("D");
		cor.add("E");
		cor.add("F");
	}
		
	public String getCor (){
		corHex = cor.get(gerador.nextInt(15)) + cor.get(gerador.nextInt(15)) + cor.get(gerador.nextInt(15)) + 
				cor.get(gerador.nextInt(15)) + cor.get(gerador.nextInt(15)) + cor.get(gerador.nextInt(15));
		return corHex;
	}
}
