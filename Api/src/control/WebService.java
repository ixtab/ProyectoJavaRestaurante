package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

//import com.google.gson.Gson;

import model.Menu;
import model.Restaurante;

@Path("")

public class WebService {
	@GET
	@Produces({"text/html"})
	public String enviarJSON(@QueryParam("cp") String cp) {
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("App");
		EntityManager em = factoria.createEntityManager();
		TypedQuery<Restaurante> query = em.createQuery("SELECT r FROM Restaurante r WHERE r.codigopostal = " + cp, Restaurante.class);

		List<Restaurante> restaurante = query.getResultList();
		 String msg = "<div id=\"menus\">";
		 
		
		if (restaurante.size()>0) {
			
			for (Restaurante r : restaurante) {
				msg += "<div class=\" card-panel byn flow-text\">";
				msg += "<h3 id=\"nomRestaurante\">" + r.getNombre() +"</h3>";
				msg += "<h5 id=\"contacto\">" + r.getDireccion()+", " + r.getCodigopostal() + ". Tlf: " + r.getTlf() +"</h5>";
				
				msg += "<p id=\"primeros\">Primer plato:</p>"
						+ "<ul>";
				for (Menu m : r.getMenus(r.getIdrestaurante())) {
					
					if(m.getPrimero() != "" && m.getPrimero() != null) {
						msg += "<li>" + m.getPrimero()+"</li>";
					}
					
				}
				msg += "</ul>"
						+ "<p id=\"segundos\">Segundo Plato:</p>"
						+ "<ul>";
				for (Menu m : r.getMenus(r.getIdrestaurante())) {
					
					if(m.getSegundo() != "" && m.getSegundo() != null) {
						msg += "<li>" + m.getSegundo()+"</li>";
					}
				}
				msg += "</ul>";
				msg += "<p id = \"comentarios\">"+ r.getComentariosmenu() + "</p>" ;
				msg += "<p id =\"precio\">Precio: "+ r.getPreciomenu() + " €.</p></div>";
			}

			msg+= "</div>";
		} 
		else {
			msg = "No hay restaurantes en ese Código postal";
		}
		
		return msg;
		
	}
}
