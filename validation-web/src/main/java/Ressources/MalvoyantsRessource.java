package Ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

import entities.valeurs;
import services.malvoyantsServiceLocal;

@Path("/malvoyants")
@RequestScoped
public class MalvoyantsRessource {

	@PersistenceContext
	EntityManager em;

	@EJB
	malvoyantsServiceLocal ms;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/get")
	public String hello() {
		String x = ms.test();
		return x;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getnode/{id}")
	public Response getNode(@PathParam(value = "id") int id) {
		List<valeurs> x = ms.getNodeValues(id);
		return Response.ok(x).build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addValue/{codeCapteur}/{message}")
	public String addValue(@PathParam(value = "codeCapteur") String codeCapteur,
			@PathParam(value = "message") String message) {

		if (!(codeCapteur.equals("") && message.equals(""))) {
			ms.ajouterValeurs(codeCapteur, message);
			return "added";
		} else
			return "failed";

	}

}
