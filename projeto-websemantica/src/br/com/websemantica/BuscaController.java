package br.com.websemantica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/busca")
public class BuscaController extends HttpServlet{
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		// Buscando os par�metros no request
		String sujeito = request.getParameter("sujeito");
		String predicado = request.getParameter("predicado");
		String objeto = request.getParameter("objeto");
		String uri = request.getParameter("uri");
		
		
		// Busca no Virtuoso
		BuscaModel dao = new BuscaModel();
		List<BeanRDF> virt = new ArrayList<BeanRDF>();
		
		//Busca por sujeito, predicado e objeto
		if(!sujeito.equals("") && !predicado.equals("") && !objeto.equals("") && uri.equals("")){
		virt = dao.consulta(sujeito, predicado, objeto);
		}
		
		//Busca por sujeito
		if(!sujeito.equals("") && predicado.equals("") && objeto.equals("") && uri.equals("") ){
			virt = dao.consulta1(sujeito);
		}
		
		
		//Busca por predicado
		if(sujeito.equals("") && !predicado.equals("") && objeto.equals("") && uri.equals("")){
			virt = dao.consulta2(predicado);
		}
		
		//Busca por objeto
		if(sujeito.equals("") && predicado.equals("") && !objeto.equals("") && uri.equals("")){
			String obj = objeto;
			if(!obj.equals("")){
				if(objeto.length() <= 7){
					obj = objeto;
				}else{
					obj = objeto.substring(0, 7);
				}
			}
			
			if(obj.equals("http://")){
				virt = dao.consulta3(objeto);
			}else{
				virt = dao.consulta31(objeto);
			}
		}
		
		//Busca por sujeito e predicado
			if(!sujeito.equals("") && !predicado.equals("") && objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		
		//Busca por sujeito e objeto
			if(!sujeito.equals("") && predicado.equals("") && !objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		//Busca por predicado e objeto
			if(sujeito.equals("") && !predicado.equals("") && !objeto.equals("") && uri.equals("")){
				virt = dao.consulta(sujeito, predicado, objeto);
			}
		//Busca por uri
				if(sujeito.equals("") && predicado.equals("") && objeto.equals("") && !uri.equals("")){
				virt = dao.consultaUri(uri);
				}
			
		request.setAttribute("lista", virt);
		RequestDispatcher rd = request.getRequestDispatcher("/saida.jsp");  
		rd.forward(request, response); 
		
	}
}
