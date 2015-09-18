package br.com.websemantica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JsonBeanController")
public class JsonBeanController extends HttpServlet {
	
	private JsonBean json;
	
	// ponto de obtenção do objeto JsonBean pelo JsonMontador
	public JsonBean getJson() {
		return json;
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		json = new JsonBean();
		// recebe parâmetro do jsp e envia para o objeto JsonBean
		json.setCaminho(request.getParameter("inputPath"));
		
		
	}
	
}