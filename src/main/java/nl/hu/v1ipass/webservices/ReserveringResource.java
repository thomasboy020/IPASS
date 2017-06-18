package nl.hu.v1ipass.webservices;

import nl.hu.v1ipass.POJO.Reservering;
import nl.hu.v1ipass.model.ServiceProvider;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reservering")
public class ReserveringResource {
	ReserveringService reserveringService = ServiceProvider.getReserveringService();

	@POST
	@Produces("application/json")
	public String createReservering(@FormParam("reserveringnummer") int resnr, @FormParam("voornaam") String vnaam,
			@FormParam("achternaam") String anaam, @FormParam("tijd") String tijd,
			@FormParam("geb_datum") String gebdatum, @FormParam("opmerking") String opmerk,
			@FormParam("aantal_personen") int pers, @FormParam("datum") String datum,
			@FormParam("telefoonnr") int telefoonnr, @FormParam("email") String email) {
		Reservering newReservering = new Reservering(resnr, vnaam, anaam, tijd, gebdatum, opmerk, pers, datum,
				telefoonnr, email);
		reserveringService.addReservering(newReservering);
		return reserveringToJson(newReservering).build().toString();
	}

	private JsonObjectBuilder reserveringToJson(Reservering c) {
    JsonObjectBuilder job = Json.createObjectBuilder();
    job.add("reserveringnummer", c.getReserveringnummer());
    job.add("voornaam", c.getVoornaam());
    job.add("achternaam", c.getAchternaam());
    job.add("tijd", c.getTijd());
    job.add("geb_datum", c.getGebdatum());
    job.add("opmerking", c.getOpmerking());
    job.add("aantal_personen", c.getAantalpersonen());
    job.add("datum", c.getDatum());
    job.add("telefoonnr", c.getTelefoonnr());
    job.add("email", c.getEmail());
    return job;
  }
}
