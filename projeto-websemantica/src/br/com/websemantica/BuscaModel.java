package br.com.websemantica;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QueryParseException;
import com.hp.hpl.jena.rdf.model.Model;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

public class BuscaModel {
	//Conecta o virtuoso
	VirtGraph set = new VirtGraph ("jdbc:virtuoso://localhost:1111", "dba", "jorge140");
	String banco = "<test9>";
	
	//M�todo consulta
	public List<BeanRDF> consulta(String sujeito, String predicado, String objeto){
		List<BeanRDF> virt = new ArrayList<BeanRDF>();
		Query sparql = QueryFactory.create();
		String obj = "";
		
		if(!objeto.equals("")){
			if(objeto.length() <= 7){
				obj = objeto;
			}else{
				obj = objeto.substring(0, 7);
			}
		}
		
		if(objeto.indexOf("^") > 0){
			int i = objeto.indexOf("h");
			int j = objeto.length();
			
			String aux1 = objeto.substring(0, i);
			String aux2 = objeto.substring(i, j);
			String aux3 = "<" + aux2 + ">";
			objeto = aux1.concat(aux3);
		}
		//Consulta por sujeito, predicado e objeto
		if(!sujeito.equals("") && !predicado.equals("") && !objeto.equals("")){
			if(obj.equals("http://")){
				try{
					sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
						+ "filter("+"?s = "+"<"+sujeito+">"+") "
						+ " . filter("+"?p = "+"<"+predicado+">"+") "
						+ ". filter("+"?o = "+"<"+objeto+">"+") }");
				}catch(QueryParseException qpe){
					return virt;
				}
				
			}else{
				try{
					sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
						+ "filter("+"?s = "+"<"+sujeito+">"+") "
						+ " . filter("+"?p = "+"<"+predicado+">"+") "
						+ ". filter("+"?o = "+objeto+") }");
				}catch(QueryParseException qpe){
					return virt;
				}
			}
			
		}
		
		
		//Consulta por sujeito e predicado
		if(!sujeito.equals("") && !predicado.equals("") && objeto.equals("")){	
			try{
				sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
					+ "filter("+"?s = "+"<"+sujeito+">"+") "
					+ " . filter("+"?p = "+"<"+predicado+">"+")}"); 
			}catch(QueryParseException qpe){
				return virt;
			}
		}
				
		//Consulta por sujeito e objeto
				if(!sujeito.equals("") && predicado.equals("") && !objeto.equals("")){
					if(obj.equals("http://")){
						try{
							sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
								+ "filter("+"?s = "+"<"+sujeito+">"+") "
								+ " . filter("+"?o = "+"<"+objeto+">"+")}");
						}catch(QueryParseException qpe){
							return virt;
						}
					}else{
						try{
							sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
								+ "filter("+"?s = "+"<"+sujeito+">"+") "
								+ " . filter("+"?o = "+objeto+")}");
						}catch(QueryParseException qpe){
							return virt;
						}
					}
				}
				
		//Consulta por predicado e objeto
		if(sujeito.equals("") && !predicado.equals("") && !objeto.equals("")){
			if(obj.equals("http://")){
				try{
					sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
						+ "filter("+"?p = "+"<"+predicado+">"+") "
						+ " . filter("+"?o = "+"<"+objeto+">"+")}");
				}catch(QueryParseException qpe){
					return virt;
				}
			}else{
				try{
					sparql = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
						+ "filter("+"?p = "+"<"+predicado+">"+") "
						+ " . filter("+"?o = "+objeto+")}");
				}catch(QueryParseException qpe){
					return virt;
				}
			}
		}

			VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);

			Model model = vqe.execDescribe();
	 	        Graph g = model.getGraph();
               
	        	for (Iterator<?> i = g.find(Node.ANY, Node.ANY, Node.ANY); i.hasNext();)
	        	{
	        		BeanRDF mvirt = new BeanRDF();
	        		Triple t = (Triple)i.next();
	        		mvirt.setSujeito(t.getSubject().toString());  
	        		mvirt.setPredicado (t.getPredicate().toString()); 
	        		mvirt.setObjeto (t.getObject().toString());
	        		virt.add(mvirt);		
	        	}
	        	
	        vqe.close();
	        set.close();
	        return virt;
	}
	//Consulta por sujeito
		public List<BeanRDF> consulta1 (String sujeito){
			List<BeanRDF> virt1 = new ArrayList<BeanRDF>();
			Query sparql1=QueryFactory.create();
			try{
			sparql1 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
						+ "filter("+"?s = "+"<"+sujeito+">"+")}");
			}catch(QueryParseException qpe){
				return virt1;
			}
			VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql1, set);

			Model model = vqe.execDescribe();
	 	        Graph g = model.getGraph();
	           
	        	for (Iterator<?> i = g.find(Node.ANY, Node.ANY, Node.ANY); i.hasNext();)
	        	{
	        		BeanRDF mvirt = new BeanRDF();
	        		Triple t = (Triple)i.next();
	        		mvirt.setSujeito(t.getSubject().toString());  
	        		mvirt.setPredicado (t.getPredicate().toString()); 
	        		mvirt.setObjeto (t.getObject().toString());
	        		virt1.add(mvirt);		
	        	}
				
	        vqe.close();
		    set.close();
	        return virt1;
		}
		
		//Consulta por predicado
				public List<BeanRDF> consulta2 (String predicado){
					List<BeanRDF> virt2 = new ArrayList<BeanRDF>();
					Query sparql2 = QueryFactory.create();
					try{
					sparql2 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
								+ "filter("+"?p = "+"<"+predicado+">"+")}");
					}catch(QueryParseException qpe){
						return virt2;
					}
					
					VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql2, set);

					Model model = vqe.execDescribe();
			 	        Graph g = model.getGraph();
			           
			        	for (Iterator<?> i = g.find(Node.ANY, Node.ANY, Node.ANY); i.hasNext();)
			        	{
			        		BeanRDF mvirt = new BeanRDF();
			        		Triple t = (Triple)i.next();
			        		mvirt.setSujeito(t.getSubject().toString());  
			        		mvirt.setPredicado (t.getPredicate().toString()); 
			        		mvirt.setObjeto (t.getObject().toString());
			        		virt2.add(mvirt);
			        	}
			        	
			        vqe.close();
				    set.close();
			        return virt2;
				}
				
				//Consulta por objeto
				public List<BeanRDF> consulta3 (String objeto){
					List<BeanRDF> virt3 = new ArrayList<BeanRDF>();
					Query sparql3 = QueryFactory.create();
					
					try{
						sparql3 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
								+ "filter("+"?o = "+"<"+objeto+">"+")}");
					}catch(QueryParseException qpe){
						return virt3;
					}
					
					VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql3, set);

					Model model = vqe.execDescribe();
			 	        Graph g = model.getGraph();
			           
			        	for (Iterator<?> i = g.find(Node.ANY, Node.ANY, Node.ANY); i.hasNext();)
			        	{
			        		BeanRDF mvirt = new BeanRDF();
			        		Triple t = (Triple)i.next();
			        		mvirt.setSujeito(t.getSubject().toString());  
			        		mvirt.setPredicado (t.getPredicate().toString()); 
			        		mvirt.setObjeto (t.getObject().toString());
			        		virt3.add(mvirt);		
			        	}
			        	
			        vqe.close();
				    set.close();
			        return virt3;
				}
				
				//Consulta por objeto literal
				public List<BeanRDF> consulta31 (String objeto){
					List<BeanRDF> virt31 = new ArrayList<BeanRDF>();
					
					if(objeto.indexOf("^") > 0){
						int i = objeto.indexOf("h");
						int j = objeto.length();
						
						String aux1 = objeto.substring(0, i);
						String aux2 = objeto.substring(i, j);
						String aux3 = "<" + aux2 + ">";
						objeto = aux1.concat(aux3);
					}
					
					Query sparql31 = QueryFactory.create();
					try{
						sparql31 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
								+ "filter("+"?o = "+objeto+")}");
					}catch(QueryParseException qpe){
						return virt31;
					}
					
					VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql31, set);

					Model model = vqe.execDescribe();
			 	        Graph g = model.getGraph();
			           
			        	for (Iterator<?> i = g.find(Node.ANY, Node.ANY, Node.ANY); i.hasNext();)
			        	{
			        		BeanRDF mvirt = new BeanRDF();
			        		Triple t = (Triple)i.next();
			        		mvirt.setSujeito(t.getSubject().toString());  
			        		mvirt.setPredicado (t.getPredicate().toString()); 
			        		mvirt.setObjeto (t.getObject().toString());
			        		virt31.add(mvirt);		
			        	}
			        	
			        vqe.close();
				    set.close();
			        return virt31;
				}
				
				//Consulta por uri
				public List<BeanRDF> consultaUri(String uri){
					List<BeanRDF> virt4 = new ArrayList<BeanRDF>();
					Query sparql4 = QueryFactory.create();
					try{
						sparql4 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
							+ "filter("+"?s = "+"<"+uri+">"+")}");
					}catch(QueryParseException qpe){
						return virt4;
					}
						
					VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql4, set);
					Model model = vqe.execDescribe();
		 	        Graph g = model.getGraph();
		 	        String sujeito = "";
		 	        
		 	       for (Iterator<?> s = g.find(Node.ANY, Node.ANY, Node.ANY); s.hasNext();)
		        	{
		        		Triple t = (Triple)s.next();
		        		sujeito = (t.getSubject().toString());
		        		if(sujeito.equals("")){
		        			break;
		        		}else{
		        			BeanRDF mvirt = new BeanRDF();
		        			mvirt.setSujeito(t.getSubject().toString());  
		        			mvirt.setPredicado (t.getPredicate().toString()); 
		        			mvirt.setObjeto (t.getObject().toString());
		        			virt4.add(mvirt);		
				        	
		        		}
		        	}
		 	       
		 	       if(!sujeito.equals("")){
		 	    	   vqe.close();
		 		       set.close();
		 	    	   return virt4;
		 	       }
		 	       
		 	      virt4 = new ArrayList<BeanRDF>();
		 	      try{
		 	    	  sparql4 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
							+ "filter("+"?p = "+"<"+uri+">"+")}");
		 	     }catch(QueryParseException qpe){
						return virt4;
					}
		 	    	  
					vqe = VirtuosoQueryExecutionFactory.create (sparql4, set);
					model = vqe.execDescribe();
		 	        g = model.getGraph();
		 	        
		 	       for (Iterator<?> s = g.find(Node.ANY, Node.ANY, Node.ANY); s.hasNext();)
		        	{
		        		Triple t = (Triple)s.next();
		        		sujeito = (t.getSubject().toString());
		        		if(sujeito.equals("")){
		        			break;
		        		}else{
		        			BeanRDF mvirt = new BeanRDF();
		        			mvirt.setSujeito(t.getSubject().toString());  
		        			mvirt.setPredicado (t.getPredicate().toString()); 
		        			mvirt.setObjeto (t.getObject().toString());
		        			virt4.add(mvirt);		
				        	
		        		}
		        	}
		 	        
		 	      if(!sujeito.equals("")){
		 	    	 vqe.close();
		 	    	 set.close();
		 	    	 return virt4;
		 	       }
		 	     virt4 = new ArrayList<BeanRDF>();
		 	     
		 	     try{
		 	    	 sparql4 = QueryFactory.create("SELECT * FROM "+banco+" WHERE { ?s ?p ?o . "
							+ "filter("+"?o = "+"<"+uri+">"+")}");
		 	     }catch(QueryParseException qpe){
					return virt4;
				 }
		 	    	 
					vqe = VirtuosoQueryExecutionFactory.create (sparql4, set);
					model = vqe.execDescribe();
		 	        g = model.getGraph();
		 	        
		 	       for (Iterator<?> s = g.find(Node.ANY, Node.ANY, Node.ANY); s.hasNext();)
		        	{
		        		Triple t = (Triple)s.next();
		        		sujeito = (t.getSubject().toString());
		        		if(sujeito.equals("")){
		        			break;
		        		}else{
		        			BeanRDF mvirt = new BeanRDF();
		        			mvirt.setSujeito(t.getSubject().toString());  
		        			mvirt.setPredicado (t.getPredicate().toString()); 
		        			mvirt.setObjeto (t.getObject().toString());
		        			virt4.add(mvirt);		
				        	
		        		}
		        	}
		 	       
		 	       	vqe.close();
			        set.close();
					return virt4;
				
			}
}
