package nl.hu.v1ipass.webservices;

import nl.hu.v1ipass.DAO.ReserveringDAO;
import nl.hu.v1ipass.POJO.Reservering;

public class ReserveringService {

	private ReserveringDAO reserveringDAO = new ReserveringDAO();

	public void addReservering(Reservering reservering) {
		reserveringDAO.addReservering(reservering);
	}
	
	public void delete(Reservering reservering) {
		reserveringDAO.deleteReservering(reservering);
	}
}
