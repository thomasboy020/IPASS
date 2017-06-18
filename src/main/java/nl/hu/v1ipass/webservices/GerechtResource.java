package nl.hu.v1ipass.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import nl.hu.v1ipass.POJO.Gerecht;
import nl.hu.v1ipass.model.ServiceProvider;


@Path("/gerechten")
public class GerechtResource {
	
	@GET
	@Path("/getAll")
	@Produces("application/json")
	public String getGerechten() {
		GerechtService service = ServiceProvider.getGerechtService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Gerecht l : service.getAlleGerechten()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("naam", l.getNaam());
			job.add("allergie_info", l.getAllergieinfo());
			job.add("beschrijving", l.getBeschrijving());
			
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}

